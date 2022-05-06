package com.example.filmlermvvmhilt.ui.film

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmlermvvmhilt.adapters.FilmAdapter
import com.example.filmlermvvmhilt.base.BaseFragment
import com.example.filmlermvvmhilt.databinding.FragmentFilmsBinding
import com.example.filmlermvvmhilt.model.Filmler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding,FilmsViewModel>(
    FragmentFilmsBinding::inflate
) {

    private val args:FilmsFragmentArgs by navArgs()
    override val viewModel: FilmsViewModel by viewModels<FilmsViewModel>()
    private var id:String?=null
    private val filmAdapter:FilmAdapter= FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id=args.categoryid
    }

    override fun createFinished() {
        id?.let { viewModel.getFilmDataById(it) }
    }

    override fun observeEvents() {
        with(viewModel){
            filmData.observe(viewLifecycleOwner){
                it?.let {
                    it.filmler?.let { it1 -> setRecycler(it1) }
                }
            }

            loading.observe(viewLifecycleOwner){
                if (it){
                    binding.progressBarFilms.visibility=View.VISIBLE
                }else{
                    binding.progressBarFilms.visibility=View.GONE
                }
            }

            error.observe(viewLifecycleOwner){
                it?.let {
                    Toast.makeText(context,it,Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    private fun setRecycler(list:List<Filmler>){
        filmAdapter.updateList(list)
        with(binding.rvFilms){
            layoutManager=GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter=filmAdapter
        }
        filmAdapter.onClick={
            findNavController().navigate(FilmsFragmentDirections.actionFilmsFragmentToDetailFragment(it))
        }
    }

}