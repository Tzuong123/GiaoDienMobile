package com.example.baitap.Lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

public class Lab3Bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listView);

        String[] items1 = {"Bánh canh", "Bánh tráng", "Bún chả"};
        String[] items2 = {"53000.0", "25000.0", "83000.0"};
        int[] images = {R.drawable.banhcanh, R.drawable.banhtrang, R.drawable.buncha};

        CustomAdapterBai2 adapter = new CustomAdapterBai2(this, items1, items2, images);
        listView.setAdapter(adapter);
    }
}