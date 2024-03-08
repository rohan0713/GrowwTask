package com.social.growwtask.presentation.ui.activities

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.databinding.ActivityResultBinding
import com.social.growwtask.presentation.ui.adapters.PageAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel
import com.social.growwtask.utils.NetworkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    val viewModel: TrackViewModel by viewModels()
    lateinit var response: ApiResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityResultBinding.inflate(layoutInflater).also { binding = it }.root)

        window.statusBarColor = Color.BLACK

        if(!NetworkConnection().isOnline(this)){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                response = intent.getSerializableExtra("response", ApiResponse::class.java)!!
            }else{
                response = (intent.getSerializableExtra("response") as? ApiResponse)!!
            }
            binding.tvSearchedText.text = intent.getStringExtra("input")

        }else{
            val textToSearch = intent.getStringExtra("input")
            binding.tvSearchedText.text = textToSearch

            if (textToSearch != null) {
                viewModel.getData(textToSearch)
            }
        }

        val pageAdapter = PageAdapter(this)
        binding.viewpager.adapter = pageAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            when (position) {
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