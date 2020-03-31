package com.example.serviceforcebd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "SignInActivity";
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void startSignUpActivity(View view) {
        Log.d(TAG, "startSignUpActivity: started");
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    private boolean validateEmail() {
        String email = binding.emailET.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            binding.emailET.setError("Field can't be empty!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailET.setError("Please enter a valid email address!");
            return false;
        } else {
            binding.emailET.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String password = binding.passwordET.getEditText().getText().toString().trim();
        if (password.isEmpty()) {
            binding.passwordET.setError("Field can't be empty!");
            return false;
        } else if (password.length()<6){
            binding.passwordET.setError("Password must have at least 6 characters!");
            return false;
        }else {
            binding.passwordET.setError(null);
            return true;
        }
    }

    public void confirmSignIn(View view) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
    }
}
