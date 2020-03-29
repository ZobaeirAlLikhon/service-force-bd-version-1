package com.example.serviceforcebd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.serviceforcebd.databinding.ActivityMainBinding;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.carouselView.setPageCount(sampleImages.length);
        binding.carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setCropToPadding(true);
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
