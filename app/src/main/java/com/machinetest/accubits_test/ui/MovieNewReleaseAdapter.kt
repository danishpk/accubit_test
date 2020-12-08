package com.machinetest.accubits_test.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.machinetest.accubits_test.data.entities.Movies
import com.machinetest.accubits_test.databinding.NewReleaseItemBinding

class MovieNewReleaseAdapter() : RecyclerView.Adapter<MovieReleaseViewHolder>() {

    private val items = ArrayList<Movies>()

    fun setItems(items: ArrayList<Movies>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieReleaseViewHolder {
        val binding: NewReleaseItemBinding = NewReleaseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieReleaseViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieReleaseViewHolder, position: Int) = holder.bind(items[position])
}

class MovieReleaseViewHolder(private val itemBinding: NewReleaseItemBinding) : RecyclerView.ViewHolder(itemBinding.root){

    private lateinit var movies: Movies

//    init {
//        itemBinding.root.setOnClickListener(this)
//    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Movies) {
        this.movies = item
        itemBinding.tvNewReleaseTitle.text = item.title
        itemBinding.tvNewReleaseDate.text = item.release_date
        Glide.with(itemBinding.root)
            .load("http://image.tmdb.org/t/p/w185${item.poster_path}")
            //.transform(CircleCrop())
            .into(itemBinding.ivNewRelaseTemplate)
    }

}

