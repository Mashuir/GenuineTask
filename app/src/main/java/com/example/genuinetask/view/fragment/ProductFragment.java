package com.example.genuinetask.view.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.genuinetask.databinding.FragmentProductBinding;
import com.example.genuinetask.model.ApiResponse;
import com.example.genuinetask.model.ProductModel;
import com.example.genuinetask.network.ApiClient;
import com.example.genuinetask.network.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;
    private static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiI3OCIsIkN1cnJlbnRDb21JZCI6IjEiLCJuYmYiOjE2ODE3MDI5OTAsImV4cCI6MTY4MjMwNzc5MCwiaWF0IjoxNjgxNzAyOTkwfQ.JCU1MPH_SOJsHYpOn9GKrYx90N3Tsdtut3rTU3Hl09g";


    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.productRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        loadProductsData();
    }

    private void loadProductsData() {

        ApiInterface apiInterface = ApiClient.getApiService(AUTH_TOKEN);
        Call<ApiResponse> productListCall = apiInterface.getProductList(AUTH_TOKEN);

        productListCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getSuccess() == 1) {

                    List<ProductModel> productList = response.body().getProductList();

                } else {
                    // Handle the error
                    Toast.makeText(requireContext(), "Failed to fetch ProductList", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle the error
                Toast.makeText(requireContext(), "Failed to fetch ProductList", Toast.LENGTH_SHORT).show();
            }
        });


    }
}