package com.android.app.libx

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.app.libx.domain.entities.Response
import com.android.app.libx.presentation.navigation.MyNavHost
import com.android.app.libx.presentation.navigation.Routes
import com.android.app.libx.presentation.ui.components.Loader
import com.android.app.libx.presentation.ui.theme.BlackShaded
import com.android.app.libx.presentation.ui.theme.LibXTheme
import com.android.app.libx.presentation.viewmodel.AuthViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.Black.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(Color.Black.toArgb())
        )
        setContent {
            LibXTheme {

                val navController = rememberNavController()
                val navStack by navController.currentBackStackEntryAsState()
                val currentRoute = navStack?.destination?.route

                val authViewModel: AuthViewmodel = hiltViewModel()
                val user by authViewModel.user.collectAsState()

                val isAdmin by authViewModel.admin.collectAsState()

                LaunchedEffect(key1 = Unit) {
                    authViewModel.getUser()
                }


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black,
                    topBar = {
                        AnimatedVisibility(
                            visible = (currentRoute != "login" && currentRoute != "register"),
                            enter = slideInVertically(initialOffsetY = { -it }),
                            exit = slideOutVertically(targetOffsetY = { -it }),
                        ) {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(text = "LibX")
                                },
                                expandedHeight = 50.dp,
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Color.Black
                                )
                            )
                        }
                    },
                    bottomBar = {
                        val navItems = mutableListOf(
                            Routes.Home,
                            Routes.Search,
                            Routes.Library,
                            Routes.Profile,
                        )
                        if (isAdmin) {
                            navItems.add(2, Routes.Admin)
                        }



                        AnimatedVisibility(
                            visible = (currentRoute != "login" && currentRoute != "register" && currentRoute != null),
                            enter = slideInVertically(initialOffsetY = { it }),
                            exit = slideOutVertically(targetOffsetY = { it }),
                        ) {
                            BottomAppBar(
                                containerColor = Color.Black,
                                modifier = Modifier
                                    .height(85.dp)
                                    .border(
                                        width = Dp.Hairline,
                                        color = BlackShaded,
                                        shape = GenericShape { size, _ ->
                                            moveTo(0f, 0f)
                                            lineTo(size.width, 0f)
                                            lineTo(size.width, 2.dp.value)
                                            lineTo(0f, 2.dp.value)
                                            close()
                                        }
                                    )
                            ) {
                                navItems.forEach { item ->
                                    NavigationBarItem(

                                        selected = currentRoute == item.route,
                                        onClick = {
                                            if (currentRoute != item.route) {
                                                navController.navigate(item.route)
                                            }

                                        },
                                        icon = {
                                            Icon(
                                                painter = painterResource(
                                                    id =
                                                        if (currentRoute == item.route) item.selectedIcon else item.unselectedIcon
                                                ),
                                                contentDescription = item.label,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Color.White,
                                            selectedTextColor = Color.White,
                                            unselectedIconColor = Color.LightGray,
                                            unselectedTextColor = Color.LightGray,
                                            indicatorColor = Color.Transparent
                                        ),
                                        label = {
                                            Text(
                                                text = item.label,
                                                fontSize = 11.sp,
                                                lineHeight = 1.sp
                                            )
                                        },
                                        alwaysShowLabel = true
                                    )
                                }
                            }
                        }
                    }
                )

                {

                    when (user) {
                        is Response.Loading -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Loader()
                            }
                        }

                        is Response.Success -> {
                            Box(modifier = Modifier.padding(it)) {
                                if ((user as Response.Success).data.user.role == "Admin") {
                                    authViewModel.setAdmin(true)
                                }
                                MyNavHost(navController, Routes.Home.route)
                            }

                        }

                        is Response.Error -> {
                            Box(modifier = Modifier.padding(it)) {
                                MyNavHost(navController, "login")
                            }
                        }
                    }
                }
            }
        }
    }
}