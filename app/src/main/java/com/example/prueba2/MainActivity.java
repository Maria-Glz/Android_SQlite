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
    Button idguardar, idmostrar, idbuscar,ideditar,ideliminar;


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
        ideditar=(Button)findViewById(R.id.ideditar);
        ideliminar=(Button)findViewById(R.id.ideliminar);


        final basededatos basedatos=new basededatos(getApplicationContext());

        idguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basedatos.agregarRegistros(idid.getText().toString(),idtemperatura.getText().toString(),idph.getText().toString(),idoxigeno_disuelto.getText().toString(),idturbidez.getText().toString(),idconductividad.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agrego correctamente el registro",Toast.LENGTH_SHORT).show();
                limpiar();
            }

        });

        idmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mostrarCu=new Intent(getApplicationContext(),CuActivity.class);
                startActivity(mostrarCu);
            }
        });

        idbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcionamiento funci = new funcionamiento();
                basedatos.buscar(funci,idid.getText().toString());
                //idid.setText(funci.getId());
                idtemperatura.setText(funci.getTemperatura());
                idph.setText(funci.getPh());
                idturbidez.setText(funci.getTurbidez());
                idconductividad.setText(funci.getConductividad());
                idoxigeno_disuelto.setText(funci.getOxigeno_disuelto());

            }
        });
        //Confirma la edicion de los datos
        ideditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basedatos.editar(idid.getText().toString(),idtemperatura.getText().toString(),idph.getText().toString(),idoxigeno_disuelto.getText().toString(),idturbidez.getText().toString(),idconductividad.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS MODIFICADOS",Toast.LENGTH_SHORT).show();
                limpiar();
            }
        });

        //Confirma la eliminacion de los datos
        ideliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basedatos.eliminar(idid.getText().toString());
                Toast.makeText(getApplicationContext(),"DATOS ELIMINADOS",Toast.LENGTH_SHORT).show();
                limpiar();
            }
        });
    }
    //limpia los datos del formulario
    private void limpiar() {
        idid.setText("");
        idtemperatura.setText("");
        idph.setText("");
        idturbidez.setText("");
        idconductividad.setText("");
        idoxigeno_disuelto.setText("");
    }
}