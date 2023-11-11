package com.gtech.testnavgraph.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit?{
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
        return retrofit
    }
}