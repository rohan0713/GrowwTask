package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.Item
import com.social.growwtask.data.models.ItemX
import com.social.growwtask.data.models.Playlists
import com.social.growwtask.databinding.PlaylistItemBinding

class PlaylistAdapter(private val playlists: Playlists) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: PlaylistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemX) {
            Glide.with(binding.root).load(item.images[0].url).into(binding.ivPoster)
            binding.tvTitle.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return playlists.items.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(playlists.items[position])
    }

}