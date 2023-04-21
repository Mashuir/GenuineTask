package com.example.genuinetask.view.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.genuinetask.R;
import com.example.genuinetask.adapter.ImageAdapter;
import com.example.genuinetask.adapter.ItemMarginDecoration;
import com.example.genuinetask.adapter.SliderAdapterExample;
import com.example.genuinetask.databinding.FragmentHomeBinding;
import com.example.genuinetask.model.ImageModel;
import com.example.genuinetask.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

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

        RecyclerView recyclerView = view.findViewById(R.id.categoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        int margin = getResources().getDimensionPixelSize(R.dimen.item_margin);
        ItemMarginDecoration decoration = new ItemMarginDecoration(margin);
        recyclerView.addItemDecoration(decoration);
        ImageAdapter adapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(adapter);


    }

    private void init(View view) {

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