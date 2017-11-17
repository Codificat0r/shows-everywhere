package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Actuacion;
import com.example.showseverywhere.data.db.repository.ActuacionRepository;
import com.example.showseverywhere.data.db.repository.ArtistaRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class ArtistasFavoritosProximasActuacionesAdapter extends RecyclerView.Adapter<ArtistasFavoritosProximasActuacionesAdapter.ArtistasFavoritosProximasActuacionesViewHolder> {
    private ArrayList<Actuacion> actuaciones;

    public ArtistasFavoritosProximasActuacionesAdapter() {
        actuaciones = ActuacionRepository.getInstance().getActuaciones();
    }

    @Override
    public ArtistasFavoritosProximasActuacionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_artista_favorito_actuaciones_proximas, null);
        ArtistasFavoritosProximasActuacionesViewHolder artistasFavoritosProximasActuacionesViewHolder = new ArtistasFavoritosProximasActuacionesViewHolder(view);
        return artistasFavoritosProximasActuacionesViewHolder;
    }

    @Override
    public void onBindViewHolder(ArtistasFavoritosProximasActuacionesViewHolder holder, int position) {
        holder.icon.setLetter(actuaciones.get(position).getArtista().getNombre().substring(0,1));
        holder.txvNombreApellidoFecha.setText(actuaciones.get(position).getArtista().getNombre() + " " + actuaciones.get(position).getArtista().getApellido() + ", " + actuaciones.get(position).getFecha().toString().substring(0,10));
    }

    @Override
    public int getItemCount() {
        return actuaciones.size();
    }

    public static class ArtistasFavoritosProximasActuacionesViewHolder extends RecyclerView.ViewHolder{
        private MaterialLetterIcon icon;
        private TextView txvNombreApellidoFecha;


        public ArtistasFavoritosProximasActuacionesViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNombreApellidoFecha = (TextView) itemView.findViewById(R.id.txvNombreApellidoFecha);
        }
    }
}
