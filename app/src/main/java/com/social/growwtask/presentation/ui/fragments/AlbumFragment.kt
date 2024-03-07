package com.social.growwtask.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.social.growwtask.databinding.FragmentAlbumBinding
import com.social.growwtask.presentation.ui.activities.ResultActivity
import com.social.growwtask.presentation.ui.adapters.AlbumAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel

class AlbumFragment : Fragment() {

    lateinit var binding: FragmentAlbumBinding
    lateinit var viewModel: TrackViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        binding.rvAlbums.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (requireActivity() as ResultActivity).viewModel
        viewModel.albums.observe(viewLifecycleOwner, Observer { res ->
            if(res != null){
                binding.rvAlbums.adapter = AlbumAdapter(res.albums)
            }
        })

    }
}