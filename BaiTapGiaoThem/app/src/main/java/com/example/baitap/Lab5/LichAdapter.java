package com.example.baitap.Lab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap.R;

import java.util.ArrayList;

public class LichAdapter extends RecyclerView.Adapter<LichAdapter.ViewHolder> {
    private ArrayList<Lich> list;

    public LichAdapter(ArrayList<Lich> list) {
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
        Lich lich = list.get(position);
        holder.bind(lich);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttieude, txtngay, txtghichu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttieude = itemView.findViewById(R.id.txttieude);
            txtngay = itemView.findViewById(R.id.txtngay);
            txtghichu = itemView.findViewById(R.id.txtghichu);
        }

        public void bind(Lich lich) {
            txttieude.setText(lich.getTieude());
            txtngay.setText(lich.getNgay());
            txtghichu.setText(lich.getGhichu());
        }
    }
}