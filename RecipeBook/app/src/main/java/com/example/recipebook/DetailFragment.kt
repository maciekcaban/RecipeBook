package com.example.recipebook

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipebook.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private val mainVM by activityViewModels<MainViewModel>()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SecondAdapter(
            mainVM.getRecipe()!!.ingredients
        )
        val adapter2 = SecondAdapter(
            mainVM.getRecipe()!!.steps
        )
        binding.detailIngredients.layoutManager = LinearLayoutManager(requireContext())
        binding.detailIngredients.adapter = adapter
        binding.detailSteps.layoutManager = LinearLayoutManager(requireContext())
        binding.detailSteps.adapter = adapter2
        binding.textTitle.text = mainVM.getRecipe()!!.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}