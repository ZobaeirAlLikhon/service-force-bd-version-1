package com.example.serviceforcebd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.databinding.ActivityAddressBinding;

public class AddressActivity extends AppCompatActivity {

    private ActivityAddressBinding binding;
    private static final String TAG = "AddressActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            Log.d(TAG, "onCreate: "+bundle.getString("address"));
        }

    }
}
