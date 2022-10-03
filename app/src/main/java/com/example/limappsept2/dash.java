package com.example.limappsept2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class dash extends AppCompatActivity {
    private Button ulaz;
    private Button prodaja;
    private Button prerada;
    private Button izvestaj;

    public dash() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);


        ulaz = (Button) findViewById(R.id.ulazPocetna);
        ulaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dash.this, ulaz.class);
                startActivity(intent);
            }
        });


        prodaja = (Button) findViewById(R.id.prodajaPocetna);
        prodaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dash.this, prodaja.class);
                startActivity(intent);
            }
        });




        izvestaj = (Button) findViewById(R.id.izvestajPocetna);
        izvestaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dash.this, izvestaj.class);
                startActivity(intent);
            }
        });










    }
}