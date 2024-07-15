package com.example.baitap.Lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitap.R;

import java.util.ArrayList;

public class CustomAdapterLab4 extends BaseAdapter {
    private final Context context;
    private final ArrayList<CustomAdapterLab4.Item> list;

    public CustomAdapterLab4(Context context, ArrayList<CustomAdapterLab4.Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_lab4, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.Iview);
        TextView textView1 = convertView.findViewById(R.id.Tview1);
        TextView textView2 = convertView.findViewById(R.id.Tview2);

        CustomAdapterLab4.Item list1 = list.get(position);

        imageView.setImageResource(list1.getHinh());
        textView1.setText(list1.getTen());
        textView2.setText(list1.getGia());

        return convertView;
    }
    public Context getContext() {
        return context;
    }
    public static class Item {
        private String ten;
        private String gia;
        private int hinh;

        public Item(String ten, String gia, int hinh) {
            this.ten = ten;
            this.gia = gia;
            this.hinh = hinh;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getGia() {
            return gia;
        }

        public void setGia(String gia) {
            this.gia = gia;
        }

        public int getHinh() {
            return hinh;
        }

        public void setHinh(int hinh) {
            this.hinh = hinh;
        }
    }
}
