package com.example.notification;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notification.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
    void initlization(){
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnNotify.setOnClickListener(v->{
            if(binding.etInputMsg.getText().toString().trim().isEmpty()){
                binding.etInputMsg.setError("Please enter message");
                binding.etInputMsg.requestFocus();
                Snackbar.make(binding.getRoot(),"Please enter message",Snackbar.LENGTH_SHORT).show();
            }
            else{

            }
        });
    }
}