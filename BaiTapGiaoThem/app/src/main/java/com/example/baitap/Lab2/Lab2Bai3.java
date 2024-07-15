package com.example.baitap.Lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;
import com.example.baitap.databinding.ActivityLab2Bai3Binding;

public class Lab2Bai3 extends AppCompatActivity {

    private ActivityLab2Bai3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //binding = ActivityLab2Bai3Binding.inflate(getLayoutInflater());
        //View view = binding.getRoot();
        setContentView(ActivityLab2Bai3Binding.inflate(getLayoutInflater()).getRoot());
        //setContentView(R.layout.activity_lab2_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnlab2bai3hienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiThongTin();
            }
        });

        binding.btnlab2bai3thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void hienThiThongTin() {
        String maGVText = binding.etext1.getText().toString();
        String hoTenText = binding.etext2.getText().toString();

        // Lấy giới tính được chọn
        int gioiTinhId = binding.rg1.getCheckedRadioButtonId();
        RadioButton gioiTinh = findViewById(gioiTinhId);
        String gioiTinhText = gioiTinh != null ? gioiTinh.getText().toString() : "";

        // Lấy sở thích được chọn
        StringBuilder soThichText = new StringBuilder();
        if (binding.xemphim.isChecked()) soThichText.append("Xem phim, ");
        if (binding.cahat.isChecked()) soThichText.append("Ca hát, ");
        if (binding.docsach.isChecked()) soThichText.append("Đọc sách, ");
        if (binding.nghenhac.isChecked()) soThichText.append("Nghe nhạc, ");
        if (binding.dulich.isChecked()) soThichText.append("Du lịch, ");
        if (binding.theduc.isChecked()) soThichText.append("Thể dục, ");

        // Xóa dấu phẩy và khoảng trắng cuối cùng
        if (soThichText.length() > 0) soThichText.setLength(soThichText.length() - 2);

        // Hiển thị thông tin trong một hộp thoại
        String thongTin = "Mã GV: " + maGVText + "\n"
                + "Họ tên: " + hoTenText + "\n"
                + "Giới tính: " + gioiTinhText + "\n"
                + "Sở thích: " + soThichText;

        new AlertDialog.Builder(this)
                .setTitle("Thông tin giáo viên")
                .setMessage(thongTin)
                .setPositiveButton("OK", null)
                .show();
    }
}