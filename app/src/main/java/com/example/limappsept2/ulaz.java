package com.example.limappsept2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ulaz extends AppCompatActivity {

EditText datum;
EditText kilaza1;
EditText kilaza8;
EditText kilaza7;
EditText cena;
Button sacuvaj;
Button izracunaj;
Button pregled;
TextView Tekst1, Tekst8, Tekst7;

DatabaseReference lim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulaz);

        datum=findViewById(R.id.datumUlaz);
        kilaza1=findViewById(R.id.jedinicaUlaz);
        kilaza8=findViewById(R.id.osmicaUlaz);
        kilaza7=findViewById(R.id.sedmicaUlaz);
        cena=findViewById(R.id.cenaUlaz);
        sacuvaj=findViewById(R.id.btnUlaz);
        izracunaj=findViewById(R.id.proracunKomada);
        pregled=findViewById(R.id.btnPregledUlaza);

        Tekst1=findViewById(R.id.Tekst1);
        Tekst8=findViewById(R.id.Tekst8);
        Tekst7=findViewById(R.id.Tekst7);

    lim= FirebaseDatabase.getInstance().getReference().child("Sirovine");


    sacuvaj.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            insertData();
            Intent i=new Intent(ulaz.this, dash.class);
            startActivity(i);
        }
    });


    pregled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ulaz.this, PregledUlaza.class);
                startActivity(i);
            }
        });

    izracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proracun();
            }
        });




    }


    private void insertData(){

        String datumPrim=datum.getText().toString();
        String kilaza1Prim=kilaza1.getText().toString();
        String kilaza8Prim=kilaza8.getText().toString();
        String kilaza7Prim=kilaza7.getText().toString();
        String cenaPrim=cena.getText().toString();
        String jedinica= String.valueOf(Math.round(Integer.parseInt(kilaza1.getText().toString())/1.45));
        String osmica=String.valueOf(Math.round(Integer.parseInt(kilaza8.getText().toString())/1.25));
        String sedmica=String.valueOf(Math.round(Integer.parseInt(kilaza8.getText().toString())/0.83));

        Sirovine sirovine=new Sirovine(datumPrim,kilaza1Prim,kilaza8Prim,kilaza7Prim,cenaPrim,jedinica,osmica,sedmica);
        lim.push().setValue(sirovine);
        Toast.makeText(ulaz.this, "Podaci su sacuvani!",Toast.LENGTH_SHORT).show();
    }

    private void proracun(){

        String jedinica= String.valueOf(Math.round(Integer.parseInt(kilaza1.getText().toString())/1.45));
        String osmica=String.valueOf(Math.round(Integer.parseInt(kilaza8.getText().toString())/1.25));
        String sedmica=String.valueOf(Math.round(Integer.parseInt(kilaza8.getText().toString())/0.83));

        Tekst1.setText("Broj komada 1:  "+jedinica);
        Tekst8.setText("Broj komada 8:  "+osmica);
        Tekst7.setText("Broj komada 7:  "+sedmica);

    }




}