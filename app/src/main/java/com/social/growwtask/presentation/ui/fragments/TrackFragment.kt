package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.social.growwtask.R
import com.social.growwtask.databinding.FragmentTrackBinding
import com.social.growwtask.presentation.ui.adapters.TrackAdapter

class TrackFragment : Fragment() {

    lateinit var binding: FragmentTrackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrackBinding.inflate(inflater, container, false)

        binding.rvTracks.layoutManager = LinearLayoutManager(context)
        binding.rvTracks.adapter = TrackAdapter()
        return binding.root
    }

}