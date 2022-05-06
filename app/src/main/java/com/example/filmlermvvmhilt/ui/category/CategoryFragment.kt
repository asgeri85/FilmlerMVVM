package com.example.filmlermvvmhilt.ui.category

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlermvvmhilt.adapters.CategoryAdapter
import com.example.filmlermvvmhilt.base.BaseFragment
import com.example.filmlermvvmhilt.databinding.FragmentCategoryBinding
import com.example.filmlermvvmhilt.model.Kategoriler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>(
    FragmentCategoryBinding::inflate
) {

    private val categoryAdapter: CategoryAdapter = CategoryAdapter()

    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()

    override fun createFinished() {

    }

    override fun observeEvents() {
        with(viewModel) {
            categoryData.observe(viewLifecycleOwner) {
                it?.let {
                    it.kategoriler?.let { it1 -> setRecycler(it1) }
                }
            }

            loading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.progressBarCategory.visibility = View.VISIBLE
                    binding.rvCategory.visibility = View.GONE
                } else {
                    binding.progressBarCategory.visibility = View.GONE
                    binding.rvCategory.visibility = View.VISIBLE
                }
            }

            error.observe(viewLifecycleOwner) {
                it?.let {
                    Toast.makeText(context, it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setRecycler(categoryList: List<Kategoriler>) {
        categoryAdapter.updateCategoryList(categoryList)
        binding.rvCategory.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = categoryAdapter
        }
        categoryAdapter.onClick={
            findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToFilmsFragment(it))
        }
    }

}