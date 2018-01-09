package com.example.showseverywhere.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
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
import java.util.Dictionary;
import java.util.List;

/**
 * Created by carlos on 17/11/2017.
 */

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder>{
    private ArrayList<UsuarioEstandar> usuarios;
    private OnItemClicked callback;;

    public interface OnItemClicked {
        void onItemClicked(int position);
        void onItemLongClicked(int position);
    }

    public AmigosAdapter(OnItemClicked onItemClicked) {
        usuarios = new ArrayList<>();
        callback = onItemClicked;
    }

    @Override
    public AmigosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_amigo, null);
        AmigosViewHolder amigosViewHolder = new AmigosViewHolder(view);
        return amigosViewHolder;
    }

    @Override
    public void onBindViewHolder(AmigosViewHolder holder, final int position) {
        holder.icon.setLetter(usuarios.get(position).getNick().substring(0,1));
        holder.txvNick.setText(usuarios.get(position).getNick());
        //Informamos al fragment de los click cortos y largos por si se quiere
        //realizar alguna accion desde el fragment.
        holder.vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemClicked(position);
            }
        });
        holder.vista.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                callback.onItemLongClicked(position);
                return true;
            }
        });

        holder.isSelected = usuarios.get(position).getSelected();
        if (holder.isSelected) {
            holder.vista.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class AmigosViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNick;
        private View vista;
        private Boolean isSelected = false;

        public AmigosViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNick = (TextView) itemView.findViewById(R.id.txvNick);
            vista = itemView;
        }
    }

    public void cargarDatos(List<UsuarioEstandar> amigos) {
        usuarios.addAll(amigos);
    }

    public void limpiarLista() {
        usuarios.clear();
    }

}
