 HashMap<String, String> parameters = new HashMap<>();
        parameters.put("username", userName);
        parameters.put("password", password);
        
        ApiRequest.Call_Api(this, "https://example.com/login", parameters, new Callback() {
            @Override
            public void Responce(String resp) {
                
            }
        });
