package com.vixhkey.retorfit3.Database.Network

import com.vixhkey.retorfit3.Database.Model.CommentsModel
import com.vixhkey.retorfit3.Database.Model.CreateUserRequest
import com.vixhkey.retorfit3.Database.Model.UserModel
import com.vixhkey.retorfit3.Utils.AppUrls.AppUrls
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiServices {
     @GET(AppUrls.GetCommentURL)
     suspend fun GetCommentApiService(): List<CommentsModel>

     @GET(AppUrls.GetCommentURL)
     suspend fun GetCommentApiServiceWithQuery(@Query("postId")postId:Int): List<CommentsModel>

     @GET("${AppUrls.GetCommentURL}/{id}")
     suspend fun  getPostWithId (@Path("id") count: Int) : CommentsModel

     @POST(AppUrls.postUsers)
     @Headers("Content-Type: application/json") // optional; Gson sets it anyway
     suspend fun PostUserService(
          @Body body: CreateUserRequest,
          @Header("x-api-key") apiKey: String = "reqres-free-v1",
          ): UserModel

}