package com.example.prueba2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CuActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCant;
        private RecyclerViewAdaptador adaptadorCant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cur);

        recyclerViewCant=(RecyclerView)findViewById(R.id.RecyclerCa);
        recyclerViewCant.setLayoutManager(new LinearLayoutManager(this));

        basededatos Basededatos=new basededatos(getApplicationContext());

        adaptadorCant=new RecyclerViewAdaptador(Basededatos.mostrarCu ());  //CAMBIE ESTO, ERA Basededatos.mostrarCu ()
        recyclerViewCant.setAdapter(adaptadorCant);

    }
/*
    public List<funcionamiento>obtenerCa()
    {
        List<funcionamiento> id = new ArrayList <>();
        id.add(new funcionamiento("1","25","8","9","2","9"));
        id.add(new funcionamiento("2","45.66","4.65","4.9","2.6","9"));

        return id;
    }
*/

}