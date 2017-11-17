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

import java.util.ArrayList;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistasDestacadosAdapter extends ArrayAdapter<Artista>{


    public ArtistasDestacadosAdapter(@NonNull Context context) {
        super(context, R.layout.item_artista_destacado, new ArrayList<Artista>(ArtistaRepository.getInstance().getArtistas()));
        //Ordenamos por puntuación de manera descendente.
        sort(new ArtistaPuntuacionComparerDescendente());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArtistaDestacadoHolder artistaDestacadoHolder;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            artistaDestacadoHolder = new ArtistaDestacadoHolder();

            view = inflater.inflate(R.layout.item_artista_destacado, null);

            artistaDestacadoHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            artistaDestacadoHolder.txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);
            artistaDestacadoHolder.txvPuntuacion = (TextView) view.findViewById(R.id.txvPuntuacion);

            view.setTag(artistaDestacadoHolder);
        } else {
            artistaDestacadoHolder = (ArtistaDestacadoHolder) view.getTag();
        }

        artistaDestacadoHolder.icon.setLetter(getItem(position).getNombre().substring(0,1));
        artistaDestacadoHolder.txvNombreApellido.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        artistaDestacadoHolder.txvPuntuacion.setText("Puntuación: " + Double.toString(getItem(position).getPuntuacion()));

        return view;
    }

    class ArtistaDestacadoHolder {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        TextView txvPuntuacion;
    }
}
