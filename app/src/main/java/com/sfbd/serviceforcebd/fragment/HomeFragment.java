package com.sfbd.serviceforcebd.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sfbd.serviceforcebd.R;
import com.sfbd.serviceforcebd.activity.ServicesActivity;
import com.sfbd.serviceforcebd.databinding.FragmentHomeBinding;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private int[] sampleImages = {R.drawable.imageone, R.drawable.imagetwo};
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
        initView();
        init();

        return binding.getRoot();
    }

    private void initView() {

        binding.cleaningCV.setOnClickListener(view -> {
            String service = "Cleaning";
            initService(service);
        });

        binding.beautyServiceCV.setOnClickListener(view -> {
            String service = "Beauty Services";
            initService(service);
        });

        binding.shiftingCV.setOnClickListener(view -> {
            String service = "Shifting";
            initService(service);
        });

        binding.medicalServiceCV.setOnClickListener(view -> {
            String service = "Medical";
            initService(service);
        });

        binding.rentACarCV.setOnClickListener(view -> {
            String service = "Rent-A-Car";
            initService(service);
        });

        binding.eventManagementCV.setOnClickListener(view -> {
            String service = "Event Management";
            initService(service);
        });

        binding.itSupportCV.setOnClickListener(view -> {
            String service = "IT Support";
            initService(service);
        });

        binding.homeDeliveryCV.setOnClickListener(view -> {
            String service = "Home Delivery";
            initService(service);
        });

        binding.tuitionManagementCV.setOnClickListener(view -> {
            String service = "Tuition Service";
            initService(service);
        });

    }

    private void init() {
        binding.carouselView.setPageCount(sampleImages.length);
        binding.carouselView.setImageListener(imageListener);


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
