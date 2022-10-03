package com.example.limappsept2;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button provera;
    private EditText Sifra;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sifra =findViewById(R.id.passDash);
        provera=findViewById(R.id.loginDash);

Toast.makeText(MainActivity.this,"Firebase conected",Toast.LENGTH_SHORT).show();
        provera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Sifra.getText().toString());

            }
        });
    }


    private void validate(String nekasifra){
        if(nekasifra.equals("123") ){
            Intent i=new Intent(MainActivity.this, dash.class);
            startActivity(i);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Toast.makeText(MainActivity.this, "Dobrodosli!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Pokusajte ponovo", Toast.LENGTH_LONG).show();
        }

    }
}
