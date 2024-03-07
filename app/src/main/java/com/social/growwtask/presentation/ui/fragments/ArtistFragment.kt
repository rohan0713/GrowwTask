package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.social.growwtask.R
import com.social.growwtask.databinding.FragmentArtistBinding
import com.social.growwtask.presentation.ui.adapters.ArtistAdapter

class ArtistFragment : Fragment() {

    lateinit var binding: FragmentArtistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtistBinding.inflate(inflater, container, false)
        binding.rvArtists.layoutManager = LinearLayoutManager(context)
        binding.rvArtists.adapter = ArtistAdapter()
        return binding.root
    }
}