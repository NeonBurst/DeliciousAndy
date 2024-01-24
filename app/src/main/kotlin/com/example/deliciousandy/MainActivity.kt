package com.example.deliciousandy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.deliciousandy.ui.components.IconBtn
import com.example.deliciousandy.ui.scenes.AddScene
import com.example.deliciousandy.ui.scenes.HomeScene
import com.example.deliciousandy.ui.theme.DeliciousAndyTheme

// Add delete recipe
// Add view recipe
// Add edit recipe

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        update()
    }

    private fun update() {
        setContent {
            DeliciousAndyTheme {
                var showAddUI: Boolean by remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { TopAppBar(title = { Text(getString(R.string.recipes)) }) },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { showAddUI = !showAddUI }) {
                            Icon(Icons.Filled.Add, getString(R.string.add))
                        }
                    },
                    bottomBar = { BottomAppBar(
                        actions = {
                            IconBtn(imageVector = Icons.Filled.Home, tint = Color.Black, contentDescription = getString(
                                R.string.home
                            )) {
                                println("Home")
                            }
                            IconBtn(imageVector = Icons.Filled.Info, tint = Color.Black, contentDescription = getString(
                                R.string.info
                            )) {

                            }
                            IconBtn(imageVector = Icons.Filled.Settings, tint = Color.Black, contentDescription = getString(
                                R.string.settings
                            )) {

                            }
                      }
                    )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    containerColor = MaterialTheme.colorScheme.background

                ) { padding ->
                    HomeScene(padding)
                }

                if (showAddUI) {
                    AddScene()
                    /*Card(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column {
                            Text(
                                text = getString(R.string.add_recipe),
                                modifier = Modifier
                                    .padding(16.dp),
                                textAlign = TextAlign.Center,
                            )

                            var titleText by remember { mutableStateOf("") }
                            FancyTextField(value = titleText, placeHolderText = getString(R.string.recipe_name)) {
                                    newText ->
                                titleText = newText
                            }

                            Divider(modifier = Modifier.size(20.dp), color = Color.Transparent)

                            var bodyText by remember { mutableStateOf("") }
                            FancyTextField(value = bodyText, placeHolderText = getString(R.string.recipe_instructions), maxLines = 99) {
                                    newText ->
                                bodyText = newText
                            }

                            var servingSize by remember { mutableStateOf("") }

                            FancyTextField(value = bodyText, placeHolderText = getString(R.string.serving_size), keyboardType = KeyboardOptions(keyboardType = KeyboardType.Number)) {
                                    newText ->
                                servingSize = newText
                            }



                            Row {
                                Button(
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFAB6B6B6)
                                    ),
                                    onClick = {
                                        showAddUI = false
                                    }
                                ) {
                                    Text(getString(R.string.cancel))
                                }

                                Divider(modifier = Modifier.size(20.dp), color = Color.Transparent)

                                Button(onClick = {
                                    addRecipe(Recipe(titleText, bodyText, servingSize = servingSize.toInt()))
                                    showAddUI = false
                                }) {
                                    Text(getString(R.string.add))
                                }
                            }
                        }


                    }*/
                }

            }
        }
    }

    // FIXME: move to business logic
//    private fun addRecipe(recipe: Recipe) {
//        recipeList += recipe
//        /*val j = ConverterJSON()
//        println(j.convertRecipeJSON(recipe))
//        j.saveJsonToFile(j.convertRecipeJSON(recipe), "recipe.json", this)
//        println("Hi Jason" + j.loadJsonFromFile("recipe.json", this))*/
//
//        val converterJSON = ConverterJSON()
//        converterJSON.saveJsonToFile(
//            converterJSON.convertRecipeJSON(AppData("U", recipeList)),
//            "data.json",
//            this
//        )
//        update()
//    }



}
