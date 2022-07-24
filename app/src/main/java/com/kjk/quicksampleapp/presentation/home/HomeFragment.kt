package com.kjk.quicksampleapp.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kjk.quicksampleapp.R

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        observe()
    }

    private fun observe() {
        viewModel.flightArrivals.observe(viewLifecycleOwner) {
            Log.d(TAG, "observe: ${it.size}")
        }
    }


    companion object {
        private const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }
}