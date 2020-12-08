package com.machinetest.accubits_test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.machinetest.accubits_test.R
import com.machinetest.accubits_test.databinding.FragmentMovieBinding
import com.machinetest.accubits_test.utils.Resource
import com.machinetest.accubits_test.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private var binding: FragmentMovieBinding by autoCleared()
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var adapter1: MovieNewVideoAdapter
    private lateinit var adapter2: MovieNewReleaseAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView1()
        setupRecyclerView2()
        setupObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupRecyclerView1() {
        adapter1 = MovieNewVideoAdapter()
        binding.rvNewVdeos.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.rvNewVdeos.adapter = adapter1
    }

    private fun setupRecyclerView2() {
        adapter2 = MovieNewReleaseAdapter()
        binding.rvNewRelease.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.rvNewRelease.adapter = adapter2
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty())
                    {
                        adapter1.setItems(ArrayList(it.data))
                        adapter2.setItems(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }
}