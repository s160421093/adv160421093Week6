package com.ubaya.adv160421093week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.adv160421093week6.databinding.FragmentLaptopListBinding
import com.ubaya.adv160421093week6.viewmodel.LaptopViewModel

class LaptopListFragment : Fragment() {
    private lateinit var viewModel:LaptopViewModel
    private val laptopListAdapter  = LaptopListAdapter(arrayListOf())
    private lateinit var binding: FragmentLaptopListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaptopListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LaptopViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = laptopListAdapter

        observeViewModel()

        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }

    }
    fun observeViewModel() {
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })

    }
}