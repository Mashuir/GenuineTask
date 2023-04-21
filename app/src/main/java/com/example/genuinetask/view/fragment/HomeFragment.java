package com.example.genuinetask.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.genuinetask.R;
import com.example.genuinetask.adapter.ImageAdapter;
import com.example.genuinetask.adapter.ItemMarginDecoration;
import com.example.genuinetask.adapter.SliderAdapterExample;
import com.example.genuinetask.databinding.FragmentHomeBinding;
import com.example.genuinetask.model.ImageModel;
import com.example.genuinetask.model.SliderItem;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ImageAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

        List<ImageModel> imageList = new ArrayList<>();
        imageList.add(new ImageModel(R.drawable.fruitscart, "Fruits and Vegetables", getString(R.string.categoryDescription)));
        imageList.add(new ImageModel(R.drawable.grocery, "Grocery and Staples", getString(R.string.categoryDescription)));
        imageList.add(new ImageModel(R.drawable.household, "Household Needs", getString(R.string.categoryDescription)));
        imageList.add(new ImageModel(R.drawable.wear, "Mans and Womens Wear", getString(R.string.categoryDescription)));
        imageList.add(new ImageModel(R.drawable.footwear, "Foot ware", getString(R.string.categoryDescription)));

        binding.categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        int margin = getResources().getDimensionPixelSize(R.dimen.item_margin);
        ItemMarginDecoration decoration = new ItemMarginDecoration(margin);
        binding.categoryRecyclerView.addItemDecoration(decoration);
        adapter = new ImageAdapter(imageList);
        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ImageModel item) {
                if (item == imageList.get(0)) {
                    ProductFragment myFragment = new ProductFragment();
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, myFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            }
        });

        binding.categoryRecyclerView.setAdapter(adapter);

    }

    private void init(View view) {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(requireActivity(), binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.icon_drawer_menu);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //---------------Slider Part

        SliderView sliderView = view.findViewById(R.id.imageSlider);

        List<SliderItem> list = new ArrayList<>();
        list.add(new SliderItem(Uri.parse("https://scontent.fdac155-1.fna.fbcdn.net/v/t39.30808-6/305392609_461443622664304_5237906966765012539_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=924451&_nc_ohc=w0O452TyWMsAX-28UoN&_nc_ht=scontent.fdac155-1.fna&oh=00_AfCIIjm_3Z3gLKu7_0Hj0aGtc0B33Y0P2yl-2Ut9FpQLgw&oe=6389CFBC")));

        SliderAdapterExample adapter = new SliderAdapterExample(getContext(), list);

        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(10); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}