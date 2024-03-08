package com.social.growwtask.presentation.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.social.growwtask.data.local.models.TrackData
import com.social.growwtask.databinding.HistoryItemBinding
import com.social.growwtask.presentation.ui.activities.ResultActivity
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel
import java.io.Serializable

class HistoryAdapter(private val trackData: List<TrackData>, val viewModel: TrackViewModel) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trackData: TrackData) {
            binding.tvTrackName.text = trackData.title
            Glide.with(binding.root).load(trackData.response.albums.items[0].images[0].url).into(binding.ivPoster)
            val artist = trackData.response.artists.items.take(3).joinToString {
                it.name
            }
            binding.tvArtists.text = artist
            binding.ivDelete.setOnClickListener {
                viewModel.deleteFromDb(trackData)
            }

            itemView.setOnClickListener {
                Intent(binding.root.context, ResultActivity::class.java).also {
                    it.putExtra("response", trackData.response as Serializable)
                    it.putExtra("input", trackData.title)
                    binding.root.context.startActivity(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return trackData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(trackData[position])
    }
}