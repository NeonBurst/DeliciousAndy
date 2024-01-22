package com.example.deliciousandy.data

data class Recipe(
    val name: String,
    val body: String,
    val servingSize: Int = 1,
    var starred: Boolean = false
)