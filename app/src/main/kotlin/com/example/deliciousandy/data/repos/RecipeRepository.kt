package com.example.deliciousandy.data.repos

import android.content.Context
import android.widget.Toast
import com.example.deliciousandy.R
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

    // TODO: add recipe returns recipe that is added
}
