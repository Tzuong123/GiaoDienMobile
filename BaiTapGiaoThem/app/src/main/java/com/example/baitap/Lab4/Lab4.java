package com.example.baitap.Lab4;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap.R;

import java.util.ArrayList;

public class Lab4 extends AppCompatActivity {

    private ArrayList<CustomAdapterLab4.Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView grid = findViewById(R.id.Glayoutlab4);

        itemList = new ArrayList<>();

        itemList.add(new CustomAdapterLab4.Item("Sinh tố", "1000000", R.drawable.sinhto));
        itemList.add(new CustomAdapterLab4.Item("Cafe", "1000000", R.drawable.cafe));
        itemList.add(new CustomAdapterLab4.Item("Chè liên", "1000000", R.drawable.chelienjpg));
        itemList.add(new CustomAdapterLab4.Item("Bánh canh", "53000.0", R.drawable.banhcanh));
        itemList.add(new CustomAdapterLab4.Item("Bánh tráng", "25000.0", R.drawable.banhtrang));
        itemList.add(new CustomAdapterLab4.Item("Bún chả", "83000.0", R.drawable.buncha));

        registerForContextMenu(grid);

        CustomAdapterLab4 adapter = new CustomAdapterLab4(this, itemList);
        grid.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.ban_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        if (info != null) {
            int position = info.position;
            CustomAdapterLab4.Item food = itemList.get(position);
            String foodName = food.getTen();

            String tableTitle = item.getTitle().toString();

            Toast.makeText(this, tableTitle + " chọn đặt: " + foodName, Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
