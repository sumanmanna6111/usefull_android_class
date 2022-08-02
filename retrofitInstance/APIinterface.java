package com.rward.recharge.client;

import com.rward.recharge.model.Post;
import com.rward.recharge.paytmgw.Checksum;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface APIinterface {

    //TODO POST Method

    @FormUrlEncoded
    @POST
    Call<String> postStringResponse(@Url String url, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<String> postStringResponse(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<ResponseBody> postResponseBody(@Url String url, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<ResponseBody> postResponseBody(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<Post> postToGson(@Url String url, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<Post> postToGson(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<List<Post>> postToList(@Url String url, @FieldMap Map<String, String> param);

    @FormUrlEncoded
    @POST
    Call<List<Post>> postToList(@Url String url, @HeaderMap Map<String, String> headers, @FieldMap Map<String, String> param);

    //TODO GET Method

    @GET
    Call<ResponseBody> getResponseBody(@Url String url, @QueryMap Map<String, String> param);

    @GET
    Call<ResponseBody> getResponseBody(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> param);

    @GET
    Call<ResponseBody> getResponseBody(@Url String url, @Header("Authorization") String authToken, @QueryMap Map<String, String> param);

    @GET
    Call<Post> getToGson(@Url String url, @QueryMap Map<String, String> param);

    @GET
    Call<Post> getToGson(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> param);

    @GET
    Call<Post> getToGson(@Url String url, @Header("Authorization") String authToken, @QueryMap Map<String, String> param);

    @GET
    Call<String> getStringResponse(@Url String url, @QueryMap Map<String, String> param);

    @GET
    Call<String> getStringResponse(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> param);

    @GET
    Call<String> getStringResponse(@Url String url, @Header("Authorization") String authToken, @QueryMap Map<String, String> param);

    //TODO POST BODY REQUEST JSON

    /*
       JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("retailer_name", name.getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(jsonData.toString(), mediaType);
        */

    @Headers({"Content-Type: text/plain"})// or you can use application/json
    @POST
    Call<ResponseBody> postBodyToResponseBody(@Url String url, @Header("Authorization") String authToken, @Body RequestBody body);

    @Headers({"Content-Type: text/plain"})
    @POST
    Call<ResponseBody> postBodyToResponseBody(@Url String url, @Body RequestBody body);

    @POST
    Call<ResponseBody> postBodyToResponseBody(@Url String url, @HeaderMap Map<String, String> headers, @Body RequestBody body);

    @Headers({"Content-Type: text/plain"})
    @POST
    Call<String> postBody(@Url String url, @Header("Authorization") String authToken, @Body RequestBody body);

    @Headers({"Content-Type: text/plain"})
    @POST
    Call<String> postBody(@Url String url, @Body RequestBody body);

    @POST
    Call<String> postBody(@Url String url, @HeaderMap Map<String, String> headers, @Body RequestBody body);

    @Headers({"Content-Type: text/plain"})
    @POST
    Call<Post> postBodyToGson(@Url String url, @Body RequestBody body);

    @POST
    Call<Post> postBodyToGson(@Url String url, @HeaderMap Map<String, String> headers, @Body RequestBody body);
}
