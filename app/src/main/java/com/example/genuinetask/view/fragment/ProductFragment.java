package com.example.genuinetask.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.genuinetask.R;
import com.example.genuinetask.adapter.ProductsAdapter;
import com.example.genuinetask.databinding.FragmentHomeBinding;
import com.example.genuinetask.databinding.FragmentProductBinding;
import com.example.genuinetask.model.ProductModel;
import com.example.genuinetask.network.ApiClient;
import com.example.genuinetask.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;
    ProductsAdapter adapter;
    List<ProductModel> productList;

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

        productList = new ArrayList<>();
        adapter = new ProductsAdapter(requireContext(),productList);
        binding.productRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.productRecyclerView.setAdapter(adapter);

        loadProductsData();
    }

    private void loadProductsData() {
        ApiInterface apiInterface = ApiClient.getClient("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiI3OCIsIkN1cnJlbnRDb21JZCI6IjEiLCJuYmYiOjE2ODE3MDI5OTAsImV4cCI6MTY4MjMwNzc5MCwiaWF0IjoxNjgxNzAyOTkwfQ.JCU1MPH_SOJsHYpOn9GKrYx90N3Tsdtut3rTU3Hl09g");
        apiInterface.getProductList().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

            }
        });
    }
}