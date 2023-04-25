package com.example.recipebook

import androidx.lifecycle.ViewModel


var recipe1 =Recipe(
    "Jajecznica",
    15,
    listOf("3 jajka ","boczek", "maslo", "grzyby"),
    listOf("pokroj boczek w kostke","podsmaz boczek na suchej patelni", "dodaj maslo",
        "jak maslo sie rozpusci wbij jajka na patelnie", "poczekaj az bialko sie zetnie")
)
var recipe2 =Recipe("Makaron z serem",
    20,
    listOf("makaron pene","ser bialy", "sol"),
    listOf("wrzucic makaron do osolonej wody","ugotowac wg instrukcji producenta",
        "ugotowany makaron odcedzic i przlozyc na talerz", "dodac ser")
)
var recipe3 =Recipe(
    "Pomidorowa22",
    40,
    listOf("pomidory","rosol", "makaron"),
    listOf("krok1")
)
var recipe4 =Recipe(
    "Pomidorowa2222",
    40,
    listOf("pomidory","rosol", "makaron"),
    listOf("krok1")
)


interface Server{
    fun getList(): List<Recipe>
    fun loadFromDB()
}

class MainViewModel: ViewModel(), Server{
    //used to sent recipe to detail view
    private var recipe: Recipe? = null
    //list of recipes
     var recipeList = mutableListOf<Recipe>()


    //to do: use it to load list from DB and set it to recipeList
    override public fun loadFromDB(){
        recipeList.add(recipe1)
        recipeList.add(recipe2)
        recipeList.add(recipe3)
        recipeList.add(recipe4)
    }

    override public fun getList() :List<Recipe>{
        recipeList.add(recipe1)
        recipeList.add(recipe2)
        recipeList.add(recipe3)
        recipeList.add(recipe4)
        return recipeList
    }

    fun setRecipe(recipe: Recipe){
        this.recipe = recipe
    }

    fun getRecipe()=recipe
}

