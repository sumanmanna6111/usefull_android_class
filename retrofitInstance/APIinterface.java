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

    @GET("https://digitalcatalog.paytm.com/dcat/v1/browseplans/mobile/7166?channel=web&version=2&child_site_id=1&site_id=1&locale=en-in&pageCount=1&itemsPerPage=20&sort_price=asce&pagination=1")
    Call <ResponseBody> getResponse(@Query("operator") String operator, @Query("circle") String circle);

  
}
