package com.example.retrofi.api

import com.example.retrofi.model.Post

interface ApiService {
    // READ
    @GET("posts")
    suspend fun getAllPosts(): List<Post>

    // CREATE
    @POST("posts")
    suspend fun createPost(@Body post: Post): Post

    // UPDATE
    @PUT("posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body post: Post): Post

    // DELETE
    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id: Int)
}