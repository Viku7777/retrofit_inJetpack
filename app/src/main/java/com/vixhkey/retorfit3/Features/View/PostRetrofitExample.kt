package com.vixhkey.retorfit3.Features.View

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vixhkey.retorfit3.Database.ApiState
import com.vixhkey.retorfit3.VIewModels.AppVIewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostRetrofitExampleVIew(navController: NavHostController, appViewmodel: AppVIewModel) {
    val apiState = appViewmodel.postUserState.collectAsState()
    val context = LocalContext.current

    var nameController by rememberSaveable {
        mutableStateOf("")
    }


    var jobController by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Post Retrofit Examples") }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            })
        }
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .padding(15.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    nameController = it;
                }, value = nameController, label = { Text("Name") })
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    jobController = it;
                }, value = jobController, label = { Text("Job") })
            Spacer(Modifier.height(20.dp))
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ElevatedButton({


                    if (nameController.isNotEmpty() && jobController.isNotEmpty()) {

                        appViewmodel.postUser(nameController, jobController)
                    } else {
                        Toast.makeText(context, "Please fill all the values", Toast.LENGTH_LONG)
                            .show()

                    }
                }) { Text("Post Data") }
            }


            Spacer(Modifier.height(20.dp))
            ElevatedButton({
                appViewmodel.asyncExample()
            }) { Text("Async Example")}
            Spacer(Modifier.height(20.dp))

            when (val state = apiState.value) {
                is ApiState.Default -> Text("Default")
                is ApiState.Loading -> CircularProgressIndicator()
                is ApiState.Error -> Text("Error ==> ${state.error}")
                is ApiState.Success -> Text("Success ==> ${state.data.job}")


            }
        }


    }

}

