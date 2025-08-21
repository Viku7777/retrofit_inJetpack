package com.vixhkey.retorfit3.Features.View

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vixhkey.retorfit3.Database.ApiState
import com.vixhkey.retorfit3.VIewModels.AppVIewModel
import kotlin.getValue
import kotlin.setValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetRetrofitExampleVIew(navController: NavHostController,appViewmodel: AppVIewModel){
val apiState = appViewmodel.commentApiState.collectAsState()
//val uiStateModel = appViewmodel.uiStateModel.collectAsState()

    Scaffold(
        topBar = {TopAppBar(title = {Text("Get Retrofit Examples")},   navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        })}

    ) {
            inner ->
        Column (Modifier.padding(inner).padding(15.dp)) {
            ElevatedButton({
                appViewmodel.getComments()
            }) { Text("Call Api")}

            ElevatedButton({
                appViewmodel.getCommentsWithQuery()
            }) { Text("Call Api With Query")}

            Spacer(Modifier.height(20.dp))
            when(val state =apiState.value) {
                is ApiState.Default -> Text("Default")
                is ApiState.Loading -> CircularProgressIndicator()
                is ApiState.Error -> Text("Error ==> ${state.error}")
                is ApiState.Success ->Text("Success ==> ${state.data.first().email}")


            }

           /* if(uiStateModel.isLoading){

            }

            if(uiStateModel.commentsModel!=null){
                Text("Success ==> ${uiStateModel.commentsModel.first().email}")
            }*/



        }


    }

}