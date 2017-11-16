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
import com.example.showseverywhere.data.db.model.Propietario;
import com.example.showseverywhere.data.db.repository.PropietarioRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by carlos on 16/11/2017.
 */

public class PropietarioAdapter extends ArrayAdapter<Propietario>{

    public PropietarioAdapter(@NonNull Context context) {
        super(context, R.layout.item_propietario, PropietarioRepository.getInstance().getPropietarios());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvNombreApellido;
        LayoutInflater inflater;

        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_propietario, null);
        }

        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvNombreApellido = (TextView) view.findViewById(R.id.txvNombreApellido);

        icon.setLetter(getItem(position).getNombre().substring(0,1));
        txvNombreApellido.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());

        return view;
    }
}
