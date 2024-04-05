package com.gtech.testnavgraph.network

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.QueryMap
import retrofit2.http.Url


interface ApiInterface {

    @FormUrlEncoded
    @POST
    fun postRequest(@Url url: String, @FieldMap param: Map<String, String>): Call<ResponseBody>

    @GET
    fun getRequest(@Url url: String, @QueryMap param: Map<String, String>): Call<ResponseBody>

    @Multipart
    @POST
    fun upload(@Url url: String, @Part file: MultipartBody.Part): Call<ResponseBody>
}
