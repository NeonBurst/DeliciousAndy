package com.example.deliciousandy.ui.scenes.home

import androidx.lifecycle.ViewModel
import com.example.deliciousandy.data.models.Recipe
import com.example.deliciousandy.data.repos.RecipeRepository

class HomeViewModel(
    private val repository: RecipeRepository
) : ViewModel() {
    fun loadRecipes(): List<Recipe> =
        repository.loadRecipes()
}
