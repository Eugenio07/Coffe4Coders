package com.wao.coffe4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wao.coffe4coders.ui.components.CountryISO
import com.wao.coffe4coders.ui.screens.CheckoutScreen
import com.wao.coffe4coders.ui.screens.DetailScreen
import com.wao.coffe4coders.ui.screens.FeedScreen
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme
import com.wao.coffe4coders.utils.MockDataProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           NavigationHost()
        }
    }
}

@Composable
fun NavigationHost(){
    val navController = rememberNavController()
    Coffe4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed"){
                composable(route = "feed"){
                    FeedScreen(navController)
                }
                composable(route = "detail/{productID}"){ backStackEntry ->
                    val productIDString = backStackEntry.arguments?.getString("productID") ?: "0"
                    val product = MockDataProvider.getProductById(productIDString.toInt())!!
                    DetailScreen(navController, product)
                }
                composable(route = "checkout/{productID}"){ backStackEntry ->
                    val productIDString = backStackEntry.arguments?.getString("productID") ?: "0"
                    val product = MockDataProvider.getProductById(productIDString.toInt())!!
                    CheckoutScreen(navController, product)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}