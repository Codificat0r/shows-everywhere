package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Artista;
import com.example.showseverywhere.data.db.repository.ArtistaRepository;
import com.example.showseverywhere.ui.utils.comparers.ArtistaPuntuacionComparerDescendente;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistasDestacadosAdapter extends ArrayAdapter<Artista>{


    public ArtistasDestacadosAdapter(@NonNull Context context) {
        super(context, R.layout.item_artista_destacado, ArtistaRepository.getInstance().getArtistas());
        //Ordenamos por puntuación de manera descendente.
        sort(new ArtistaPuntuacionComparerDescendente());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        TextView txvPuntuacion;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_artista_destacado, null);
        }

        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);
        txvPuntuacion = (TextView) view.findViewById(R.id.txvPuntuacion);

        icon.setLetter(getItem(position).getNombre().substring(0,1));
        txvNombreApellido.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        txvPuntuacion.setText(Double.toString(getItem(position).getPuntuacion()));

        return view;
    }
}
