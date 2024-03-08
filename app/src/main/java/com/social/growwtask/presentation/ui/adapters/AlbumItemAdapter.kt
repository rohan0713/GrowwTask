package com.social.growwtask.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.social.growwtask.data.models.AlbumListItem
import com.social.growwtask.data.models.PlaylistItem
import com.social.growwtask.databinding.AlbumListItemBinding

class AlbumItemAdapter(val items: List<AlbumListItem>) : RecyclerView.Adapter<AlbumItemAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AlbumListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(albumListItem: AlbumListItem) {
            binding.tvTrackName.text = albumListItem.name
            val artist = albumListItem.artists.joinToString { it.name }
            binding.tvArtists.text = artist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}