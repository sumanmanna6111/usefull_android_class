package com.busybox.grammya.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
static boolean is_secure_info = false;
    public static void Call_Api (final Context context, final String url, HashMap<String,String> param, final Callback callback){


        if(!is_secure_info) {
            final String[] urlsplit = url.split("/");
            Log.d("TAG", url);

            if (param != null)
                Log.d("TAG" + urlsplit[urlsplit.length - 1], param.toString());
        }

         StringRequest jsonObjReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        if(!is_secure_info) {
                            final String[] urlsplit = url.split("/");
                            Log.d("TAG" + urlsplit[urlsplit.length - 1], response.toString());
                        }

                        if(callback!=null)
                        callback .Responce(response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(!is_secure_info) {
                    final String[] urlsplit = url.split("/");
                    Log.d("TAG" + urlsplit[urlsplit.length - 1], error.toString());
                }

                if(callback!=null)
                  callback .Responce(error.toString());

            }
        }) {
            /* @Override
             public String getBodyContentType() {
                 return "application/json; charset=utf-8";
             }*/

             @Override
             public Map<String, String> getParams() throws AuthFailureError {
                 HashMap<String, String> headers = new HashMap<String, String>();
                 headers.put("","");

                 return param;
             }
         };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.getCache().clear();
        requestQueue.add(jsonObjReq);
    }


}
