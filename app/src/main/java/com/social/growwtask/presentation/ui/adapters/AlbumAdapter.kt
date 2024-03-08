package com.social.growwtask.presentation.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.Albums
import com.social.growwtask.data.models.Item
import com.social.growwtask.databinding.AlbumItemBinding
import com.social.growwtask.presentation.ui.activities.AlbumActivity
import com.social.growwtask.presentation.ui.activities.NoNetworkActivity
import com.social.growwtask.utils.NetworkConnection

class AlbumAdapter(private val albums: Albums) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            Glide.with(binding.root).load(item.images[0].url).into(binding.ivPoster)
            binding.tvTitle.text = item.name
            val artist = item.artists.joinToString { it.name }
            binding.tvArtists.text = artist
            binding.tvYear.text = item.release_date

            itemView.setOnClickListener {

                if(NetworkConnection().isOnline(binding.root.context)){
                    Intent(binding.root.context, AlbumActivity::class.java).also {
                        it.putExtra("image", item.images[0].url)
                        it.putExtra("id", item.id)
                        it.putExtra("title", item.name)
                        it.putExtra("artist", artist)
                        it.putExtra("type", item.album_type)
                        binding.root.context.startActivity(it)
                    }
                }else{
                    Intent(binding.root.context, NoNetworkActivity::class.java).also {
                        binding.root.context.startActivity(it)
                    }
                }
            }

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