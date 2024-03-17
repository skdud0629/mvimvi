package com.example.mvimvi.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvimvi.feature.random.RandomScreen
import com.example.mvimvi.feature.main.MainScreen


@Composable
fun RandomScreenNavigator() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.MAIN.name,
        modifier = Modifier.padding(16.dp)
    ) {

        composable(
            route = AppScreen.MAIN.name
        ) {
            MainScreen(
                randomNum = {
                    navController.navigate("${AppScreen.RANDOM.name}/$it")
                }
            )
        }

        composable(
            route = "${AppScreen.RANDOM.name}/{maxNumber}",
            arguments = listOf(navArgument("maxNumber") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val maxNumber = backStackEntry.arguments?.getInt("maxNumber") ?: 0
            RandomScreen(MaxNumber = maxNumber)
        }

    }
}