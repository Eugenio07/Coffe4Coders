package com.wao.coffe4coders.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize

@Composable
fun DropdownTextField(
    suggestions: List<String>,
    value: String,
    placeholder: String,
    onChangeValue: (String) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon = Icons.Filled.ArrowDropDown
    Column {
        CustomTextField(
            value = value,
            placeHolder = placeholder,
            onValueChange = onChangeValue,
            enabled = false,
            trailIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null, modifier = Modifier.clickable {
                        expanded = !expanded

                    }
                )
            },
            onGloballyPositioned = { coordinates ->
                textFieldSize = coordinates.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(
                LocalDensity.current
            ) {
                textFieldSize.width.toDp()
            })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    onChangeValue(label)
                    expanded = !expanded
                }) {
                    Text(label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownTextFieldPreview() {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )
    DropdownTextField(suggestions = cities, value ="", placeholder = "Ciudades"){}
}