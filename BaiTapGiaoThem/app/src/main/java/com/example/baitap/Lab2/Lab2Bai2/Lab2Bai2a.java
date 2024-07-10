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

import com.example.baitap.Lab1.Lab1a.DangKy;
import com.example.baitap.R;
import com.example.baitap.databinding.ActivityLab2Bai2aBinding;

public class Lab2Bai2a extends AppCompatActivity {
    private ActivityLab2Bai2aBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLab2Bai2aBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_lab2_bai2a);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnlab2bai2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.rbtntrue.isChecked()) {
                    Toast.makeText(Lab2Bai2a.this, "Đáp án chính xác", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Lab2Bai2a.this, Lab2Bai2b.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Lab2Bai2a.this, "Đáp án sai", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}