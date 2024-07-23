package com.example.baitap.Lab5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

import java.util.ArrayList;
import java.util.Calendar;

public class Lab5 extends AppCompatActivity {
    private ArrayList<Lich> list = new ArrayList<>();
    private LichAdapter lichAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lichAdapter = new LichAdapter(list);
        recyclerView.setAdapter(lichAdapter);

        Button btnthemsk = findViewById(R.id.btnthem);
        btnthemsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddEventDialog();
            }
        });
    }

    private void showAddEventDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_su_kien);

        EditText edttieude = dialog.findViewById(R.id.edttieude);
        Button btnchonngay = dialog.findViewById(R.id.btnchonngay);
        Button btnchonthoigian = dialog.findViewById(R.id.btnchonthoigian);
        EditText edtghichu = dialog.findViewById(R.id.edtghichu);
        Button btnluu = dialog.findViewById(R.id.btnluu);

        final String[] selectedDate = {""};
        final String[] selectedTime = {""};

        btnchonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Lab5.this,
                        (view, year1, month1, dayOfMonth) -> selectedDate[0] = dayOfMonth + "/" + (month1 + 1) + "/" + year1,
                        year, month, day);
                datePickerDialog.show();
            }
        });

        btnchonthoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(Lab5.this,
                        (view, hourOfDay, minute1) -> selectedTime[0] = hourOfDay + ":" + minute1,
                        hour, minute, true);
                timePickerDialog.show();
            }
        });

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edttieude.getText().toString();
                String note = edtghichu.getText().toString();
                String dateTime = selectedDate[0] + " " + selectedTime[0];

                if (title.isEmpty() || selectedDate[0].isEmpty() || selectedTime[0].isEmpty()) {
                    Toast.makeText(Lab5.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    list.add(new Lich(title, dateTime, note));
                    lichAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}