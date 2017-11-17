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

import java.util.ArrayList;

/**
 * Created by carlos on 16/11/2017.
 */

public class LocalAdapter extends ArrayAdapter<Local>{

    public LocalAdapter(@NonNull Context context) {
        super(context, R.layout.item_local, new ArrayList<Local>(LocalRepository.getInstance().getLocales()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LocalHolder localHolder;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localHolder = new LocalHolder();

            view = inflater.inflate(R.layout.item_local, null);

            localHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            localHolder.txvNombreLocal = (TextView) view.findViewById(R.id.txvNombreLocal);
            localHolder.txvDireccion = (TextView) view.findViewById(R.id.txvDireccion);

            view.setTag(localHolder);
        } else {
            localHolder = (LocalHolder) view.getTag();
        }

        localHolder.icon.setLetter(getItem(position).getNombre().substring(0,1));
        localHolder.txvNombreLocal.setText(getItem(position).getNombre());
        localHolder.txvDireccion.setText(getItem(position).getDireccion());

        return view;
    }

    class LocalHolder {
        MaterialLetterIcon icon;
        TextView txvNombreLocal;
        TextView txvDireccion;
    }
}
