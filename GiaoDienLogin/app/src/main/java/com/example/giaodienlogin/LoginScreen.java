package com.example.giaodienlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.giaodienlogin.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {
    private ActivityLoginScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_login_screen);
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
                        Toast.makeText(LoginScreen.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginScreen.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginScreen.this, "Chưa có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}
