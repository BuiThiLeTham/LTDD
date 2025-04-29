package com.example.retrofi.repository

class PostRepository {
    private val api = RetrofitClient.apiService

    // CRUD Operations
    suspend fun getAllPosts(): List<Post> = api.getAllPosts()
    suspend fun createPost(post: Post): Post = api.createPost(post)
    suspend fun updatePost(id: Int, post: Post): Post = api.updatePost(id, post)
    suspend fun deletePost(id: Int) = api.deletePost(id)
}