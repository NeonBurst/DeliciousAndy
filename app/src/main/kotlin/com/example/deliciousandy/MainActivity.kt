package com.example.deliciousandy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.components.RecipeCard
import com.example.deliciousandy.data.AppData
import com.example.deliciousandy.data.Recipe
import com.example.deliciousandy.ui.theme.DeliciousAndyTheme
import com.example.deliciousandy.utility.ConverterJSON

// Add delete recipe
// Add view recipe
// Add edit recipe

class MainActivity : ComponentActivity() {

    private var recipeList: List<Recipe> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
        update()
    }

    private fun update() {
        setContent {
            DeliciousAndyTheme {
                var showAddUI: Boolean by remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Scaffold(

                    floatingActionButton = {
                        FloatingActionButton(onClick = { showAddUI = !showAddUI }) {
                            Icon(Icons.Filled.Add, "Add button")
                        }
                    },
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background

                ) { padding ->

                    Column {
                        Text(" Recipes", style = MaterialTheme.typography.titleLarge)

                        LazyColumn {
                            items(recipeList) { sample ->
                                RecipeCard(sample)

                            }
                        }

                    }



                }

                if (showAddUI) {
                    Card(
                        modifier = Modifier
                        .fillMaxSize()) {
                        Column {
                            Text(
                                text = "Add Recipe",
                                modifier = Modifier
                                    .padding(16.dp),
                                textAlign = TextAlign.Center,
                            )

                            var titleText by remember { mutableStateOf("") }
                            TextField(
                                value = titleText,
                                onValueChange = { newText ->
                                    titleText = newText
                                },
                                label = { Text(text = "Recipe Name") },
                                maxLines = 1

                            )

                            Divider(modifier = Modifier.size(20.dp), color = Color.Transparent)

                            var bodyText by remember { mutableStateOf("") }
                            TextField(
                                value = bodyText,
                                onValueChange = { newText ->
                                    bodyText = newText
                                },
                                label = { Text(text = "Recipe Instructions") },

                                )

                            ActivityResultContracts.PickVisualMedia()

                            Button(onClick = {
                                addRecipe(Recipe(titleText, bodyText))
                                showAddUI = false
                            }) {
                                Text("Add")
                            }
                        }


                    }
                }

            }
        }
    }

    private fun addRecipe(recipe: Recipe) {
        recipeList += recipe
        /*val j = ConverterJSON()
        println(j.convertRecipeJSON(recipe))
        j.saveJsonToFile(j.convertRecipeJSON(recipe), "recipe.json", this)
        println("Hi Jason" + j.loadJsonFromFile("recipe.json", this))*/

        val converterJSON = ConverterJSON()
        converterJSON.saveJsonToFile(
            converterJSON.convertRecipeJSON(AppData("U", recipeList)),
            "data.json",
            this
        )
        update()
    }

    private fun loadData() {
        val converterJSON = ConverterJSON()

        val dataJson = converterJSON.loadJsonFromFile("data.json", this)

        if (dataJson != null) {
            val data = converterJSON.convertJsonToUserData(dataJson)


            recipeList = data.recipeList
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeliciousAndyTheme {
        Greeting("Android")
    }
}