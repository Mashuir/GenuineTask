package com.example.genuinetask.view.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.genuinetask.R;
import com.example.genuinetask.adapter.SliderAdapterExample;
import com.example.genuinetask.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
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