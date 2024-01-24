package com.example.deliciousandy.ui.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.R
import com.example.deliciousandy.data.models.Recipe
import com.example.deliciousandy.data.repos.RecipeRepository
import com.example.deliciousandy.ui.components.FancyTextField

@Composable
fun AddScene(
    onExit: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val ctx = LocalContext.current
        val repository = RecipeRepository(ctx = ctx)

        Column {
            Text(
                text = stringResource(R.string.add_recipe),
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )

            var titleText by remember { mutableStateOf("") }
            FancyTextField(
                value = titleText,
                placeHolderText = stringResource(R.string.recipe_name)
            ) { newText ->
                titleText = newText
            }

            Divider(modifier = Modifier.size(20.dp), color = Color.Transparent)

            var bodyText by remember { mutableStateOf("") }
            FancyTextField(
                value = bodyText,
                placeHolderText = stringResource(R.string.recipe_instructions),
                maxLines = 99
            ) { newText ->
                bodyText = newText
            }

            var servingSize by remember { mutableStateOf("") }

            FancyTextField(
                value = servingSize,
                placeHolderText = stringResource(R.string.serving_size),
                keyboardType = KeyboardOptions(keyboardType = KeyboardType.Number)
            ) { newText ->
                servingSize = newText
            }

            Row {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFAB6B6B6)
                    ),
                    onClick = onExit
                ) {
                    Text(stringResource(R.string.cancel))
                }

                Divider(modifier = Modifier.size(20.dp), color = Color.Transparent)

                Button(
                    onClick = {
                        repository.addRecipe(
                            Recipe(
                                titleText,
                                bodyText,
                                servingSize = servingSize.toInt()
                            )
                        )
                        onExit()
                    }
                ) {
                    Text(stringResource(R.string.add))
                }
            }
        }
    }
}

@Preview
@Composable
fun AddScenePreview() {
    AddScene {}
}
