package com.social.growwtask.presentation.ui.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.social.growwtask.data.local.models.TrackData
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.domain.repositories.TrackRepository
import com.social.growwtask.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val repository: TrackRepository,
) : ViewModel() {

    private val _albums: MutableLiveData<ApiResponse> = MutableLiveData<ApiResponse>()
    val albums: LiveData<ApiResponse> = _albums

    val textSearched : LiveData<List<TrackData>> = repository.getDataFromDb()

    fun getData(input : String) {
        viewModelScope.launch {
            val response = repository.getAlbums(input, "album,track,playlist,artist", Constants.token)
            if (response.isSuccessful) {
                Log.d("vm", "success")
                response.body()?.let {
                    _albums.postValue(it)
                    repository.insertIntoDB(input, it)
                }
                Log.d("vm", "fetched")
            } else {
                Log.d("vm", "failed")
            }
        }
    }

    fun deleteFromDb(trackData : TrackData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFromDB(trackData)
        }
    }

}