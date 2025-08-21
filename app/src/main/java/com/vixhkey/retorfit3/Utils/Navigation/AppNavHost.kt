package com.vixhkey.retorfit3.Utils.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vixhkey.retorfit3.Features.View.GetRetrofitExampleVIew
import com.vixhkey.retorfit3.Features.View.HomeScreen
import com.vixhkey.retorfit3.Features.View.PostRetrofitExampleVIew
import com.vixhkey.retorfit3.VIewModels.AppVIewModel

@Composable
fun AppNavHost(navController: NavHostController,appViewmodel: AppVIewModel) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.PostExample.route
    ) {
        // Home Screen
        composable(NavRoutes.Home.route) {
            HomeScreen(navController)
        }
        // Home Screen
        composable(NavRoutes.GetExample.route) {
            GetRetrofitExampleVIew(navController,appViewmodel)
        }
        // Home Screen
        composable(NavRoutes.PostExample.route) {
            PostRetrofitExampleVIew(navController,appViewmodel)
        }


    }
}
