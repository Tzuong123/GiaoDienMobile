package com.example.giaodienlogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.giaodienlogin.databinding.ActivitySignupScreenBinding;

public class SignupScreen extends AppCompatActivity {
    private ActivitySignupScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSignupS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.accountName.getText().toString();
                String email = binding.accountEmail.getText().toString();
                String password = binding.accountPassword.getText().toString();
                String repassword = binding.accountRepassword.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)) {
                    Toast.makeText(SignupScreen.this, "Nhập đầy đủ tt", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(repassword)) {
                        Toast.makeText(SignupScreen.this, "Success", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("Name", name);
                        bundle.putString("Email", email);
                        bundle.putString("Password", password);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignupScreen.this, "Passwords do not match", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}
