package com.social.growwtask.presentation.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.models.Item
import com.social.growwtask.data.models.ItemX
import com.social.growwtask.data.models.Playlists
import com.social.growwtask.databinding.PlaylistItemBinding
import com.social.growwtask.presentation.ui.activities.NoNetworkActivity
import com.social.growwtask.presentation.ui.activities.PlaylistActivity
import com.social.growwtask.utils.NetworkConnection

class PlaylistAdapter(private val playlists: Playlists) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: PlaylistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemX) {
            Glide.with(binding.root).load(item.images[0].url).into(binding.ivPoster)
            binding.tvTitle.text = item.name

            itemView.setOnClickListener {

                if(NetworkConnection().isOnline(binding.root.context)){
                    Intent(binding.root.context, PlaylistActivity::class.java).also {
                        it.putExtra("image", item.images[0].url)
                        it.putExtra("id", item.id)
                        it.putExtra("title", item.name)
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