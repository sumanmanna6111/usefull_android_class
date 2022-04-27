package com.rward.recharge.client;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rward.recharge.model.ResultData;

import java.util.List;
public class Post {
    @SerializedName("status")
    private int status;
    @SerializedName("result")
    private List<ResultData> result;
    @SerializedName("msg")
    private String message;
    @SerializedName("balance")
    private String balance;
    public int getStatus() {
        return status;
    }
    public List<ResultData> getResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
    @SerializedName("version")
    private ResultData version;
    public ResultData getVersion() {
        return version;
    }

    public String getBalance() {
        return balance;
    }

}
