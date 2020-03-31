package com.example.serviceforcebd.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.databinding.ActivityMainBinding;
import com.example.serviceforcebd.fragment.ChatFragment;
import com.example.serviceforcebd.fragment.HomeFragment;
import com.example.serviceforcebd.fragment.MoreFragment;
import com.example.serviceforcebd.fragment.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private Fragment selectedFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initBottomNavigation();

        selectedFragment = new HomeFragment();
        initFragment(selectedFragment);



        /*binding.carouselView.setPageCount(sampleImages.length);
        binding.carouselView.setImageListener(imageListener);*/
    }

  /*  ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setCropToPadding(true);
            imageView.setImageResource(sampleImages[position]);
        }
    };*/

    private void initBottomNavigation() {
        Log.d(TAG, "initBottomNavigation: started");


        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homeBN:
                        selectedFragment = new HomeFragment();
                        initFragment(selectedFragment);
                        break;

                    case R.id.orderBN:
                        selectedFragment = new OrderFragment();
                        initFragment(selectedFragment);
                        break;

                    case R.id.chatBN:
                        selectedFragment = new ChatFragment();
                        initFragment(selectedFragment);
                        break;

                    case R.id.moreBN:
                        selectedFragment = new MoreFragment();
                        initFragment(selectedFragment);
                        break;

                }

                return true;
            }
        });
    }

    private void initFragment(Fragment selectedFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragmentContainer, selectedFragment).commit();
    }
}
