package com.social.growwtask.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.social.growwtask.presentation.ui.fragments.AlbumFragment
import com.social.growwtask.presentation.ui.fragments.ArtistFragment
import com.social.growwtask.presentation.ui.fragments.PlaylistFragment
import com.social.growwtask.presentation.ui.fragments.TrackFragment

class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4;
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ArtistFragment()
            1 -> AlbumFragment()
            2 -> PlaylistFragment()
            else -> TrackFragment()
        }
    }
}