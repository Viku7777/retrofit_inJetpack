package com.vixhkey.retorfit3.Features.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


//vIewModel: AppVIewModel = viewModel()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){

    Scaffold(
topBar = {TopAppBar(title = {Text("Retrofit Examples")})}
    ) {
        inner ->
        Column (Modifier.padding(inner).padding(15.dp)) {
            Text("This is the Demo Retrofit Examples", style = TextStyle(fontSize = 20.sp))
            Spacer(Modifier.height(20.dp))
            ElevatedButton({
                navController.navigate(NavRoutes.GetExample.route)
            }) {
                Text("Get Example")
            }
            Spacer(Modifier.height(20.dp))
            ElevatedButton({
                navController.navigate(NavRoutes.PostExample.route)

            }) {
                Text("Post Example")
            }
            Spacer(Modifier.height(20.dp))


        }


    }

}