package com.wao.coffe4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wao.coffe4coders.models.Product
import com.wao.coffe4coders.ui.components.*
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme
import com.wao.coffe4coders.utils.MockDataProvider

@Composable
fun DetailScreen(navController: NavController, product: Product) {
    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("feed") {
                    launchSingleTop = true
                    popUpTo("feed")
                }
            }
        },

        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = CountryISO.valueOf(product.countryIso).getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleText(title = product.name)
                    Text(
                        text = product.summary,
                        style = MaterialTheme.typography.caption
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(body = product.description)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout/${product.id}"){
                                launchSingleTop = true
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
fun DetailScreenPreview() {
    Coffe4CodersTheme() {
        DetailScreen(rememberNavController(), MockDataProvider.getProductById(0)!!)
    }
}