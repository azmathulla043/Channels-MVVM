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
    fun getChannelData() : Flow<List<Channels>> = flow {
        flow<Channels> {
            val response = apiService.getProgramChannel()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    fun getRecordingResponse() :Flow<List<RecordingResponse>> = flow {
        flow<RecordingResponse> {
            val response = apiService.RecordingRequest()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    fun getCancelResposnse() :Flow<List<RecordingResponse>> = flow {
        flow<CancelResponse> {
            val response = apiService.RecordingCancel()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}