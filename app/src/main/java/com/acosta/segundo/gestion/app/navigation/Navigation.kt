package com.acosta.segundo.gestion.app.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.acosta.segundo.gestion.app.screens.AppDetailScreen
import com.acosta.segundo.gestion.app.screens.AppListScreen
import com.acosta.segundo.gestion.app.screens.OptimizationScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "appList") {
        composable("appList") {
            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate("appDetail/$appId")
                },
                onOptimizeClick = {
                    navController.navigate("optimize")
                }
            )
        }
        composable("appDetail/{appId}") { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId")
            AppDetailScreen(appId = appId)
        }
        composable("optimize") {
            OptimizationScreen()
        }
    }
}