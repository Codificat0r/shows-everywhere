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
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class LocalesFavoritosProximasActuacionesAdapter extends RecyclerView.Adapter<LocalesFavoritosProximasActuacionesAdapter.LocalesFavoritosProximasActuacionesViewHolder>{
    private ArrayList<Actuacion> actuaciones;

    public LocalesFavoritosProximasActuacionesAdapter() {
        actuaciones = ActuacionRepository.getInstance().getActuaciones();
    }

    @Override
    public LocalesFavoritosProximasActuacionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_local_favorito_actuaciones_proximas, null);
        LocalesFavoritosProximasActuacionesViewHolder localesFavoritosProximasActuacionesViewHolder = new LocalesFavoritosProximasActuacionesViewHolder(view);
        return localesFavoritosProximasActuacionesViewHolder;
    }

    @Override
    public void onBindViewHolder(LocalesFavoritosProximasActuacionesViewHolder holder, int position) {
        holder.icon.setLetter(actuaciones.get(position).getLocal().getNombre().substring(0,1));
        holder.txvNombreLocalFecha.setText(actuaciones.get(position).getLocal().getNombre() + ", " + actuaciones.get(position).getFecha().toString().substring(0,10));
    }

    @Override
    public int getItemCount() {
        return actuaciones.size();
    }

    public static class LocalesFavoritosProximasActuacionesViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNombreLocalFecha;

        public LocalesFavoritosProximasActuacionesViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNombreLocalFecha = (TextView) itemView.findViewById(R.id.txvNombreApellidoFecha);
        }
    }
}
