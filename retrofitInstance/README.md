```java
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
```

//in kotlin

```kotlin
        val params = HashMap<String, String>()
        params["phone"] = phone
        params["password"] = password
        RetrofitClient.getInstance().create(APIInterface::class.java).login(params)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.body() != null) {
                        loginLiveData.postValue(response.body()?.string())
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginLiveData.postValue(API.NO_INTERNET)
                    Log.d("TAG", "onFailure: ")
                }

            })
```
