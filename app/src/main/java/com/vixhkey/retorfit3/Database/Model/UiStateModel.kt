package com.vixhkey.retorfit3.Database.Model

data class UiStateModel (
    val commentsModel:List<CommentsModel>? = null,
    val userModel:UserModel? = null,
    val isLoading: Boolean = false
)