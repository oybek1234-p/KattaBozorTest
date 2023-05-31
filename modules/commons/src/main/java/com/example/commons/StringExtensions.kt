package com.example.commons

//String helper функции

fun String.containsNumber(): Boolean {
    return toList().any { it.isDigit() }
}