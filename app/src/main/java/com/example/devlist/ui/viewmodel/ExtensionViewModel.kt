package com.example.devlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devlist.data.api.ApiHelper
import com.example.devlist.data.api.ApiInterface
import com.example.devlist.data.model.DevResource
import kotlinx.coroutines.launch

class ExtensionViewModel : ViewModel() {
    private val _extensionMutableLivedata = MutableLiveData<DevResource>()
    val extensionLiveData: LiveData<DevResource> = _extensionMutableLivedata

    init {
        viewModelScope.launch {
            val api = ApiHelper.getInstance().create(ApiInterface::class.java)
            val ui = api.getDevList("Tools & Utilities/Browsers & Extensions").body()
            _extensionMutableLivedata.value = ui!!
        }
    }
}