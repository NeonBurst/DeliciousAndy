package com.example.deliciousandy.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
        if (isExpanded) {
            Card(
                modifier = Modifier
                    .fillMaxSize() // Make the Card take the full available space
                    .clickable {
                        isExpanded = !isExpanded
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize() // Make the Column take the full available space
                        .padding(16.dp), // Add padding for better aesthetics
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth() // Make the Text take the full width
                            .padding(bottom = 8.dp) // Add bottom padding for separation
                    )
                    Text(
                        text = recipe.body,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth() // Make the Text take the full width
                    )
                }
            }

        }
    }

}