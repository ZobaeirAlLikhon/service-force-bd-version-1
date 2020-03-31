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
                Intent intent = new Intent(context, ServicesActivity.class);
                intent.putExtra("service",service);
                startActivity(intent);
            }
        });

        binding.beautyServiceCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SignInActivity.class);
                startActivity(intent);
            }
        });
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
