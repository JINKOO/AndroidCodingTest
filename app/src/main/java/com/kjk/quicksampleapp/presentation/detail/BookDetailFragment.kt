package com.kjk.quicksampleapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.databinding.FragmentBookDetailBinding
import com.kjk.quicksampleapp.domain.entity.BookEntity

class BookDetailFragment : Fragment() {

    private lateinit var binding: FragmentBookDetailBinding
    private lateinit var viewModel: BookDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_book_detail,
            container,
            false
        )

        val argument = BookDetailFragmentArgs.fromBundle(requireArguments()).bookEntity
        viewModel = ViewModelProvider(
            this,
            BookDetailViewModelFactory(argument)
        ).get(BookDetailViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        observe()
    }

    private fun initLayout() {

    }

    private fun observe() {

    }
}