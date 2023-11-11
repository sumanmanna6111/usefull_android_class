package com.gtech.testnavgraph.network

import okhttp3.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url


interface ApiInterface {

    @FormUrlEncoded
    @POST
    fun postResponseBody(
        @Url url: String,
        @FieldMap param: HashMap<String, String>
    ): retrofit2.Call<ResponseBody>

    @POST
    fun test(@Url url: String, @Body body: RequestBody): retrofit2.Call<ResponseBody>
}