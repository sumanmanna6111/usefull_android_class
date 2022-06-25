package com.rward.recharge.client;

import androidx.annotation.Keep;

import com.rward.recharge.paytmgw.Checksum;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIinterface {
    /*@GET("api/rechist.php")
    Call<Post> getPosts();*/
    
   @FormUrlEncoded
   @POST
   Call<Post> getPosts(@Url String url, @FieldMap Map<String,String> param);

    @FormUrlEncoded
    @POST
    Call <List<Post>> getPostsList(@Url String url, @FieldMap Map<String,String> param);

    @FormUrlEncoded
    @POST
    Call<ResponseBody> postResponse(@Url String url, @FieldMap Map<String,String> param);//for string response

    @GET
    Call<ResponseBody> getResponse(@Url String url, @QueryMap Map<String,String> param);//for string response
    
    /* 
    @GET("")
    Call<String> listRepos( );// use string when converter is scaler */

  
}
