package com.aamirashraf.navigationincompose

sealed class Screen(val route:String){
    //only the class inside the sealed class can inherit the sealed class
    data object MainScreen:Screen("main_screen")
    data object DetailedScreen:Screen("detail_screen")

    //lets understand little bit about vararg also in kotlin
    /*


    In the Kotlin programming language,
     vararg is a keyword used to define a variable number of arguments in a function parameter.
     It allows a function to accept an arbitrary number of arguments of a specified type.
    val result1 = withArgs("one", "two", "three")
    val result2 = withArgs("apple", "orange", "banana", "grape")
    fun withArgs(vararg arg: String): String {
        // 'arg' is an array of Strings
        return arg.joinToString(", ")  // Join the strings with a comma and space
    }

     */



    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach {arg->
                append("/$arg")

            }
        }
    }
}