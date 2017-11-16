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
import com.example.showseverywhere.ui.utils.comparers.ArtistaCalificacionComparerDescendente;
import com.example.showseverywhere.ui.utils.comparers.ArtistaNombreComparerAscendente;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistaAdapter extends ArrayAdapter<Artista>{

    public ArtistaAdapter(@NonNull Context context) {
        super(context, R.layout.item_artista, ArtistaRepository.getInstance().getArtistas());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        TextView txvTipoArtista;
        LayoutInflater inflater;

        View view = convertView;

        //Ordenamos por calificacion
        sort(new ArtistaNombreComparerAscendente());

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_artista, null);
        }

        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);
        txvTipoArtista = (TextView) view.findViewById(R.id.txvTipoArtista);

        icon.setLetter(getItem(position).getNombre().substring(0,1));
        txvNombreApellido.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        txvTipoArtista.setText(getItem(position).getTipo());

        return view;
    }
}
