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
import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.data.db.repository.LocalRepository;
import com.example.showseverywhere.ui.utils.comparers.LocalPuntuacionComparerDescendente;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by carlos on 16/11/2017.
 */

public class LocalesDestacadosAdapter extends ArrayAdapter<Local> {
    public LocalesDestacadosAdapter(@NonNull Context context) {
        super(context, R.layout.item_local_destacado, LocalRepository.getInstance().getLocales());
        //Ordenamos por puntuacion descendente
        sort(new LocalPuntuacionComparerDescendente());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvNombreLocal;
        TextView txvPuntuacion;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_local_destacado, null);
        }

        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvNombreLocal = (TextView) view.findViewById(R.id.txvNombreLocal);
        txvPuntuacion = (TextView) view.findViewById(R.id.txvPuntuacion);

        icon.setLetter(getItem(position).getNombre().substring(0,1));
        txvNombreLocal.setText(getItem(position).getNombre());
        txvPuntuacion.setText(Double.toString(getItem(position).getPuntuacion()));

        return view;
    }
}
