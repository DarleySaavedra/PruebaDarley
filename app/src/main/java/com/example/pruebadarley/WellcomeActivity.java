package com.example.pruebadarley;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class WellcomeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String user="names";
    TextView txtUser;
    private Button br, bver;
    private  Button be;
    private  Button bb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("¡Bienvenido "+ user +"!");

        //Referenciamos los views
        br = (Button) findViewById(R.id.bregister);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Abrimos otra activity (registrar) desde el boton registrar
                Intent intento = new Intent(v.getContext(), RegisterActivity.class);
                startActivityForResult(intento, 0);
            }
        });

        bver = (Button) findViewById(R.id.bver);
        bver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Abrimos otra activity (Modificar) desde el boton modificar
                Intent intento1 = new Intent(v.getContext(), ListActivity.class);
                startActivityForResult(intento1, 0); }
        });




    }

    @Override
    public void onClick(View v) {

    }
}