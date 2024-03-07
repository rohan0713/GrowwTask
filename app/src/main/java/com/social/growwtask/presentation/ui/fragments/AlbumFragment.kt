package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.social.growwtask.R
import com.social.growwtask.databinding.FragmentAlbumBinding
import com.social.growwtask.presentation.ui.adapters.AlbumAdapter

class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        binding.rvAlbums.layoutManager = GridLayoutManager(context, 2)
        binding.rvAlbums.adapter = AlbumAdapter()
        return binding.root
    }
}