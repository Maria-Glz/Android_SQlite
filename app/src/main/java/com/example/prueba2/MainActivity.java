package com.example.prueba2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText idid, idtemperatura,idph,idoxigeno_disuelto,idturbidez,idconductividad;
    Button idguardar, idmostrar, idbuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idid=(EditText)findViewById(R.id.idid);
        idtemperatura=(EditText)findViewById(R.id.idtemperatura);
        idph=(EditText)findViewById(R.id.idph);
        idoxigeno_disuelto=(EditText)findViewById(R.id.idoxigeno_disuelto);
        idturbidez=(EditText)findViewById(R.id.idturbidez);
        idconductividad=(EditText)findViewById(R.id.idconductividad);

        //BOTONES
        idguardar=(Button)findViewById(R.id.idguardar);
        idmostrar=(Button)findViewById(R.id.idmostrar);
        idbuscar=(Button)findViewById(R.id.idbuscar);


        final basededatos basedatos=new basededatos(getApplicationContext());

        idguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basedatos.agregarRegistros(idid.getText().toString(),idtemperatura.getText().toString(),idph.getText().toString(),idoxigeno_disuelto.getText().toString(),idturbidez.getText().toString(),idconductividad.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego correctamente el registro",Toast.LENGTH_SHORT).show();
            }

        });

        idmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mostrarCu=new Intent(getApplicationContext(),CuActivity.class);
                startActivity(mostrarCu);
            }
        });

    }
}