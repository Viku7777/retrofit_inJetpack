package com.vixhkey.retorfit3.Database.Repository

import com.vixhkey.retorfit3.Database.Model.CommentsModel
import com.vixhkey.retorfit3.Database.Model.CreateUserRequest
import com.vixhkey.retorfit3.Database.Model.UserModel
import com.vixhkey.retorfit3.Database.Network.RetorfitInstance

object RetroRepository {

    suspend fun GetComments(): List<CommentsModel>{
        return RetorfitInstance.Api.GetCommentApiService()
    }

    suspend fun GetCommentsWithQuery(): List<CommentsModel>{
        return RetorfitInstance.Api.GetCommentApiServiceWithQuery(2)
    }

    suspend fun PostUser(name: String,job: String): UserModel{
        return RetorfitInstance.Api.PostUserService(CreateUserRequest(name,job))
    }
}