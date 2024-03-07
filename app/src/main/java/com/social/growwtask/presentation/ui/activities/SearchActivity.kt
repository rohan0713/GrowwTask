package com.social.growwtask.presentation.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.social.growwtask.R
import com.social.growwtask.data.remote.RetrofitClient
import com.social.growwtask.databinding.ActivitySearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivitySearchBinding.inflate(layoutInflater).also { binding = it }.root)

        window.statusBarColor = Color.BLACK

        binding.btnSearch.setOnClickListener {
            val textToSearch = binding.etSearchText.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                val response = RetrofitClient.api.getAlbums(textToSearch,
                    "album",
                    "Bearer BQC06sFAPVYjXreS_LLc0zvvKKHu_Ell3nHsUZquXdi8K0qMiznBE2dE3HdIMVN006UlqxefgbGvvsybAWX-lvMUgntsZ2fCavp3B3mX_gA7u1D9iJg")

                if(response.isSuccessful){
                    withContext(Dispatchers.Main){
                        if(response.body() != null){
                            Log.d("response", "response fetched")
                        }else{
                            Log.d("response", "response not fetched")
                        }
                    }
                }else{
                    Log.d("response", "response failed")
                }
            }
        }
    }
}