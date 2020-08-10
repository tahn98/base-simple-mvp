package com.example.basemvp.service

import com.example.basemvp.model.Plant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SunflowerApi {
    companion object {
        private var instance : SunflowerApi? = null
        private const val BASE_URL = "https://raw.githubusercontent.com/"

        private fun create(): SunflowerApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SunflowerApi::class.java)
        }

        fun getInstance() : SunflowerApi{
            if (instance == null){
                synchronized(SunflowerApi::class.java){
                    instance = create()
                }
            }
            return instance!!
        }
    }

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    fun getAllPlants() : Call<List<Plant>>
}