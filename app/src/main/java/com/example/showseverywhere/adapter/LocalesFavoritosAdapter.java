package com.example.showseverywhere.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.data.db.repository.LocalRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class LocalesFavoritosAdapter extends RecyclerView.Adapter<LocalesFavoritosAdapter.LocalesFavoritosViewHolder> {
    private ArrayList<Local> locales;

    public LocalesFavoritosAdapter() {
        locales = LocalRepository.getInstance().getLocales();
    }

    @Override
    public LocalesFavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_local_favorito, null);
        LocalesFavoritosViewHolder localesFavoritosViewHolder = new LocalesFavoritosViewHolder(view);
        return localesFavoritosViewHolder;
    }

    @Override
    public void onBindViewHolder(LocalesFavoritosViewHolder holder, int position) {
        holder.icon.setLetter(locales.get(position).getNombre().substring(0,1));
        holder.txvNombreLocal.setText(locales.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return locales.size();
    }

    public static class LocalesFavoritosViewHolder extends RecyclerView.ViewHolder {
        private MaterialLetterIcon icon;
        private TextView txvNombreLocal;

        public LocalesFavoritosViewHolder(View itemView) {
            super(itemView);
            icon = (MaterialLetterIcon) itemView.findViewById(R.id.icon);
            txvNombreLocal = (TextView) itemView.findViewById(R.id.txvNombreLocal);
        }
    }
}
