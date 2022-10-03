package com.example.limappsept2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    public MyAdapter2(Context context, ArrayList<Sirovine> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<Sirovine> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return new MyViewHolder(v);
    }







    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sirovine user=list.get(position);
        holder.cenaPrim.setText(user.getCenaPrim());
        holder.datumPrim.setText(user.getDatumPrim());
        holder.kilaza1Prim.setText(user.getKilaza1Prim());
        holder.kilaza7Prim.setText(user.getKilaza7Prim());
        holder.kilaza8Prim.setText(user.getKilaza8Prim());
        holder.komadi1.setText(user.getKomadi1());
        holder.komadi7.setText(user.getKomadi7());
        holder.komadi8.setText(user.getKomadi8());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cenaPrim,datumPrim,kilaza1Prim,kilaza7Prim,kilaza8Prim,komadi1,komadi7,komadi8;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cenaPrim=itemView.findViewById(R.id.item2Cena);
            datumPrim=itemView.findViewById(R.id.item2Datum);
            kilaza1Prim=itemView.findViewById(R.id.item21);
            kilaza7Prim=itemView.findViewById(R.id.item27);
            kilaza8Prim=itemView.findViewById(R.id.item28);
            komadi1=itemView.findViewById(R.id.item2kom1);
            komadi8=itemView.findViewById(R.id.item2kom8);
            komadi7=itemView.findViewById(R.id.item2kom7);



        }
    }

}
