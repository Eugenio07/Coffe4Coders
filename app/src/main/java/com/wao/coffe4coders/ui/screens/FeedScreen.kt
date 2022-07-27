package com.wao.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wao.coffe4coders.ui.components.*
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen(navController: NavController) {
    val list = listOf<CountryISO>(CountryISO.COL, CountryISO.BRA, CountryISO.CRI, CountryISO.NIC)
    Scaffold(
        topBar = {
            CustomAppBar(title = "Coffee4Coders")
        },

        content = { Coffe4CodersTheme() {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        Column(modifier = Modifier.padding(8.dp)) {
                            TitleText(title = "Bienvenido")
                            BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor. Etiam lobortis odio quam, eget pretium odio scelerisque id. Morbi a euismod est. Praesent porttitor diam at sapien posuere varius. Cras nec pulvinar arcu. Donec eget imperdiet nunc.")
                        }
                    }
                    items(list) { country ->
                        ProductCard(
                            name = "Café Colombia",
                            summary = "Café de las montañas",
                            price = 50.0,
                            currency = "USD",
                            countryISO = country
                        ) {
                            navController.navigate("detail/${country.iso}") {
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }

        }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}