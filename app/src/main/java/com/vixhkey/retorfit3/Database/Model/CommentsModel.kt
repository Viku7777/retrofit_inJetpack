package com.vixhkey.retorfit3.Database.Model

data class CommentsModel(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)