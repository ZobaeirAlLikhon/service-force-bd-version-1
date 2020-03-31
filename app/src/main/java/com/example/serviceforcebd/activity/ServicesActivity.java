package com.example.serviceforcebd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.databinding.ActivityServicesBinding;

public class ServicesActivity extends AppCompatActivity {


    private ActivityServicesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String service = bundle.getString("service");
            binding.toolbarTV.setText(service);
        }


    }
}
