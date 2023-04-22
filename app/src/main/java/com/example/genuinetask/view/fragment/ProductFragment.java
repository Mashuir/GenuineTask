package com.example.genuinetask.view.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.genuinetask.adapter.ProductsAdapter;
import com.example.genuinetask.databinding.FragmentProductBinding;
import com.example.genuinetask.model.ApiResponse;
import com.example.genuinetask.model.ProductModel;
import com.example.genuinetask.network.ApiClient;
import com.example.genuinetask.network.ApiInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    FragmentProductBinding binding;
    ProductsAdapter adapter;
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

        // Retrieve the string argument
        Bundle bundle = getArguments();
        if (bundle != null) {
            String categoryName = bundle.getString("categoryName", "");
            binding.categoryNameTV.setText(categoryName);
        }

        binding.backArrowIV.setOnClickListener(v -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        });

        SharedPreferences preferences = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Set<String> IDset = preferences.getStringSet("Items", new HashSet<>());
        if (IDset.size() > 0) {
            binding.stockSizeTV.setVisibility(View.VISIBLE);
            binding.stockSizeTV.setText(String.valueOf(IDset.size()));
        }else {
            binding.stockSizeTV.setVisibility(View.GONE);
        }

        binding.productRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.productRecyclerView.hasFixedSize();
        loadProductsData();
    }

    private void loadProductsData() {

        ApiInterface apiInterface = ApiClient.getApiService(AUTH_TOKEN);
        Call<ApiResponse> productListCall = apiInterface.getProductList(AUTH_TOKEN);

        productListCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getSuccess() == 1) {

                    List<ProductModel> productList = response.body().getProductList();
                    adapter = new ProductsAdapter(requireContext(), productList, binding.rootLayoutProductFragment,binding.stockSizeTV);
                    binding.productRecyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    binding.resultSizeTV.setText(productList.size() + " Products Founds");

                } else {
                    // Handle the error
                    Toast.makeText(requireContext(), "Failed to fetch ProductList", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                // Handle the error
                Toast.makeText(requireContext(), "Failed to fetch ProductList", Toast.LENGTH_SHORT).show();
            }
        });


    }
}