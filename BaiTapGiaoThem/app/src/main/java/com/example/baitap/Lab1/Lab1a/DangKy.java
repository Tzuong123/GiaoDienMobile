package com.example.baitap.Lab1.Lab1a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.databinding.ActivityDangKyBinding;

public class DangKy extends AppCompatActivity {
    private ActivityDangKyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDangKyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_dang_ky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSignupS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.accountEmail1.getText().toString();
                String password = binding.accountPassword1.getText().toString();
                String repassword = binding.accountRepassword1.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)) {
                    Toast.makeText(DangKy.this, "Nhập đầy đủ tt", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(repassword)) {
                        Toast.makeText(DangKy.this, "Success", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DangKy.this, DangNhap.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("Email", email);
                        bundle.putString("Password", password);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        Toast.makeText(DangKy.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKy.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }
}