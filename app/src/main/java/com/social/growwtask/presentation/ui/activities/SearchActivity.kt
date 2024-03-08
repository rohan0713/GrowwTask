package com.social.growwtask.presentation.ui.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.social.growwtask.databinding.ActivitySearchBinding
import com.social.growwtask.presentation.ui.adapters.HistoryAdapter
import com.social.growwtask.presentation.ui.viewmodels.TrackViewModel
import com.social.growwtask.utils.NetworkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchBinding
    private val viewModel : TrackViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivitySearchBinding.inflate(layoutInflater).also { binding = it }.root)

        window.statusBarColor = Color.BLACK

        binding.btnSearch.setOnClickListener {

            if(!NetworkConnection().isOnline(binding.root.context)){
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }else{
                val textToSearch = binding.etSearchText.text
                if(!textToSearch.isNullOrEmpty()){
                    Intent(this@SearchActivity, ResultActivity::class.java).also {
                        it.putExtra("input", textToSearch.toString().replace(" ", ""))
                        startActivity(it)
                    }
                }
            }
        }

        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        viewModel.textSearched.observe(this, Observer {

            if(it.isNotEmpty()){
                Log.d("res", "observing")
                binding.tvRecent.visibility = View.VISIBLE
                binding.rvHistory.visibility = View.VISIBLE
                binding.tvStatus.visibility = View.GONE
                binding.rvHistory.adapter = HistoryAdapter(it.reversed(), viewModel)
            }else{
                binding.tvRecent.visibility = View.GONE
                binding.rvHistory.visibility = View.GONE
                binding.tvStatus.visibility = View.VISIBLE
            }
        })
    }
}