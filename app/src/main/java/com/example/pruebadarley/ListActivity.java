package com.example.pruebadarley;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebadarley.Retrofit.Model.Posts;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;

public class ListActivity extends AppCompatActivity {
    RecyclerView recview;
    myadapter adapter;
    /*
    RecyclerView rv;
    List<Paciente> destino;
    FirebaseRecyclerAdapter<Paciente, myadapter.myviewholder> adapter;
    DatabaseReference databaseReference;

*/
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rv = (RecyclerView) findViewById(R.id.listausuarios);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(linearLayoutManager);

        adapter = new FirebaseRecyclerAdapter<Paciente, myadapter.myviewholder>(
                Paciente.class,
                R.layout.activity_list,
                myadapter.myviewholder.class,
                databaseReference.child("login")
        ){
            @Override
            protected void populateViewHolder(myadapter.myviewholder myviewholder, Paciente Paciente, int i){
                myviewholder.nombretext.setText(String.valueOf(Paciente.getNombre()));
                myviewholder.edtext.setText(String.valueOf(Paciente.getDni()));
                myviewholder.htext.setText(String.valueOf(Paciente.getHobbie()));

            }
        };


    }
*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recview=(RecyclerView)findViewById(R.id.listausuarios);
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Paciente> options =
                new FirebaseRecyclerOptions.Builder<Paciente>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Paciente"), Paciente.class)
                        .build();

        adapter=new myadapter(options);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}

