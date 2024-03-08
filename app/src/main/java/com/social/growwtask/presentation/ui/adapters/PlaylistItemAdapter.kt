package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.PlaylistItem
import com.social.growwtask.databinding.TrackItemBinding

class PlaylistItemAdapter(val items: List<PlaylistItem>) : RecyclerView.Adapter<PlaylistItemAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TrackItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(playlistItem: PlaylistItem) {
            if(playlistItem.track.album.images.isNotEmpty()){
                val url = playlistItem.track.album.images[0].url
                Glide.with(binding.root).load(url).into(binding.ivPoster)
            }
            val title = playlistItem.track.name
            val artist = playlistItem.track.artists.joinToString {
                it.name
            }

            binding.tvTrackName.text = title
            binding.tvArtists.text = artist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TrackItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}