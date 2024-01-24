package com.aamirashraf.navigationincompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(
) {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navHostController)
        }

        //we also pass arguments in the detail screen navigation
        composable(route=Screen.DetailedScreen.route+"/{name}",  //"/{name} means this is compulsory argument like urls
            arguments = listOf(
                navArgument("name"){
                    type= NavType.StringType
                }
            )
            ){entry->
            DetailScreen(name =entry.arguments?.getString("name") )
        }

    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                      navController.navigate(Screen.DetailedScreen.withArgs(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Detail Screen")
        }
    }
}

//this section is about the some basic concept of the navigation in compose
//i need to do some more project in navigation in compose

@Composable
fun DetailScreen(
    name:String?
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Hello $name")
    }
}