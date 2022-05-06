package com.example.filmlermvvmhilt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlermvvmhilt.databinding.CategoryCardBinding
import com.example.filmlermvvmhilt.model.Kategoriler

class CategoryAdapter :RecyclerView.Adapter<CategoryAdapter.CategoryHolder>(){

    private val categoryList= arrayListOf<Kategoriler>()
    var onClick:(String)->Unit={}

    class CategoryHolder(private val categoryCardBinding: CategoryCardBinding):RecyclerView.ViewHolder(categoryCardBinding.root){

        fun find(category: Kategoriler,onClick:(String)->Unit={}){
            categoryCardBinding.category=category
            categoryCardBinding.executePendingBindings()
            categoryCardBinding.cardCategory.setOnClickListener {
                category.kategoriİd?.let { it1 -> onClick(it1) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layout=CategoryCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryHolder(layout)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category=categoryList[position]
        holder.find(category,onClick)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun updateCategoryList(list:List<Kategoriler>){
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }
}