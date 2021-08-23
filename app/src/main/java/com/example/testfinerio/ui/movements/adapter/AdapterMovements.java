package com.example.testfinerio.ui.movements.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testfinerio.R;
import com.example.testfinerio.model.Data;
import com.example.testfinerio.utils.Utils;

import java.text.ParseException;
import java.util.ArrayList;


public class AdapterMovements extends RecyclerView.Adapter<AdapterMovements.ViewHolder>{
    Context context;
    ArrayList<Data> listData;
    Utils utils;
    public AdapterMovements(ArrayList<Data> listData, Context context) {
        this.context = context;
        this.listData = listData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_movements, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        utils = new Utils();

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.setIsRecyclable(false);
        holder.tvConcepto.setText(""+ listData.get(position).getDescription());
        holder.tvMonto.setText("Monto - $ "+listData.get(position).getAmount());
        String f = null;
        try {
            f = utils.dateFormat(listData.get(position).getCustomDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.tvFecha.setText("Fecha: " +f);

        if(listData.get(position).getType().equalsIgnoreCase("DEPOSIT")){
            holder.linearItem.setBackgroundResource(R.drawable.background_border_item_verde);
        }
        else{
            holder.linearItem.setBackgroundResource(R.drawable.background_border_item_red);
        }
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvConcepto;
        public TextView tvFecha;
        public TextView tvMonto;
        public LinearLayout linearItem;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvConcepto = (TextView) itemView.findViewById(R.id.item_movements_tv_concepto);
            this.tvFecha = (TextView) itemView.findViewById(R.id.item_movements_tv_fecha);
            this.tvMonto = (TextView) itemView.findViewById(R.id.item_movements_tv_monto);
            this.linearItem = (LinearLayout) itemView.findViewById(R.id.item_movements_linear_main);
        }
    }
}