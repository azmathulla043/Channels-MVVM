package com.example.attmodule.Network

import com.example.attmodule.Model.CancelResponse
import com.example.attmodule.Model.Channels
import com.example.attmodule.Model.RecordingResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/programs?channel_number=1")
    suspend fun getProgramChannel():List<Channels>

    @POST("recording?channel_number=1&program_id=1234")
    suspend fun RecordingRequest():List<RecordingResponse>

    @POST("/recording?recording_id=3456")
    suspend fun RecordingCancel():List<CancelResponse>

}