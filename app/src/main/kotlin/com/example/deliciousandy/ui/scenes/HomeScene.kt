package com.example.deliciousandy.ui.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.R
import com.example.deliciousandy.data.repos.RecipeRepository
import com.example.deliciousandy.ui.components.RecipeCard

@Composable
fun HomeScene() {
    val ctx = LocalContext.current
    val repository = RecipeRepository(ctx = ctx)

    val recipes = repository.loadRecipes()

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        if (recipes.isNotEmpty()) {
            LazyColumn {
                items(recipes) { recipe ->
                    RecipeCard(recipe = recipe)
                }
            }
        } else {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.no_data),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
fun HomeScenePreview() {
    HomeScene()
}
