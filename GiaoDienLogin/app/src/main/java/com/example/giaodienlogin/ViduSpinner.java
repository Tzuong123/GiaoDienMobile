package com.example.giaodienlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViduSpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vidu_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spinner1);
        //tao du lieu de do len spn
        String[] list = new String[]{"C#","Java","Tin hoc","LT Mobile"};
        // tao doi tuong adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        ListView lstvd2 = findViewById(R.id.lstvd2);
        // tao danh sach
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Nguyen Van A");
        list1.add("Nguyen Van B");
        list1.add("Nguyen Van C");
        list1.add("Nguyen Van D");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        lstvd2.setAdapter(adapter1); // do du lieu len listview
        //
        lstvd2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(ViduSpinner.this, list1.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
