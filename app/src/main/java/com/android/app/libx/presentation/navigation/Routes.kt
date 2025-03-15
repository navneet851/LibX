package com.android.app.libx.presentation.navigation

import com.android.app.libx.R

sealed class Routes(
    val label : String,
    val route : String,
    val selectedIcon : Int,
    val unselectedIcon : Int
) {
    data object Home : Routes("Home", "home", R.drawable.home_fill, R.drawable.home)
    data object Search : Routes("Search", "search", R.drawable.search, R.drawable.search)
    data object Library : Routes("Library", "library", R.drawable.library, R.drawable.library)
    data object Profile : Routes("Profile", "profile", R.drawable.profile_fill, R.drawable.profile)
    data object Admin : Routes("Admin", "admin", R.drawable.shield, R.drawable.shield_h)
}