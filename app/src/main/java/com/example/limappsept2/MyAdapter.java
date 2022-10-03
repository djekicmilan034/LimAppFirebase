package com.example.limappsept2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public MyAdapter(Context context, ArrayList<Sirovine_prodaja> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<Sirovine_prodaja> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Sirovine_prodaja user=list.get(position);
        holder.cenaProdaja.setText(user.getCenaProdaja());
        holder.datumProdaja.setText(user.getDatumProdaja());
        holder.komadi1Prodaja.setText(user.getKomadi1Prodaja());
        holder.komadi7Prodaja.setText(user.getKomadi7Prodaja());
        holder.komadi8prodaja.setText(user.getKomadi8Prodaja());
        holder.kupacProdaja.setText(user.getKupacProdaja());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cenaProdaja,datumProdaja,komadi1Prodaja,komadi7Prodaja,komadi8prodaja,kupacProdaja;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cenaProdaja=itemView.findViewById(R.id.kartaCena);
            datumProdaja=itemView.findViewById(R.id.kartaDatum);
            komadi1Prodaja=itemView.findViewById(R.id.karta1);
            komadi7Prodaja=itemView.findViewById(R.id.karta7);
            komadi8prodaja=itemView.findViewById(R.id.karta8);
            kupacProdaja=itemView.findViewById(R.id.kartaKupac);

        }
    }

}
