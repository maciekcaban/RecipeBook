package com.example.recipebook
//simple class contains recipe with its name, prepare time, ingredients and steps
data class Recipe (var name: String,var  time: Int,var  ingredients:  List<String>,val steps: List<String>)