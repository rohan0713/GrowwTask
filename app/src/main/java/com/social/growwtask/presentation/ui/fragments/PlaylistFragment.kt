package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.social.growwtask.R
import com.social.growwtask.databinding.FragmentPlaylistBinding
import com.social.growwtask.presentation.ui.adapters.PlaylistAdapter

class PlaylistFragment : Fragment() {

    lateinit var binding: FragmentPlaylistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        binding.rvPlaylist.layoutManager = GridLayoutManager(context, 2)
        binding.rvPlaylist.adapter = PlaylistAdapter()
        return binding.root
    }
}