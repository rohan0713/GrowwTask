package com.social.growwtask.presentation.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.domain.repositories.TrackRepository
import com.social.growwtask.utils.Constants
import kotlinx.coroutines.launch

class TrackViewModel(
    private val repository: TrackRepository
) : ViewModel() {

    private val _albums: MutableLiveData<ApiResponse> = MutableLiveData<ApiResponse>()
    val albums: LiveData<ApiResponse> = _albums

    fun getData(input : String) {
        viewModelScope.launch {
            val response = repository.getAlbums(input, "album,track,playlist", Constants.token)
            if (response.isSuccessful) {
                Log.d("vm", "success")
                _albums.postValue(response.body())
                Log.d("vm", "fetched")
            } else {
                Log.d("vm", "failed")
            }
        }
    }

}