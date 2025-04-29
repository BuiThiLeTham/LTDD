package com.example.retrofi.adapter

class PostAdapter(
    private val onItemClick: (Post) -> Unit,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var postList = emptyList<Post>()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.apply {
                findViewById<TextView>(R.id.tvTitle).text = post.title
                findViewById<TextView>(R.id.tvBody).text = post.body

                setOnClickListener { onItemClick(post) }
                findViewById<Button>(R.id.btnDelete).setOnClickListener {
                    post.id?.let { id -> onDeleteClick(id) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount() = postList.size

    fun submitList(newList: List<Post>) {
        postList = newList
        notifyDataSetChanged()
    }
}