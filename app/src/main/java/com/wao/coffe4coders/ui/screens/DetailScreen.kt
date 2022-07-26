package com.wao.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wao.coffe4coders.ui.components.CountryISO

@Composable
fun DetailScreen(navController: NavController, countryISO: CountryISO) {
    Column() {
        Text("Hola ${countryISO.iso}")
        Button(onClick = {
            navController.navigate("feed") {
                popUpTo("feed")
            }
        }) {
            Text(text = "Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(rememberNavController(), CountryISO.COL)
}