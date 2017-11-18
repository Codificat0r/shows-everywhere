package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Asistencia;
import com.example.showseverywhere.data.db.repository.AsistenciaRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class AmigosAsistenciasAdapter extends RecyclerView.Adapter<AmigosAsistenciasAdapter.AmigosAsistenciasViewHolder>{
    private ArrayList<Asistencia> asistencias;

    public AmigosAsistenciasAdapter() {
        this.asistencias = AsistenciaRepository.getInstance().getAsistencias();
    }

    @Override
    public AmigosAsistenciasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_asistencia_amigo, null);
        AmigosAsistenciasViewHolder amigosAsistenciasViewHolder = new AmigosAsistenciasViewHolder(view);
        return amigosAsistenciasViewHolder;
    }

    @Override
    public void onBindViewHolder(AmigosAsistenciasViewHolder holder, int position) {
        holder.icon.setLetter(asistencias.get(position).getUsuarioEstandar().getNick().substring(0,1));
        holder.txvNick.setText(asistencias.get(position).getUsuarioEstandar().getNick());
        holder.txvLocal.setText(asistencias.get(position).getActuacion().getLocal().getNombre());
        holder.txvDireccionLocal.setText(asistencias.get(position).getActuacion().getLocal().getDireccion());
        holder.txvArtista.setText(asistencias.get(position).getActuacion().getArtista().getNombre() + " " + asistencias.get(position).getActuacion().getArtista().getApellido());
        holder.txvTipoArtista.setText(asistencias.get(position).getActuacion().getArtista().getTipo());
    }

    @Override
    public int getItemCount() {
        return asistencias.size();
    }


    public static class AmigosAsistenciasViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNick;
        private TextView txvLocal;
        private TextView txvDireccionLocal;
        private TextView txvArtista;
        private TextView txvTipoArtista;

        public AmigosAsistenciasViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNick = (TextView) itemView.findViewById(R.id.txvNick);
            txvLocal = (TextView) itemView.findViewById(R.id.txvLocal);
            txvDireccionLocal = (TextView) itemView.findViewById(R.id.txvDireccionLocal);
            txvArtista = (TextView) itemView.findViewById(R.id.txvArtista);
            txvTipoArtista = (TextView) itemView.findViewById(R.id.txvTipoArtistaProvincia);
        }
    }
}
