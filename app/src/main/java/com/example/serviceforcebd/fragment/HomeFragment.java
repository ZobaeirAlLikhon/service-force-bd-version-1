package com.example.serviceforcebd.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.activity.ServicesActivity;
import com.example.serviceforcebd.activity.SignInActivity;
import com.example.serviceforcebd.databinding.FragmentHomeBinding;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};
    private Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.carouselView.setPageCount(sampleImages.length);
        binding.carouselView.setImageListener(imageListener);

        binding.cleaningCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Cleaning";
                initService(service);
            }
        });

        binding.beautyServiceCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Beauty Services";
                initService(service);
            }
        });

        binding.shiftingCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Shifting";
                initService(service);
            }
        });

        binding.medicalServiceCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Medical";
                initService(service);
            }
        });

        binding.rentACarCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Rent-A-Car";
                initService(service);
            }
        });

        binding.eventManagementCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Event Management";
                initService(service);
            }
        });

        binding.itSupportCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "IT Support";
                initService(service);
            }
        });

        binding.homeDeliveryCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Home Delivery";
                initService(service);
            }
        });

        binding.tuitionManagementCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String service = "Tuition Service";
                initService(service);
            }
        });
    }

    private void initService(String service) {
        Intent intent = new Intent(context, ServicesActivity.class);
        intent.putExtra("service",service);
        startActivity(intent);

    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setCropToPadding(true);
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
