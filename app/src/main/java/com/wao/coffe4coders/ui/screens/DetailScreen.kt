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
import com.wao.coffe4coders.ui.components.*
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun DetailScreen(navController: NavController, countryISO: CountryISO) {
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
                        painter = painterResource(id = countryISO.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleText(title = "Café de Colombia")
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor.",
                        style = MaterialTheme.typography.caption
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor. Etiam lobortis odio quam, eget pretium odio scelerisque id. Morbi a euismod est. Praesent porttitor diam at sapien posuere varius. Cras nec pulvinar arcu. Donec eget imperdiet nunc.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "$35.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout/${countryISO.iso}"){
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
        DetailScreen(rememberNavController(), CountryISO.COL)
    }
}