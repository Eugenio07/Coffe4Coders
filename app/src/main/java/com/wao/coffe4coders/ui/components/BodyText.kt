package com.wao.coffe4coders.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun BodyText(body: String) {
    Text(text = body, style = MaterialTheme.typography.body2, textAlign = TextAlign.Justify)
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    Coffe4CodersTheme {
        TitleText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tempor posuere risus sed cursus. Aenean eget massa non urna sollicitudin cursus vel semper felis. Ut aliquam sodales elit et tempor. Etiam lobortis odio quam, eget pretium odio scelerisque id. Morbi a euismod est. Praesent porttitor diam at sapien posuere varius. Cras nec pulvinar arcu. Donec eget imperdiet nunc.")
    }
}