package com.example.genuinetask.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://pqstec.com/";
    private static Retrofit retrofit = null;

    public static ApiInterface getApiService(String token) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface apiService = retrofit.create(ApiInterface.class);

        // Add authorization header to every request
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Authorization", token)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        retrofit = retrofit.newBuilder()
                .client(httpClient.build())
                .build();

        return apiService;
    }
}


