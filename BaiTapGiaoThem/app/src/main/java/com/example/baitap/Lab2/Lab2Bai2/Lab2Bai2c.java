package com.example.baitap.Lab2.Lab2Bai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.Lab2.Lab2;
import com.example.baitap.R;
import com.example.baitap.databinding.ActivityLab2Bai2cBinding;

public class Lab2Bai2c extends AppCompatActivity {
private ActivityLab2Bai2cBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLab2Bai2cBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_lab2_bai2c);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnlab2bai2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.rbtntrue.isChecked()) {
                    Toast.makeText(Lab2Bai2c.this, "Đáp án chính xác", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Lab2Bai2c.this, Lab2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Lab2Bai2c.this, "Đáp án sai", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}