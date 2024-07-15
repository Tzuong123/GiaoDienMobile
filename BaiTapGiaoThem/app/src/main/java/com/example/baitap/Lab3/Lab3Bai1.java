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

public class Lab3Bai1 extends AppCompatActivity {
    private final ArrayList<CustomAdapterBai1.App> list = new ArrayList<>();

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

        ListView listView = findViewById(R.id.listView1);

        list.add(new CustomAdapterBai1.App(R.drawable.facebook, "Facebook"));
        list.add(new CustomAdapterBai1.App(R.drawable.linkedin, "Linkedin"));
        list.add(new CustomAdapterBai1.App(R.drawable.msn, "MSN"));
        list.add(new CustomAdapterBai1.App(R.drawable.skype, "Skype"));
        list.add(new CustomAdapterBai1.App(R.drawable.yahoo, "Yahoo"));
        list.add(new CustomAdapterBai1.App(R.drawable.twitter, "Twitter"));

        CustomAdapterBai1 adapter = new CustomAdapterBai1(this, list);
        listView.setAdapter(adapter);
    }
}

//String[] items = {"Facebook", "Linkedin", "MSN", "Skype", "Yahoo", "Twitter"};
//int[] images = {R.drawable.facebook, R.drawable.linkedin, R.drawable.msn, R.drawable.skype, R.drawable.yahoo, R.drawable.twitter};
