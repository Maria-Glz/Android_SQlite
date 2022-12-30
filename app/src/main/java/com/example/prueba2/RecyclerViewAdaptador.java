package com.example.prueba2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView temperatura,ph,oxigeno_disuelto,turbidez,conductividad;
        ImageView icono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            temperatura=(TextView)itemView.findViewById(R.id.textView2);
            ph = (TextView)itemView.findViewById(R.id.textView3);
            oxigeno_disuelto = (TextView)itemView.findViewById(R.id.textView4);
            turbidez = (TextView)itemView.findViewById(R.id.textView6);
            conductividad = (TextView)itemView.findViewById(R.id.textView7);

        }
    }
    public List<funcionamiento> funcionamientoList;
    public RecyclerViewAdaptador(List<funcionamiento> funcionamientoList) {
            this.funcionamientoList = funcionamientoList;
    }
    //Hacer uso de un layout dentro de otro.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }
    //realiza modificaciones del contenido para cada item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.temperatura.setText(funcionamientoList.get(position).getTemperatura());
        holder.ph.setText( funcionamientoList.get(position).getPh());
        holder.oxigeno_disuelto.setText(funcionamientoList.get(position).getOxigeno_disuelto());
        holder.turbidez.setText( funcionamientoList.get(position).getTurbidez());
        holder.conductividad.setText(funcionamientoList.get(position).getConductividad());

    }

    //permite determinar al adaptador la cantidad de elementos a procesar
    @Override
    public int getItemCount() {
        return funcionamientoList.size();
    }
}
