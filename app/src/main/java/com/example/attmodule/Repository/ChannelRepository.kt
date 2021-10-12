package com.example.attmodule.Repository

import com.example.attmodule.Model.CancelResponse
import com.example.attmodule.Model.Channels
import com.example.attmodule.Model.RecordingResponse
import com.example.attmodule.Network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class ChannelRepository @Inject constructor(private val apiService: ApiService) {
    fun getChannelData()  = flow {
            val response = apiService.getProgramChannel()
            emit(response)
        }.flowOn(Dispatchers.IO)


    fun getRecordingResponse() = flow {
            val response = apiService.RecordingRequest()
            emit(response)
        }.flowOn(Dispatchers.IO)


    fun getCancelResposnse() = flow {
            val response = apiService.RecordingCancel()
            emit(response)
        }.flowOn(Dispatchers.IO)

}