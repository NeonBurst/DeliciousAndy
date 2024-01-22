package com.example.deliciousandy.data.models

data class AppData(
    var username: String = "",
    var recipeList: List<Recipe> = listOf()
)