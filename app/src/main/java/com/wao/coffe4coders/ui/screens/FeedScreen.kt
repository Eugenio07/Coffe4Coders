package com.wao.coffe4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wao.coffe4coders.ui.components.BodyText
import com.wao.coffe4coders.ui.components.CustomAppBar
import com.wao.coffe4coders.ui.components.ProductCard
import com.wao.coffe4coders.ui.components.TitleText
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme
import com.wao.coffe4coders.utils.MockDataProvider

@Composable
fun FeedScreen(navController: NavController) {
    val list = MockDataProvider.listOfProducts()
    Scaffold(
        topBar = {
            CustomAppBar(title = "Coffee4Coders")
        },

        content = {
            Coffe4CodersTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            Column(modifier = Modifier.padding(8.dp)) {
                                TitleText(title = "Bienvenido")
                                BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor. Etiam lobortis odio quam, eget pretium odio scelerisque id. Morbi a euismod est. Praesent porttitor diam at sapien posuere varius. Cras nec pulvinar arcu. Donec eget imperdiet nunc.")
                            }
                        }
                        items(list) { product ->
                            ProductCard(product) {
                                navController.navigate("detail/${product.id}") {
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
    Coffe4CodersTheme() {
        FeedScreen(rememberNavController())
    }
}
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FeedScreenPreviewDark() {
    Coffe4CodersTheme() {
        FeedScreen(rememberNavController())
    }
}