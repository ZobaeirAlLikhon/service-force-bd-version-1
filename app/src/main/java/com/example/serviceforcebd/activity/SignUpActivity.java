package com.example.serviceforcebd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.example.serviceforcebd.R;
import com.example.serviceforcebd.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }

    private boolean validateName() {
        String name = binding.nameET.getEditText().getText().toString().trim();
        if (name.isEmpty()) {
            binding.nameET.setError("Field can't be empty!");
            return false;
        } else {
            binding.nameET.setError(null);
            return true;
        }
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
        } else if (password.length() < 6) {
            binding.passwordET.setError("Password must have at least 6 characters!");
            return false;
        } else {
            binding.passwordET.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String password = binding.passwordET.getEditText().getText().toString().trim();
        String confirmPassword = binding.confirmPasswordET.getEditText().getText().toString().trim();
        if (confirmPassword.isEmpty()) {
            binding.confirmPasswordET.setError("Field can't be empty!");
            return false;
        } else if (confirmPassword.length() < 6) {
            binding.confirmPasswordET.setError("Password must have at least 6 characters!");
            return false;
        } else if (!password.equals(confirmPassword)) {
            binding.confirmPasswordET.setError("Password are not matching!");
            return false;
        } else {
            binding.confirmPasswordET.setError(null);
            return true;
        }
    }

    public void confirmSignUp(View view) {
        if (!validateName() | !validateEmail() | !validatePassword() | !validateConfirmPassword()) {
            return;
        }

        startActivity(new Intent(this, MainActivity.class));


    }

    public void gotoSignIn(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }
}
