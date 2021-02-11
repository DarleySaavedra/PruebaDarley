package com.example.pruebadarley;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Paciente> destino;
    FirebaseRecyclerAdapter<Paciente, myadapter.myviewholder> adapter;
    DatabaseReference databaseReference;


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
    private abstract class FirebaseRecyclerAdapter<P, M extends RecyclerView.ViewHolder> {
        public FirebaseRecyclerAdapter(Class<P> pacienteClass, int activity_list, Class<M> myviewholderClass, DatabaseReference login) {
        }

        protected abstract void populateViewHolder(myadapter.myviewholder myviewholder, Paciente Paciente, int i);
    }

}

