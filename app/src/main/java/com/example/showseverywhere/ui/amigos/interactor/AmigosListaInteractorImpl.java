package com.example.showseverywhere.ui.amigos.interactor;

import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaInteractorImpl implements AmigosListaInteractor {
    private OnExitoOperacionRequeridaListener listener;

    public interface OnExitoOperacionRequeridaListener {
        void onExito(List<UsuarioEstandar> amigos);
    }

    public AmigosListaInteractorImpl(OnExitoOperacionRequeridaListener listener) {
        this.listener = listener;
    }

    @Override
    public void obtenerListaAmigos() {
        listener.onExito(UsuarioEstandarRepository.getInstance().getUsuariosEstandar());
    }

    @Override
    public void marcarSeleccionado(int position) {
        UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(position).setSelected(true);
        listener.onExito(UsuarioEstandarRepository.getInstance().getUsuariosEstandar());
    }

    @Override
    public void desmarcarSeleccionado(int position) {
        UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(position).setSelected(false);
        listener.onExito(UsuarioEstandarRepository.getInstance().getUsuariosEstandar());
    }

    @Override
    public void desmarcarTodos() {
        ArrayList<UsuarioEstandar> usuarios = UsuarioEstandarRepository.getInstance().getUsuariosEstandar();

        for (UsuarioEstandar tmp : usuarios) {
            tmp.setSelected(false);
        }

        listener.onExito(usuarios);
    }

    @Override
    public void borrarAmigos() {
        ArrayList<UsuarioEstandar> usuarios = UsuarioEstandarRepository.getInstance().getUsuariosEstandar();

        Iterator<UsuarioEstandar> it = usuarios.iterator();

        while (it.hasNext()) {
            UsuarioEstandar tmp = it.next();

            if (tmp.getSelected())
                it.remove();
        }

        listener.onExito(usuarios);
    }

}
