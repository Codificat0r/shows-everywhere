package com.example.showseverywhere.ui.amigos.interactor;

import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;

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
}
