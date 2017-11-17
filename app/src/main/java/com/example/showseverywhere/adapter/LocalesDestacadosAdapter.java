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

import java.util.ArrayList;

/**
 * Created by carlos on 16/11/2017.
 */

public class LocalesDestacadosAdapter extends ArrayAdapter<Local> {
    public LocalesDestacadosAdapter(@NonNull Context context) {
        super(context, R.layout.item_local_destacado, new ArrayList<Local>(LocalRepository.getInstance().getLocales()));
        //Ordenamos por puntuacion descendente
        sort(new LocalPuntuacionComparerDescendente());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LocalDestacadoHolder localDestacadoHolder;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localDestacadoHolder = new LocalDestacadoHolder();

            view = inflater.inflate(R.layout.item_local_destacado, null);

            localDestacadoHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            localDestacadoHolder.txvNombreLocal = (TextView) view.findViewById(R.id.txvNombreLocal);
            localDestacadoHolder.txvPuntuacion = (TextView) view.findViewById(R.id.txvPuntuacion);

            view.setTag(localDestacadoHolder);
        } else {
            localDestacadoHolder = (LocalDestacadoHolder) view.getTag();
        }

        localDestacadoHolder.icon.setLetter(getItem(position).getNombre().substring(0,1));
        localDestacadoHolder.txvNombreLocal.setText(getItem(position).getNombre());
        localDestacadoHolder.txvPuntuacion.setText("Puntuación: " + Double.toString(getItem(position).getPuntuacion()));

        return view;
    }

    class LocalDestacadoHolder {
        MaterialLetterIcon icon;
        TextView txvNombreLocal;
        TextView txvPuntuacion;
    }
}
