package com.example.deliciousandy.data

data class AppData(
    var username: String = "",
    var recipeList: List<Recipe> = listOf()
)