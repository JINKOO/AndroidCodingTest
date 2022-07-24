package com.kjk.quicksampleapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.databinding.FragmentHomeBinding
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.presentation.adapter.BookAdapter
import com.kjk.quicksampleapp.presentation.adapter.OnItemClickListener

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    private val bookAdapter by lazy {
        BookAdapter(OnItemClickListener {
            viewModel.navigateToDetailFragment(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        observe()
    }

    private fun observe() {
        viewModel.bookList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "observe: books ${it.size}")
        })
        
        viewModel.videoList.observe(viewLifecycleOwner) {
            Log.d(TAG, "observe: videos ${it.size}")
        }

        viewModel.navigateToDetail.observe(viewLifecycleOwner) { bookEntity ->
            bookEntity?.let {
                moveToDetailFragment(bookEntity)
                viewModel.navigateToDetailDone()
            }
        }
    }

    private fun initLayout() {
        binding.bookRecyclerview.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = bookAdapter
        }
    }

    private fun moveToDetailFragment(bookEntity: BookEntity) {
        this.findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToBookDetailFragment(bookEntity))
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}