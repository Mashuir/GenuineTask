package com.example.genuinetask.network;

import com.example.genuinetask.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("invoiceapps/Values/GetProductList")
    Call<ApiResponse> getProductList(@Header("Authorization") String token);


}
