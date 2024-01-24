package com.example.deliciousandy.data.repos

import android.content.Context
import com.example.deliciousandy.data.models.AppData
import com.example.deliciousandy.data.models.Recipe
import com.example.deliciousandy.utility.ConverterJSON

class RecipeRepository(
    private val ctx: Context,
    private val converterJSON: ConverterJSON = ConverterJSON(),
) {
    fun loadRecipes(): List<Recipe> {
        val dataJson: String? = converterJSON.loadJsonFromFile("data.json", ctx)

        return dataJson?.let { json ->
            val data = converterJSON.convertJsonToUserData(json)
            return data.recipeList
        } ?: emptyList()
    }

    fun addRecipe(recipe: Recipe): Recipe {
        var recipeList = loadRecipes()
        recipeList += recipe

        converterJSON.saveJsonToFile(
            converterJSON.convertRecipeJSON(AppData("U", recipeList)),
            "data.json",
            ctx
        )
        return recipe
    }
}
