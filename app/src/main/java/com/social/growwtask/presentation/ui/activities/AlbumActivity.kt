package com.social.growwtask.presentation.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.social.growwtask.data.remote.RetrofitClient
import com.social.growwtask.databinding.ActivityAlbumBinding
import com.social.growwtask.presentation.ui.adapters.AlbumItemAdapter
import com.social.growwtask.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumActivity : AppCompatActivity() {

    lateinit var binding : ActivityAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityAlbumBinding.inflate(layoutInflater).also { binding = it }.root)

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        window.statusBarColor = Color.TRANSPARENT

        val url = intent.getStringExtra("image").toString()
        val title = intent.getStringExtra("title").toString()
        val id = intent.getStringExtra("id").toString()
        val type = intent.getStringExtra("type")
        val artist = intent.getStringExtra("artist")

        binding.tvArtists.text = artist
        binding.tvAlbumType.text = type

        binding.tvTitle.text = title
        Glide.with(binding.root).load(url).into(binding.ivPoster)

        binding.rvTracks.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.api.getAlbumTracks(id, Constants.token)
            if(response.isSuccessful){
                response.body()?.let {
                    withContext(Dispatchers.Main){
                        binding.rvTracks.adapter = AlbumItemAdapter(it.items)
                    }
                }
            }
        }
    }
}