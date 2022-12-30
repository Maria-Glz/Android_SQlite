package com.example.prueba2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class basededatos extends SQLiteOpenHelper {

    private static final String registrodatos="REGISTROBD.db";
    private static final int version=1;
    private static final String TABLA_REGISTROBD="CREATE TABLE REGISTROS(id TEXT, temperatura TEXT, ph TEXT, conductividad TEXT, turbidez TEXT, oxigeno_disuelto TEXT)";

    public basededatos(Context context) {
        super(context, registrodatos, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_REGISTROBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE"+TABLA_REGISTROBD);
        sqLiteDatabase.execSQL(TABLA_REGISTROBD);
    }
    public void agregarRegistros(String id, String temperatura, String ph, String oxigeno_disuelto, String turbidez, String conductividad){
        SQLiteDatabase db=getWritableDatabase();
        if (db!=null){
            db.execSQL("INSERT INTO REGISTROS VALUES('"+id+"', '"+temperatura+"','"+ph+"','"+oxigeno_disuelto+"','"+turbidez+"','"+conductividad+"') ");
            db.close();
        }

    }

        public List<funcionamiento>mostrarCu()
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM REGISTROS", null);
        funcionamiento funcio = null;
        List<funcionamiento> Registros =new ArrayList<>();

        if (cursor.moveToFirst())
        {
            do{
                funcio = new funcionamiento();
                funcio.setId(cursor.getString(0));
                funcio.setTemperatura(cursor.getString(1));
                funcio.setPh(cursor.getString(2));
                funcio.setTurbidez(cursor.getString(3));
                funcio.setConductividad(cursor.getString(4));
                funcio.setOxigeno_disuelto(cursor.getString(5));
                Registros.add(funcio);

               // Registros.add(new funcionamiento(cursor.getString(0), cursor.getString(1),cursor.getString(2),
                  //      cursor.getString(3),cursor.getString(4)));
             }
            while (cursor.moveToNext());
        }
        //cursor.close();
        return Registros;
    }

   /* public void buscar(Modelo, cursos, String NO_REGISTRO){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM REGISTROS WHERE NO_REGISTRO='"+NO_REGISTRO+"' ", null);
        List<Cursos> cursos =new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do{
                cursos.add(new Cursos )
            }
            while (cursor.moveToNext());
        }
        return cursos;
    }
*/
}
