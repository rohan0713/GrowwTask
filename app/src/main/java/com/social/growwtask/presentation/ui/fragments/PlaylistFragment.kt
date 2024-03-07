package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.social.growwtask.databinding.FragmentPlaylistBinding
import com.social.growwtask.presentation.ui.activities.ResultActivity
import com.social.growwtask.presentation.ui.adapters.PlaylistAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel

class PlaylistFragment : Fragment() {

    lateinit var binding: FragmentPlaylistBinding
    lateinit var viewModel: TrackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        binding.rvPlaylist.layoutManager = GridLayoutManager(context, 2)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (requireActivity() as ResultActivity).viewModel

        viewModel.albums.observe(viewLifecycleOwner, Observer {
            binding.rvPlaylist.adapter = PlaylistAdapter(it.playlists)
        })

    }
}