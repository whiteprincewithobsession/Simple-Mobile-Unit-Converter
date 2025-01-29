package com.example.simpleconverter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform