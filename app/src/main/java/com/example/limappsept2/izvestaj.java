package com.example.limappsept2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Objects;

public class izvestaj extends AppCompatActivity {



    private TextView total1;
    private TextView total8;
    private TextView total7;
    public  TextView totalUlozeno;
    public  TextView totalZaradjeno;

    private TextView totalProdato1;
    private TextView totalProdato8;
    private TextView totalProdato7;


    public  TextView saldo;
    public TextView raspolozivo1;
    public TextView raspolozivo7;
    public TextView raspolozivo8;


    private int sumUlozeno;
    private int sumZaradjeno;
    private int sumNapravljeno1;
    private int sumProdatih1;
    private int sumNapravljeno7;
    private int sumProdatih7;
    private int sumNapravljeno8;
    private int sumProdatih8;






    private Button ok_btn;

    private DatabaseReference lim;
    private DatabaseReference prodajaLima;


    private void calculateRaspolozivo8() {
        if (Objects.nonNull(sumNapravljeno8) && Objects.nonNull(sumProdatih8)) {
            raspolozivo8.setText(String.valueOf(sumNapravljeno8 - sumProdatih8));
        }
    }
    private void calculateRaspolozivo7() {
        if (Objects.nonNull(sumNapravljeno7) && Objects.nonNull(sumProdatih7)) {
            raspolozivo7.setText(String.valueOf(sumNapravljeno7 - sumProdatih7));
        }
    }
    private void calculateRaspolozivo() {
        if (Objects.nonNull(sumNapravljeno1) && Objects.nonNull(sumProdatih1)) {
            raspolozivo1.setText(String.valueOf(sumNapravljeno1 - sumProdatih1));
        }
    }

    private void calculateSaldo() {
        if (Objects.nonNull(sumUlozeno) && Objects.nonNull(sumZaradjeno)) {
            saldo.setText(String.valueOf(sumZaradjeno - sumUlozeno));
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izvestaj);
        lim= FirebaseDatabase.getInstance().getReference().child("Sirovine");
        prodajaLima= FirebaseDatabase.getInstance().getReference().child("ProdajaLima");

        total1=(TextView) findViewById(R.id.prikaz1);
        total8=(TextView) findViewById(R.id.prikaz8);
        total7=(TextView) findViewById(R.id.prikaz7);

        totalProdato1=(TextView)findViewById(R.id.prodati1);
        totalProdato7=(TextView)findViewById(R.id.prodati7);
        totalProdato8=(TextView)findViewById(R.id.prodati8);


        saldo=(TextView)findViewById(R.id.saldo);
        raspolozivo1=(TextView)findViewById(R.id.raspolozivo1);
        raspolozivo7=(TextView)findViewById(R.id.raspolozivo7);
        raspolozivo8=(TextView)findViewById(R.id.raspolozivo8);


        totalUlozeno=(TextView)findViewById(R.id.prikazUlozen);
        totalZaradjeno=(TextView)findViewById(R.id.prikazZarada);

        ok_btn=(Button)findViewById(R.id.ok);





        lim.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;

                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi1");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    Log.d("jedinica", String.valueOf(sum));
                    total1.setText(String.valueOf(sum));
                    sumNapravljeno1=sum;
                    calculateRaspolozivo();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(izvestaj.this, dash.class);
                startActivity(i);
            }
        });



        lim.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;

                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi7");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    Log.d("sedmica", String.valueOf(sum));
                    total7.setText(String.valueOf(sum));
                    sumNapravljeno7=sum;
                    calculateRaspolozivo7();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lim.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;

                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi8");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    Log.d("osmica", String.valueOf(sum));

                    total8.setText(String.valueOf(sum));
                    sumNapravljeno8=sum;
                    calculateRaspolozivo8();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        prodajaLima.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;

                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("cenaProdaja");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    Log.d("Zarada:", String.valueOf(sum));
                    totalZaradjeno.setText(String.valueOf(sum));
                    sumZaradjeno = sum;
                    calculateSaldo();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lim.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;

                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("cenaPrim");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    Log.d("Ulozeno:", String.valueOf(sum));
                    totalUlozeno.setText(String.valueOf(sum));
                    sumUlozeno=sum;
                    calculateSaldo();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        prodajaLima.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;
                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi1Prodaja");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    Log.d("Pre poziva:", String.valueOf(sum));
                    sum+=pValue;
                    totalProdato1.setText(String.valueOf(sum));
                    sumProdatih1=sum;
                    calculateRaspolozivo();
                }}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        prodajaLima.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;
                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi7Prodaja");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    totalProdato7.setText(String.valueOf(sum));
                    sumProdatih7=sum;
                    calculateRaspolozivo7();
                }}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        prodajaLima.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int sum=0;
                for(DataSnapshot ds:snapshot.getChildren()){
                    Map<String,Object> map=(Map<String, Object>) ds.getValue();
                    Object price=map.get("komadi8Prodaja");
                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    totalProdato8.setText(String.valueOf(sum));
                    sumProdatih8=sum;
                    calculateRaspolozivo8();
                }}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











    }



}