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
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by carlos on 16/11/2017.
 */

public class LocalAdapter extends ArrayAdapter<Local>{

    public LocalAdapter(@NonNull Context context) {
        super(context, R.layout.item_local, LocalRepository.getInstance().getLocales());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvNombreLocal;
        TextView txvDireccion;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_local, null);
        }

        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvNombreLocal = (TextView) view.findViewById(R.id.txvNombreLocal);
        txvDireccion = (TextView) view.findViewById(R.id.txvDireccion);

        icon.setLetter(getItem(position).getNombre().substring(0,1));
        txvNombreLocal.setText(getItem(position).getNombre());
        txvDireccion.setText(getItem(position).getDireccion());

        return view;
    }
}
