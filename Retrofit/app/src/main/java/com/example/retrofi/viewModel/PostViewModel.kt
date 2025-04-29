package com.example.retrofi.viewModel
class PostViewModel : ViewModel() {
    private val repository = PostRepository()
    val posts = MutableLiveData<List<Post>>()
    val errorMessage = MutableLiveData<String>()

    // Load all posts
    fun loadPosts() {
        viewModelScope.launch {
            try {
                posts.value = repository.getAllPosts()
            } catch (e: Exception) {
                errorMessage.value = "Failed to load posts: ${e.message}"
            }
        }
    }

    // Add new post
    fun addPost(post: Post) {
        viewModelScope.launch {
            try {
                repository.createPost(post)
                loadPosts() // Refresh list
            } catch (e: Exception) {
                errorMessage.value = "Failed to add post: ${e.message}"
            }
        }
    }
}
