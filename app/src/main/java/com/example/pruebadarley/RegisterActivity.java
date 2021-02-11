package com.example.pruebadarley;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {


    //defining view objects
    private EditText names;
    private EditText dni;
    private EditText hobbie;
    private Button btregis, btver, bdelete, beditar;
    private ListView lista;
    private LinearLayout listag, listabotones;
       DatabaseReference mRootReference, mSubirDatosFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        //Referenciamos los views
        names = (EditText) findViewById(R.id.tnombre);
        dni = (EditText) findViewById(R.id.tdni);
        hobbie = (EditText) findViewById(R.id.thobbie);
        btregis = (Button) findViewById(R.id.bregistros);
        btver = (Button) findViewById(R.id.bingresar);
        bdelete = (Button) findViewById(R.id.beliminar);
        beditar = (Button) findViewById(R.id.beditar);

        btver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento10 = new Intent(v.getContext(), ListActivity.class);
                startActivityForResult(intento10, 0); }
             });

        mRootReference = FirebaseDatabase.getInstance().getReference();

        btregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = names.getText().toString();
                int dnis = Integer.parseInt(dni.getText().toString());
                String hobbies= hobbie.getText().toString();

                cargarDatosFirebase(nombres, dnis, hobbies);

            }
        });

    }

    private void cargarDatosFirebase(String nombres, int dnis, String hobbies) {
        Map<String, Object> datosPaciente = new HashMap<>();
        datosPaciente.put("nombres", nombres);
        datosPaciente.put("dnis", dnis);
        datosPaciente.put("hobbies", hobbies);

        mRootReference.child("Paciente").push().setValue(datosPaciente);
        names.setText("");
        dni.setText("");
        hobbie.setText("");
        Toast.makeText(RegisterActivity.this, "Paciente Registrado", Toast.LENGTH_SHORT).show();
    }


}