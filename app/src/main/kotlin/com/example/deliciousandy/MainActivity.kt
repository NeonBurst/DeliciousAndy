package com.example.deliciousandy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.deliciousandy.navigation.DeliciousNavHost
import com.example.deliciousandy.navigation.Scenes
import com.example.deliciousandy.ui.components.IconBtn
import com.example.deliciousandy.ui.theme.DeliciousAndyTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliciousAndyTheme {

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { TopAppBar(title = { Text(getString(R.string.recipes)) }) },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                        navController.navigate(Scenes.ADD_RECIPE.name)
                        }) {
                            Icon(Icons.Filled.Add, getString(R.string.add))
                        }
                    },

                    bottomBar = {
                        BottomAppBar(
                            actions = {
                                IconBtn(
                                    imageVector = Icons.Filled.Home,
                                    tint = Color.Black,
                                    contentDescription = getString(
                                        R.string.home
                                    )
                                ) {
                                    println("Home")
                                }
                                IconBtn(
                                    imageVector = Icons.Filled.Info,
                                    tint = Color.Black,
                                    contentDescription = getString(
                                        R.string.info
                                    )
                                ) {

                                }
                                IconBtn(
                                    imageVector = Icons.Filled.Settings,
                                    tint = Color.Black,
                                    contentDescription = getString(
                                        R.string.settings
                                    )
                                ) {

                                }
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background

                ) { padding ->
                    Box(
                        modifier = Modifier.padding(padding)
                    ) {
                        DeliciousNavHost(navController = navController)
                    }
                }
            }
        }
    }
}

