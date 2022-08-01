package com.wao.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
fun CheckoutScreen(navController: NavController, product: Product) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

//    var name by remember {
//        mutableStateOf("")
//    }

//    CustomTextField(value = name, placeHolder = "Nombre") {
//        name = it
//    }
    Scaffold(topBar = {
        CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigate("detail/$product")
        }
    }, content = {
        Alert(title = "Felicidades", message = message) {
            navController.navigate("feed"){
                launchSingleTop = true
                popUpTo("feed")
            }
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            ProductCard(
                MockDataProvider.getProductById(product.id)!!
            ) {}
            Column(modifier = Modifier.padding(16.dp)) {
                CustomTextField(value = name, placeHolder = "Nombre completo") {
                    name = it
                }
                CustomTextField(value = email, placeHolder = "Email") {
                    email = it
                }
                CustomTextField(value = phone, placeHolder = "Teléfono") {
                    phone = it
                }
                CustomTextField(value = address, placeHolder = "Dirección") {
                    address = it
                }
                DropdownTextField(suggestions = MockDataProvider.listOfCities(), value = city, placeholder = "Ciudad") {
                    city = it
                }

                Column {
                    Row {
                        Text(
                            text = "Subtotal",
                            style = MaterialTheme.typography.caption,
                        )
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Row {
                        Text(
                            text = "Envio",
                            style = MaterialTheme.typography.caption,
                        )
                        Text(
                            text = "$ 10.0 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "$ 45.0 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )
                    CustomButton(label = "Finalizar pedidio") {
                    //TODO: validar los campos
                        message = "Tu pedido ha sido creado"
                    }
                }
            }
        }

    })
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    Coffe4CodersTheme {
        CheckoutScreen(rememberNavController(), MockDataProvider.getProductById(0)!!)
    }
}