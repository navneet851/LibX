package com.android.app.libx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.app.libx.presentation.ui.screens.LoginScreen
import com.android.app.libx.presentation.ui.screens.ProfileScreen
import com.android.app.libx.presentation.ui.screens.RegisterScreen

@Composable
fun MyNavHost(navController: NavHostController, startDestination: String) {

    NavHost(navController, startDestination = startDestination){
        composable("login") {
            LoginScreen(navController)
        }
        composable("register"){
            RegisterScreen(navController)
        }
        composable(Routes.Home.route) {

        }
        composable(Routes.Profile.route){
            ProfileScreen()
        }
        composable(Routes.Search.route){

        }
        composable(Routes.Library.route){

        }
        composable(Routes.Admin.route){

        }
    }

}