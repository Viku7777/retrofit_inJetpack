package com.vixhkey.retorfit3.Database.Model



data class CreateUserRequest(
    val name: String,
    val job: String
)
data class UserModel(
    val createdAt: String,
    val id: String,
    val job: String,
    val name: String
)