package com.example.baitap.Lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

import java.util.ArrayList;

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

        ArrayList<CustomAdapterBai2.Item> itemList = new ArrayList<>();
        itemList.add(new CustomAdapterBai2.Item("Bánh canh", "53000.0", R.drawable.banhcanh));
        itemList.add(new CustomAdapterBai2.Item("Bánh tráng", "25000.0", R.drawable.banhtrang));
        itemList.add(new CustomAdapterBai2.Item("Bún chả", "83000.0", R.drawable.buncha));

        CustomAdapterBai2 adapter = new CustomAdapterBai2(this, itemList);
        listView.setAdapter(adapter);
    }
}
