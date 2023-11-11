        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("key", "value");
        } catch (Exception e) {
            e.printStackTrace();
        }

         Middleware.request(API.transaction, jsonData.toString(), new CustomCallback() {
            @Override
            public void onResponse(String response) {
                
                }

            @Override
            public void onFailure(String error) {
            }
         }


//in kotlin

 val mediaType: MediaType = "application/json".toMediaTypeOrNull()!!
            val body: RequestBody = RequestBody.create(mediaType, jsonObject.toString())
 RetrofitClient().getRetrofitInstance()?.create(ApiInterface::class.java)?.
            test(API.login, body)?.
            enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: retrofit2.Response<ResponseBody>
                ) {
                    Log.d("TAG", "onResponse: ${response.body()?.string()}")
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
            } )
