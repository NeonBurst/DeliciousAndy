package com.example.deliciousandy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.R
import com.example.deliciousandy.data.models.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe
) {
    var isExpanded by remember { mutableStateOf(false) }
    val horizontalPadding = if (isExpanded) 16.dp else 0.dp

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        if (isExpanded) {
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth() // Make the Text take the full width
                    .padding(bottom = 8.dp) // Add bottom padding for separation
                    .padding(horizontal = horizontalPadding)
            )
        }

        Image(
            modifier = Modifier
                .padding(horizontal = horizontalPadding),
            painter = painterResource(R.drawable.test_spagetti),
            contentDescription = stringResource(R.string.picture_of) + recipe.name
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .padding(horizontal = horizontalPadding),
            horizontalArrangement = if (isExpanded) Arrangement.End else Arrangement.Absolute.SpaceBetween,

            ) {
            if (!isExpanded) {
                Text(
                    text = recipe.name,
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(id = R.string.serving_size),
                )
                Text(
                    text = recipe.servingSize.toString(),
                )
            }
        }

        if (isExpanded) {
            Text(
                text = recipe.body,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding), // Make the Text take the full width
            )

            Row {
                IconBtn(
                    imageVector = Icons.Default.Star,
                    tint = if (recipe.starred) Color.Yellow else Color.Black,
                    contentDescription = stringResource(R.string.favourite),
                ) { println("Star Pressed") }

                IconBtn(
                    imageVector = Icons.Default.Edit,
                    tint = Color.Black,
                    contentDescription = stringResource(R.string.edit),
                ) { println("Edit Pressed") }

                IconBtn(
                    imageVector = Icons.Default.Delete,
                    tint = Color.Black,
                    contentDescription = stringResource(R.string.delete),
                ) { println("Delete Pressed") }
            }
        }
    }
}

@Composable
@Preview
fun RecipeCardPreview() {
    val recipe = Recipe(
        name = "Spaghetti",
        body = "Very good"
    )
    RecipeCard(recipe = recipe)
}
