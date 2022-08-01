package com.wao.coffe4coders.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.wao.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun Alert(title: String, message: String?, onClose: () -> Unit) {
    message?.let {
        AlertDialog(onDismissRequest = { onClose() },
            title = { Text(text = title, style = MaterialTheme.typography.h5) },
            text = { Text(text = message, style = MaterialTheme.typography.h5) },
            confirmButton = {
                Button(onClick = onClose) {
                    Text(text = "ok")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertPreview() {
    Coffe4CodersTheme {
        Alert("", ""){}
    }
}