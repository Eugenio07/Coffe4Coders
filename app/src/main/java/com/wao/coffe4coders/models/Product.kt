package com.wao.coffe4coders.models

class Product constructor(
    val id: Int,
    val name: String,
    val summary: String,
    val description: String,
    val price: Double,
    val currency: String,
    val countryIso: String
) {
}