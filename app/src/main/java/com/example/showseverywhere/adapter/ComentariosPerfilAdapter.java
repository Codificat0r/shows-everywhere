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
import com.example.showseverywhere.data.db.model.Comentario;
import com.example.showseverywhere.data.db.repository.ComentarioRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 19/11/2017.
 */

public class ComentariosPerfilAdapter extends ArrayAdapter<Comentario> {

    public ComentariosPerfilAdapter(@NonNull Context context) {
        super(context, R.layout.item_comentario, ComentarioRepository.getInstance().getComentarios());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ComentarioHolder comentarioHolder;
        LayoutInflater inflater;
        View view = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            comentarioHolder = new ComentarioHolder();

            view = inflater.inflate(R.layout.item_comentario, null);

            comentarioHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            comentarioHolder.txvNombreUsuario = (TextView) view.findViewById(R.id.txvNombreUsuario);
            comentarioHolder.txvComentario = (TextView) view.findViewById(R.id.txvComentario);

            view.setTag(comentarioHolder);
        } else {
            comentarioHolder = (ComentarioHolder) view.getTag();
        }

        comentarioHolder.icon.setLetter(getItem(position).getUsuarioEstandar().getNick().substring(0,1));
        comentarioHolder.txvNombreUsuario.setText(getItem(position).getUsuarioEstandar().getNick());
        comentarioHolder.txvComentario.setText(getItem(position).getContenido());

        return view;
    }

    class ComentarioHolder {
        private MaterialLetterIcon icon;
        private TextView txvNombreUsuario;
        private TextView txvComentario;
    }
}
