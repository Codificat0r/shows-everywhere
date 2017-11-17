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
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistaAdapter extends ArrayAdapter<Artista>{

    public ArtistaAdapter(@NonNull Context context) {
        super(context, R.layout.item_artista, new ArrayList<Artista>(ArtistaRepository.getInstance().getArtistas()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArtistaHolder artistaHolder;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            artistaHolder = new ArtistaHolder();

            view = inflater.inflate(R.layout.item_artista, null);

            artistaHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            artistaHolder.txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);
            artistaHolder.txvTipoArtista = (TextView) view.findViewById(R.id.txvTipoArtista);

            view.setTag(artistaHolder);
        } else {
            artistaHolder = (ArtistaHolder) view.getTag();
        }

        artistaHolder.icon.setLetter(getItem(position).getNombre().substring(0,1));
        artistaHolder.txvNombreApellido.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        artistaHolder.txvTipoArtista.setText(getItem(position).getTipo());

        return view;
    }

    class ArtistaHolder {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        TextView txvTipoArtista;
    }
}
