package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Artista;
import com.example.showseverywhere.data.db.repository.ArtistaRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class ArtistasFavoritosAdapter extends RecyclerView.Adapter<ArtistasFavoritosAdapter.ArtistasFavoritosViewHolder>{
    private ArrayList<Artista> artistas;

    public ArtistasFavoritosAdapter() {
        artistas = ArtistaRepository.getInstance().getArtistas();
    }

    @Override
    public ArtistasFavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_artista_favorito, null);
        ArtistasFavoritosViewHolder artistasFavoritosViewHolder = new ArtistasFavoritosViewHolder(view);
        return artistasFavoritosViewHolder;
    }

    @Override
    public void onBindViewHolder(ArtistasFavoritosViewHolder holder, int position) {
        holder.icon.setLetter(artistas.get(position).getNombre().substring(0,1));
        holder.txvNombreApellido.setText(artistas.get(position).getNombre() + " " + artistas.get(position).getApellido());
    }

    @Override
    public int getItemCount() {
        return artistas.size();
    }

    public static class ArtistasFavoritosViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNombreApellido;

        public ArtistasFavoritosViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNombreApellido = (TextView) itemView.findViewById(R.id.txvNombreApellido);
        }
    }
}
