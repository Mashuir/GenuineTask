package com.example.genuinetask.network;

import com.example.genuinetask.model.ProductModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Values/GetProductList")
    Call<List<ProductModel>> getProductList();

}
