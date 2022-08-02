package com.rward.recharge.client.middleware;

import retrofit2.Call;
import retrofit2.Response;

public interface CustomCallback {
    void onResponse(String  response);

    void onFailure(String  error);
}
