package com.example.recipebook

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recipebook.databinding.RecipeRowBinding
import com.example.recipebook.databinding.SimpleRowBinding

class SecondAdapter(public val list: List<String>)
    : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {


    inner class SecondViewHolder(binding: SimpleRowBinding):ViewHolder(binding.root){
        val name = binding.rowTV
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.SecondViewHolder {
        return SecondViewHolder(binding = SimpleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SecondAdapter.SecondViewHolder, position: Int) {
        holder.name.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}