package com.aamirashraf.navigationincompose

sealed class Screen(val route:String){
    //only the class inside the sealed class can inherit the sealed class
    object MainScreen:Screen("main_screen")
    object DetailedScreen:Screen("detail_screen")
}