package com.example.deliciousandy.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.data.Recipe

@Composable
fun RecipeCard(recipe: Recipe) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium, shadowElevation = 5.dp

    ) {
        Column(
            modifier = Modifier
                .clickable {
                    isExpanded = !isExpanded

                }
        ) {
            Text(text = recipe.name)
        }

    }
}