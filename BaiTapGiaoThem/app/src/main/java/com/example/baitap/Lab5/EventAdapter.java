package com.example.baitap.Lab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<Event> list;

    public EventAdapter(ArrayList<Event> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_su_kien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = list.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttieudesukien, txtngaysukien, txtghichusukien;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttieudesukien = itemView.findViewById(R.id.txttieudesukien);
            txtngaysukien = itemView.findViewById(R.id.txtngaysukien);
            txtghichusukien = itemView.findViewById(R.id.txtghichusukien);
        }

        public void bind(Event event) {
            txttieudesukien.setText(event.getTieude());
            txtngaysukien.setText(event.getNgay());
            txtghichusukien.setText(event.getGhichu());
        }
    }
}