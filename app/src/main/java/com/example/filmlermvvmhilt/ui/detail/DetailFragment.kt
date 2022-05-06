package com.example.filmlermvvmhilt.ui.detail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.filmlermvvmhilt.base.BaseFragment
import com.example.filmlermvvmhilt.databinding.FragmentDetailBinding
import com.example.filmlermvvmhilt.model.Filmler

class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>(
    FragmentDetailBinding::inflate
) {

    override val viewModel: DetailViewModel by viewModels<DetailViewModel>()
    private val args:DetailFragmentArgs by navArgs()
    private var film:Filmler?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        film=args.film
    }

    override fun createFinished() {
        film?.let {
            binding.film=film
        }
    }

    override fun observeEvents() {
    }

}