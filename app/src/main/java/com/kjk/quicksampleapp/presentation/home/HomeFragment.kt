package com.kjk.quicksampleapp.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.databinding.HomeFragmentBinding
import com.kjk.quicksampleapp.presentation.adapter.AirlineAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    private lateinit var viewModel: HomeViewModel

    private val airlineAdapter by lazy {
        AirlineAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initLayout()
        observe()
    }

    private fun initLayout() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = airlineAdapter
        }
    }

    private fun observe() {
        viewModel.flightArrivals.observe(viewLifecycleOwner) {
            Log.d(TAG, "observe arrivals : ${it.size}")
        }

        viewModel.serviceAirlines.observe(viewLifecycleOwner) {
            Log.d(TAG, "observe serviceAirlines :  ${it.size}")
        }
    }


    companion object {
        private const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }
}