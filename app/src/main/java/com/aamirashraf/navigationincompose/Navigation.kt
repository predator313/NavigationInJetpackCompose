package com.aamirashraf.navigationincompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
){
    val navHostController= rememberNavController()
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route){
        
    }
}