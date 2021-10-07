package com.example.attmodule.DI

import com.example.attmodule.Network.ApiService
import com.example.attmodule.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun RetrofitInstance():Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) :ApiService=
        retrofit.create(ApiService::class.java)

    }


