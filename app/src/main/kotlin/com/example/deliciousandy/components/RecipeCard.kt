package com.example.deliciousandy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.R
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
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.test_spagetti),
                    contentDescription = "Food Picture"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = recipe.name, modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "People",
                        modifier = Modifier.weight(0.2f)
                    )
                    Text(text = recipe.servingSize.toString(), modifier = Modifier.weight(0.8f))
                }
                
            }
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

                    Image(
                        painter = painterResource(R.drawable.test_spagetti),
                        contentDescription = "Food Picture",
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )

                    Text(
                        text = recipe.body,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth() // Make the Text take the full width
                    )

                    Row {
                        IconButton(
                            onClick = {
                                println("Star")},
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                tint = if (recipe.starred) Color.Yellow else Color.Black,
                                contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = {println("No")},
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                tint = Color.Black,
                                contentDescription = ""
                            )
                        }
                        IconButton(
                            onClick = {println("No")},
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                tint = Color.Black,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }
}


