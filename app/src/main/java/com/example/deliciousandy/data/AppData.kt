package com.example.deliciousandy.data

data class AppData(
    var username: String = "U",
    var recipeList: List<Recipe> = listOf()
)