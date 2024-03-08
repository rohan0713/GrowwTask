package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.databinding.FragmentTrackBinding
import com.social.growwtask.presentation.ui.activities.ResultActivity
import com.social.growwtask.presentation.ui.adapters.ArtistAdapter
import com.social.growwtask.presentation.ui.adapters.TrackAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel
import com.social.growwtask.utils.NetworkConnection

class TrackFragment : Fragment() {

    lateinit var binding: FragmentTrackBinding
    lateinit var viewModel: TrackViewModel
    lateinit var response: ApiResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrackBinding.inflate(inflater, container, false)

        binding.rvTracks.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!NetworkConnection().isOnline(binding.root.context)){
            response = (requireActivity() as ResultActivity).response
            binding.rvTracks.adapter = TrackAdapter(response.tracks)
        }else{
            viewModel = (requireActivity() as ResultActivity).viewModel
            viewModel.albums.observe(viewLifecycleOwner, Observer {
                Log.d("res", it.artists.items.size.toString())
                binding.rvTracks.adapter = TrackAdapter(it.tracks)
            })
        }

    }
}