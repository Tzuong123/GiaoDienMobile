package com.example.baitap.Lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitap.R;

public class CustomAdapterBai1 extends BaseAdapter {
    private Context context;
    private String[] items;
    private int[] images;
    private LayoutInflater inflater;

    public CustomAdapterBai1(Context context, String[] items, int[] images) {
        this.context = context;
        this.items = items;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_bai1, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        imageView.setImageResource(images[position]);
        textView.setText(items[position]);

        return convertView;
    }
}
