package com.lab07.Lab07.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lab07.Lab07.R;
import com.lab07.Lab07.entidades.Actividad;

import java.util.ArrayList;

public class ListaActividadesAdapter extends RecyclerView.Adapter<ListaActividadesAdapter.ActividadViewHolder> {

    ArrayList<Actividad> lista;

    public ListaActividadesAdapter (ArrayList<Actividad> lista){
        this.lista=lista;
    }

    @NonNull
    @Override

    public ActividadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,null,false);
        return new ActividadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadViewHolder holder, int position) {
        holder.id.setText(String.valueOf(lista.get(position).getId()));
        holder.usuario.setText(lista.get(position).getUsuario());
        holder.fecha.setText(lista.get(position).getFecha());
        holder.latitud.setText(String.valueOf(lista.get(position).getLatitud()));
        holder.longitud.setText(String.valueOf(lista.get(position).getLongitud()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ActividadViewHolder extends RecyclerView.ViewHolder {

        TextView id,usuario,fecha,latitud,longitud;

        public ActividadViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            usuario=itemView.findViewById(R.id.usuario);
            fecha=itemView.findViewById(R.id.fecha);
            latitud=itemView.findViewById(R.id.latitud);
            longitud=itemView.findViewById(R.id.longitud);


        }
    }
}
