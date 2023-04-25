package com.example.recipebook

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recipebook.databinding.RecipeRowBinding


class FirstAdapter(public val recipesList: List<Recipe>,
    private val onRecipeClick: (Recipe) -> Unit)
    :RecyclerView.Adapter<FirstAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: RecipeRowBinding):ViewHolder(binding.root){
        val name = binding.name
        val time = binding.time
        val ingredients = binding.ingredients

        init{
            binding.root.setOnClickListener{
                onRecipeClick(recipesList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = recipesList[position].name
        holder.time.text = recipesList[position].time.toString()
        var ing = ""
        for(item in recipesList[position].ingredients){
            ing = ing + item + " "
        }
        holder.ingredients.text = ing
    }

}