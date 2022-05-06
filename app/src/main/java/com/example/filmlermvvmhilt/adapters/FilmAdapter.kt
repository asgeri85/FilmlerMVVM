package com.example.filmlermvvmhilt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlermvvmhilt.databinding.FilmCardBinding
import com.example.filmlermvvmhilt.model.Filmler

class FilmAdapter:RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    private val filmList= arrayListOf<Filmler>()
    var onClick:(Filmler)->Unit={}

    class FilmViewHolder(private val filmCardBinding: FilmCardBinding):RecyclerView.ViewHolder(filmCardBinding.root){
        fun find(film: Filmler,onClick:(Filmler)->Unit={}){
            filmCardBinding.film=film
            filmCardBinding.executePendingBindings()

            filmCardBinding.cardView.setOnClickListener {
                onClick(film)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layout=FilmCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FilmViewHolder(layout)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film=filmList[position]
        holder.find(film,onClick)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun updateList(list:List<Filmler>){
        filmList.clear()
        filmList.addAll(list)
        notifyDataSetChanged()
    }
}