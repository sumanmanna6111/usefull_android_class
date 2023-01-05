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
