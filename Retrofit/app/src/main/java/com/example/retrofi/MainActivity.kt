package com.example.retrofi

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init ViewModel
        viewModel = ViewModelProvider(this)[PostViewModel::class.java]

        // Setup RecyclerView
        adapter = PostAdapter(
            onItemClick = { post -> showEditDialog(post) },
            onDeleteClick = { id -> viewModel.deletePost(id) }
        )
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        // Observe LiveData
        viewModel.posts.observe(this) { posts ->
            adapter.submitList(posts)
        }

        viewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        // Load data
        viewModel.loadPosts()

        // Handle FAB click
        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener {
            showAddDialog()
        }
    }

    private fun showAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_post, null)
        AlertDialog.Builder(this)
            .setTitle("Add New Post")
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                val newPost = Post(
                    userId = 1,
                    title = dialogView.findViewById<EditText>(R.id.etTitle).text.toString(),
                    body = dialogView.findViewById<EditText>(R.id.etBody).text.toString()
                )
                viewModel.addPost(newPost)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}