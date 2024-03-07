package com.social.growwtask.presentation.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.social.growwtask.R
import com.social.growwtask.databinding.ActivityResultBinding
import com.social.growwtask.presentation.ui.adapters.PageAdapter

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityResultBinding.inflate(layoutInflater).also { binding = it }.root)

        window.statusBarColor = Color.BLACK

        val pageAdapter = PageAdapter(this)
        binding.viewpager.adapter = pageAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager){ tab, position ->
            when(position){
                0 -> tab.text = "Artists"
                1 -> tab.text = "Albums"
                2 -> tab.text = "Playlists"
                3 -> tab.text = "Tracks"
            }
        }.attach()

        binding.viewpager.setCurrentItem(1, true)

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}