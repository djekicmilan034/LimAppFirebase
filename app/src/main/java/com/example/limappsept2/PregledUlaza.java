package com.example.limappsept2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class PregledUlaza extends AppCompatActivity {

    RecyclerView recyclerView1;
    DatabaseReference database;
    MyAdapter2 myAdapter1;
    ArrayList<Sirovine> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregled_ulaza);

        recyclerView1=findViewById(R.id.listaUlazaSirovina);
        database= FirebaseDatabase.getInstance().getReference("Sirovine");
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        myAdapter1= new  MyAdapter2(this,list);
        recyclerView1.setAdapter(myAdapter1);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Sirovine user=dataSnapshot.getValue(Sirovine.class);
                    list.add(user);
                }
                myAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}