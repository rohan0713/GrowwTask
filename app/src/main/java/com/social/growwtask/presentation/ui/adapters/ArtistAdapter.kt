package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.Artist
import com.social.growwtask.data.models.ArtistItemX
import com.social.growwtask.data.models.ArtistX
import com.social.growwtask.data.models.ItemXX
import com.social.growwtask.databinding.ArtistItemBinding

class ArtistAdapter(private val artist: ArtistX) : RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ArtistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArtistItemX) {
            binding.tvArtistName.text = item.name
            if(item.images.isNotEmpty()){
                Glide.with(binding.root).load(item.images[0].url).into(binding.ivArtist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ArtistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artist.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artist.items[position])
    }
}