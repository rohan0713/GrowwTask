package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.Albums
import com.social.growwtask.data.models.Item
import com.social.growwtask.databinding.AlbumItemBinding

class AlbumAdapter(private val albums: Albums) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            Glide.with(binding.root).load(item.images[0].url).into(binding.ivPoster)
            binding.tvTitle.text = item.name
            binding.tvArtists.text = item.artists[0].name
            binding.tvYear.text = item.release_date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albums.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albums.items[position])
    }
}