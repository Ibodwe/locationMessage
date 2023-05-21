package com.example.messagebylocationapp.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messagebylocationapp.LocationManager
import com.example.messagebylocationapp.map.MapScreen
import com.example.messagebylocationapp.route.NavigationRoute
import com.example.messagebylocationapp.userinputmessage.SelectLocationMapScreen
import com.example.messagebylocationapp.userinputmessage.UserInputMessageScreen

@Composable
fun MainScreen(locationManager: LocationManager) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.Map.route) {
        composable(NavigationRoute.Map.route) {
            MapScreen(
                locationManager = locationManager,
                viewModel = viewModel(),
                navigateMessageInputScreen = {
                    navController.navigate(NavigationRoute.InputUserMessage.route)
                }
            )
        }
        composable(NavigationRoute.InputUserMessage.route) {
            UserInputMessageScreen(
                navigateBack = { navController.popBackStack() },
                navigateSelectLocation = { navController.navigate(NavigationRoute.LocationSelectMap.route) }
            )
        }
        composable(NavigationRoute.LocationSelectMap.route) {
            SelectLocationMapScreen(clickSaveBtn = { navController.popBackStack() })
        }
    }
}