package com.example.baitap.Lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitap.R;

public class CustomAdapterBai2 extends BaseAdapter {
    private Context context;
    private String[] items1;
    private String[] items2;
    private int[] images;
    private LayoutInflater inflater;

    public CustomAdapterBai2(Context context, String[] items1, String[] items2, int[] images) {
        this.context = context;
        this.items1 = items1;
        this.items2 = items2;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items1.length;
    }

    @Override
    public Object getItem(int position) {
        return items1[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_bai2, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        imageView.setImageResource(images[position]);
        textView1.setText(items1[position]);
        textView2.setText(items2[position]);

        return convertView;
    }
}
