package com.ifs21016.galeriputri.ui.gallery

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {
    private val _photoList = MutableLiveData<List<String>>()
    val photoList: LiveData<List<String>>
        get() = _photoList

    fun loadPhotos(context: Context) {
        val photoList = GalleryHelper.getAllPhotos(context)
        _photoList.value = photoList
    }
}

