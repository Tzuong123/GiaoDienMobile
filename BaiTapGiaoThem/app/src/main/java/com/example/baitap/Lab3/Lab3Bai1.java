package com.example.baitap.Lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class Lab3Bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Thêm đoạn mã này để thiết lập ListView
        ListView listView = findViewById(R.id.listView1);

        String[] items = {"Facebook", "Linkedin", "MSN", "Skype", "Yahoo", "Twitter"};
        int[] images = {R.drawable.facebook, R.drawable.linkedin, R.drawable.msn, R.drawable.skype, R.drawable.yahoo, R.drawable.twitter};

        CustomAdapterBai1 adapter = new CustomAdapterBai1(this, items, images);
        listView.setAdapter(adapter);
    }
}
