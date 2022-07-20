package com.wao.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wao.coffe4coders.ui.components.BodyText
import com.wao.coffe4coders.ui.components.CountryISO
import com.wao.coffe4coders.ui.components.ProductCard
import com.wao.coffe4coders.ui.components.TitleText
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen() {
    val list = listOf<CountryISO>(CountryISO.COL, CountryISO.BRA, CountryISO.CRI, CountryISO.NIC)
    Coffe4CodersTheme() {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Column(modifier = Modifier.padding(8.dp)) {
                        TitleText(title = "Bienvenido")
                        BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor. Etiam lobortis odio quam, eget pretium odio scelerisque id. Morbi a euismod est. Praesent porttitor diam at sapien posuere varius. Cras nec pulvinar arcu. Donec eget imperdiet nunc.")
                    }
                }
                items(list){country ->
                    ProductCard(
                        name = "Café Colombia",
                        summary = "Café de las montañas",
                        price = 50.0,
                        currency = "USD",
                        countryISO = country
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}