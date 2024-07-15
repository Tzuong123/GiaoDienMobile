package com.example.baitap.Lab1.Lab1a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.databinding.ActivityDangNhapBinding;

public class DangNhap extends AppCompatActivity {
    private ActivityDangNhapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDangNhapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_dang_nhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnLoginL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Bundle bundle = i.getExtras();
                if (bundle != null) {
                    String email = bundle.getString("Email");
                    String password = bundle.getString("Password");
                    boolean e = email.equals(binding.accountEmail.getText().toString());
                    boolean p = password.equals(binding.accountPassword.getText().toString());
                    if (e && p) {
                        Toast.makeText(DangNhap.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DangNhap.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DangNhap.this, "Chưa có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });
    }
}