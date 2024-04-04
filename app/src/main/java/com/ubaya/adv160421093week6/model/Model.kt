package com.ubaya.adv160421093week6.model

data class Laptop(
    var id: String?,
    val brand: String?,
    val model: String?,
    val processor: String?,
    val ram: String?,
    val storage: String?,
    val features: List<String>?,
    val ports: PortSpecifications?,
    val images: String?
)

data class PortSpecifications(
    val usb: Int?,
    val hdmi: Int?,
    val thunderbolt: Int?,
    val usb_c: Int?
)