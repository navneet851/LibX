package com.android.app.libx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.app.libx.presentation.ui.screens.AdminScreen
import com.android.app.libx.presentation.ui.screens.LibraryScreen
import com.android.app.libx.presentation.ui.screens.LoginScreen
import com.android.app.libx.presentation.ui.screens.ProfileScreen
import com.android.app.libx.presentation.ui.screens.RegisterScreen
import com.android.app.libx.presentation.ui.screens.SearchScreen

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
            ProfileScreen(navController)
        }
        composable(Routes.Search.route){
            SearchScreen()
        }
        composable(Routes.Library.route){
            LibraryScreen()
        }
        composable(Routes.Admin.route){
            AdminScreen()
        }
    }

}