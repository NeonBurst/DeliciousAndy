package com.example.deliciousandy.data

import com.example.deliciousandy.data.Recipe

data class AppData(
    var username: String = "",
    var recipeList: List<Recipe> = listOf()
)