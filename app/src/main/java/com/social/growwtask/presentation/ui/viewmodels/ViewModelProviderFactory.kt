package com.social.growwtask.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.social.growwtask.domain.repositories.TrackRepository

class ViewModelProviderFactory(
    private val repository: TrackRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return TrackViewModel(repository) as T
    }
}