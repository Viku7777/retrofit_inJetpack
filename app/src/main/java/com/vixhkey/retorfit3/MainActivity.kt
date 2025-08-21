package com.vixhkey.retorfit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vixhkey.retorfit3.Features.View.HomeScreen
import com.vixhkey.retorfit3.Utils.Navigation.AppNavHost
import com.vixhkey.retorfit3.VIewModels.AppVIewModel
import com.vixhkey.retorfit3.ui.theme.Retorfit3Theme
import kotlin.getValue

class MainActivity : ComponentActivity() {

    private val appViewmodel by viewModels<AppVIewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController = navController,appViewmodel)

        }
    }
}
