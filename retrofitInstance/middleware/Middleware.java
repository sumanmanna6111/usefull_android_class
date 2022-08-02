package com.rward.recharge.client.middleware;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.rward.recharge.adapter.RewardListAdapter;
import com.rward.recharge.client.API;
import com.rward.recharge.client.APIinterface;
import com.rward.recharge.client.RetrofitClient;
import com.rward.recharge.sc.RSAEncryption;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Middleware {
    private static RSAEncryption rsaEncryption = new RSAEncryption();

    public static void request(String url, String payload, CustomCallback callback) {
        // rsaEncryption = new RSAEncryption();
        if (API.cryptoEnable) {
            try {
                String encrypted = rsaEncryption.Encrypt(payload);
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = RequestBody.create(encrypted, mediaType);
                RetrofitClient.getRetrofitInstance().create(APIinterface.class).postBodyToResponseBody(url, body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            if (response.isSuccessful() && response.body() != null) {
                                String res = response.body().string();
                                String decrypted = rsaEncryption.Decrypt(res);
                                callback.onResponse(decrypted);
                            } else {
                                callback.onResponse("{\"status\":0,\"msg\":\"No response\"}");
                            }
                        } catch (Exception e) {
                            callback.onResponse("{\"status\":0,\"msg\":\"Invalid response\"}");
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callback.onFailure(t.getMessage());
                        Log.e("TAG", "onFailure: ");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(payload, mediaType);
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                RetrofitClient.getRetrofitInstance().create(APIinterface.class).postBodyToResponseBody(url, headers, body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            if (response.isSuccessful() && response.body() != null) {
                                String res = response.body().string();
                                callback.onResponse(res);
                            } else {
                                callback.onResponse("{\"status\":0,\"msg\":\"No response\"}");
                            }
                        } catch (Exception e) {
                            callback.onResponse("{\"status\":0,\"msg\":\"Invalid response\"}");
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callback.onFailure(t.getMessage());
                        Log.e("TAG", "onFailure: ");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
