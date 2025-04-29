package com.example.retrofi.model

data class Post(
    val id: Int? = null,  // Nullable để dùng cho POST (id do server tự sinh)
    val userId: Int,
    val title: String,
    val body: String
)

