package com.example.attmodule.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attmodule.Model.CancelResponse
import com.example.attmodule.Model.Channels
import com.example.attmodule.Model.RecordingResponse
import com.example.attmodule.Repository.ChannelRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChannelViewModel @ViewModelInject constructor(
    private val repository: ChannelRepository):ViewModel() {

    val ChannelLiveData: MutableLiveData<List<Channels>> = MutableLiveData()
    val RecordingResponseLiveData: MutableLiveData<List<RecordingResponse>> = MutableLiveData()
    val CancelResponseLiveData: MutableLiveData<List<CancelResponse>> = MutableLiveData()

    fun getChannelData() {
        viewModelScope.launch {
            repository.getChannelData()
                .catch { e ->
                    Log.d("main", "getPost: ${e.message}")
                }.collect { response ->
                    ChannelLiveData.value = response
                }
        }
    }

    fun getRecordingResponse() {
        viewModelScope.launch {
            repository.getChannelData()
                .catch { e ->
                    Log.d("main", "getPost: ${e.message}")
                }.collect { response ->
                    RecordingResponseLiveData.value = response
                }

        }
    }

    fun getCancelResponse() {
        viewModelScope.launch {
            repository.getCancelResposnse()
                .catch { e ->
                    Log.d("main", "getPost: ${e.message}")
                }.collect { response ->
                    CancelResponseLiveData.value = response
                }

        }
    }
}
