package com.sfbd.serviceforcebd.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.sfbd.serviceforcebd.databinding.ActivityLocationBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private static final int LOCATION_REQUEST_CODE = 1001;
    private ActivityLocationBinding binding;
    private String address;
    private String category;

    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            category = bundle.getString("category");
            binding.toolbarTV.setText(category);
        }

        binding.customAddressTV.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddressActivity.class);
            intent.putExtra("orderItem",category);
            startActivity(intent);
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);



        binding.backBtn.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastLocation();
        } else {
            askLocationPermission();
        }

        binding.currentAddressTV.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddressActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("orderItem", category);
            startActivity(intent);
        });
    }

    private void getLastLocation() {
        Log.d(TAG, "getLastLocation: started");

        Task<Location> locationTask = fusedLocationProviderClient.getLastLocation();

        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null) {
                    Log.d(TAG, "onSuccess: Location : " + location.toString());
                    Log.d(TAG, "onSuccess: Latitude: " + location.getLatitude());
                    Log.d(TAG, "onSuccess: Longitude: " + location.getLongitude());
                    Log.d(TAG, "onSuccess: Time: " + location.getTime());

                    address = getCompleteAddressString(location.getLatitude(), location.getLongitude());
                    Log.d(TAG, "onSuccess: Address : " + address);
                    binding.currentAddressTV.setText(address);

                }

            }
        });

        locationTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
            }
        });

        /*
        // OR You can write this bellow
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

            }
        });*/

    }

    private void askLocationPermission() {
        Log.d(TAG, "askLocationPermission: started");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "You should give the permission!", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
            /* First time user use this application*/
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    /*User Granted or Denied Location Permission to check*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                /*Permission Granted*/
                getLastLocation();
            } else {
                /*Permission Denied*/

            }
        }
    }

    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i));
                }
                strAdd = strReturnedAddress.toString();
                //Log.w("My Current loction address", strReturnedAddress.toString());
                Log.d(TAG, "getCompleteAddressString: " + strReturnedAddress.toString());
            } else {
                //Log.w("My Current loction address", "No Address returned!");
                Log.d(TAG, "getCompleteAddressString: No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "My Current location address Can not get Address!");
        }
        return strAdd;
    }
}
