package com.vixhkey.retorfit3.VIewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vixhkey.retorfit3.Database.ApiState
import com.vixhkey.retorfit3.Database.Model.CommentsModel
import com.vixhkey.retorfit3.Database.Model.UiStateModel
import com.vixhkey.retorfit3.Database.Model.UserModel
import com.vixhkey.retorfit3.Database.Repository.RetroRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log

class AppVIewModel: ViewModel() {
    private val _commnetapiState = MutableStateFlow<ApiState<List<CommentsModel>>>(ApiState.Default)
    val commentApiState : StateFlow<ApiState<List<CommentsModel>>> = _commnetapiState;

    private val _postUserState = MutableStateFlow<ApiState<UserModel>>(ApiState.Default)
    val postUserState : StateFlow<ApiState<UserModel>> = _postUserState;

    private val _uiStateModel = MutableStateFlow(UiStateModel())
    val uiStateModel : StateFlow<UiStateModel> = _uiStateModel.asStateFlow()

    var repo : RetroRepository= RetroRepository

    fun getComments(){
        viewModelScope.launch {

            try {
                _commnetapiState.value = ApiState.Loading
                 val data=   repo.GetComments()
                _commnetapiState.value= ApiState.Success(data)

            }catch (e: Exception){
                Log.e("Api Response","Error =>${e.message}")
                _commnetapiState.value = ApiState.Error(e.message?:"Unknown Error")

            }
        }
    }
    fun getComments1(){
        viewModelScope.launch {

            try {
                _uiStateModel.update { state -> state.copy (isLoading = true) }
                _commnetapiState.value = ApiState.Loading
                 val data=   repo.GetComments()

                //_commnetapiState.value= ApiState.Success(data)
                _uiStateModel.update { state -> state.copy(
                    commentsModel  = data,
                    isLoading = false
                )}
               /* _uiStateModel.update { state -> state.copy {
                    commentsModel = ApiState.Success(data)
                } }*/
                //_uiStateModel.value= ApiState.Success(data)

            }catch (e: Exception){
                Log.e("Api Response","Error =>${e.message}")
                _commnetapiState.value = ApiState.Error(e.message?:"Unknown Error")

            }
        }
    }

    fun postUser(name: String,job: String){
        viewModelScope.launch {

            try {
                _postUserState.value = ApiState.Loading
                val data=   repo.PostUser(name,job)
                _postUserState.value= ApiState.Success(data)

            }catch (e: Exception){
                Log.e("Api Response","Error =>${e.message}")
                _postUserState.value = ApiState.Error(e.message?:"Unknown Error")

            }
        }
    }

    fun asyncExample(){
        viewModelScope.launch {
            Log.e("Async","Start")
            // parent
            val user = async { delay(5000)
                return@async "Vikrant" }  // child 1
            Log.e("Async","Start 1")

            val posts = async { delay(2000) } // child 2

            // parent waits until both children finish
            Log.e("Async","User: ${user.await()}, Posts: ${posts.await()}")

        }

    }

    fun getCommentsWithQuery(){
        viewModelScope.launch {

            try {
                _commnetapiState.value = ApiState.Loading
                val data=   repo.GetCommentsWithQuery()
                _commnetapiState.value= ApiState.Success(data)

            }catch (e: Exception){
                Log.e("Api Response","Error =>${e.message}")
                _commnetapiState.value = ApiState.Error(e.message?:"Unknown Error")

            }
        }
    }



}