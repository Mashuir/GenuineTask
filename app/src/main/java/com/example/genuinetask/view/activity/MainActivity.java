package com.example.genuinetask.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.genuinetask.IOnBackPressed;
import com.example.genuinetask.R;
import com.example.genuinetask.view.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        ((BottomNavigationView) findViewById(R.id.bottomNavigation)).setSelectedItemId(R.id.navigation_home);


        bottomNavigationView.setOnItemSelectedListener(item -> {

           // int itemId = item.getItemId();
           // if (itemId == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
                //item.setIcon(R.drawable.ic_baseline_home_24);
           // }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            /*transaction.setCustomAnimations(androidx.transition.R.anim.fragment_fade_enter, androidx.transition.R.anim.fragment_fade_exit,
                    androidx.transition.R.anim.fragment_fade_enter, androidx.transition.R.anim.fragment_fade_exit);*/
            transaction.replace(R.id.frameLayout, selectedFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            return true;
        });

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }
}