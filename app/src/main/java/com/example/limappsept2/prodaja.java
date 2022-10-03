package com.example.limappsept2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class prodaja extends AppCompatActivity {
    EditText kupacPr;
    EditText datumPr;
    EditText jedPr;
    EditText osmPr;
    EditText sedPr;
    EditText cenaPr;
    Button sacuvajPr;
    Button viewBtn;
    DatabaseReference limProdaja;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodaja);

        kupacPr=(EditText)findViewById(R.id.kupacProdaja);
        datumPr=(EditText)findViewById(R.id.datumProdaja);
        jedPr=(EditText)findViewById(R.id.jedinicaProdaja);
        osmPr=(EditText)findViewById(R.id.osmicaProdaja);
        sedPr=(EditText)findViewById(R.id.sedmicaProdaja);
        cenaPr=(EditText)findViewById(R.id.cenaProdaja);

        sacuvajPr=(Button)findViewById(R.id.btnProdaja);
        viewBtn=(Button)findViewById(R.id.pregledProdaje);

        limProdaja= FirebaseDatabase.getInstance().getReference().child("ProdajaLima");

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(prodaja.this, Evidencija.class);
                startActivity(i);
            }
        });

        sacuvajPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataProdaja();
                Intent i=new Intent(prodaja.this, dash.class);
                startActivity(i);
            }
        });

    }
    private void insertDataProdaja(){
        String kupac_prim=kupacPr.getText().toString();
        String datumPrim=datumPr.getText().toString();
        String jedPrim=jedPr.getText().toString();
        String osmPrim=osmPr.getText().toString();
        String sedPrim=sedPr.getText().toString();
        String cenaPrim=cenaPr.getText().toString();


        Sirovine_prodaja prodaja_s=new Sirovine_prodaja(cenaPrim,datumPrim,jedPrim,sedPrim,osmPrim,kupac_prim);
        limProdaja.push().setValue(prodaja_s);
        Toast.makeText(prodaja.this, "Podaci o prodaji su sacuvani!",Toast.LENGTH_SHORT).show();
    };


}