package com.example.baitap.Lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitap.R;

import java.util.ArrayList;

public class CustomAdapterBai1 extends BaseAdapter {
    private final Context context;
    private final ArrayList<App> list;

    public CustomAdapterBai1(Context context, ArrayList<App> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_bai1, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        App listApp = list.get(position);
        imageView.setImageResource(listApp.getHinh());
        textView.setText(listApp.getTen());

        return convertView;
    }

    public static class App {
        private final int hinh;
        private final String ten;

        public App(int hinh, String ten) {
            this.hinh = hinh;
            this.ten = ten;
        }

        public int getHinh() {
            return hinh;
        }

        public String getTen() {
            return ten;
        }
    }
}
