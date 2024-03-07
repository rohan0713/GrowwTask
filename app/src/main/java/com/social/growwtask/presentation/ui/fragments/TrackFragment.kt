package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.social.growwtask.databinding.FragmentTrackBinding
import com.social.growwtask.presentation.ui.activities.ResultActivity
import com.social.growwtask.presentation.ui.adapters.TrackAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel

class TrackFragment : Fragment() {

    lateinit var binding: FragmentTrackBinding
    lateinit var viewModel: TrackViewModel

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

        viewModel = (requireActivity() as ResultActivity).viewModel
        viewModel.albums.observe(viewLifecycleOwner, Observer {
            binding.rvTracks.adapter = TrackAdapter(it.tracks)
        })

    }
}