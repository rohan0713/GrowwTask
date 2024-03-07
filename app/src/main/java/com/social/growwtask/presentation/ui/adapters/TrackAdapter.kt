package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.ItemXX
import com.social.growwtask.data.models.TracksX
import com.social.growwtask.databinding.TrackItemBinding

class TrackAdapter(private val tracks: TracksX) : RecyclerView.Adapter<TrackAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TrackItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemXX) {
            binding.tvTrackName.text = item.name
            binding.tvArtists.text = item.artists[0].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TrackItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tracks.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tracks.items[position])
    }
}