package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder>{
    private ArrayList<UsuarioEstandar> usuarios;

    public AmigosAdapter() {
        usuarios = UsuarioEstandarRepository.getInstance().getUsuariosEstandar();
    }

    @Override
    public AmigosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_amigo, null);
        AmigosViewHolder amigosViewHolder = new AmigosViewHolder(view);
        return amigosViewHolder;
    }

    @Override
    public void onBindViewHolder(AmigosViewHolder holder, int position) {
        holder.icon.setLetter(usuarios.get(position).getNick().substring(0,1));
        holder.txvNick.setText(usuarios.get(position).getNick());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class AmigosViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNick;

        public AmigosViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNick = (TextView) itemView.findViewById(R.id.txvNick);
        }
    }

}
