package com.example.showseverywhere.ui.amigos.interactor;

import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;

/**
 * Created by carlos on 8/01/18.
 */

public class SolicitudAmigoInteractorImpl implements SolicitudAmigoInteractor {
    private OnExitoOperacionRequeridaListener listener;

    public interface OnExitoOperacionRequeridaListener {
        void onExito();
    }

    public SolicitudAmigoInteractorImpl(OnExitoOperacionRequeridaListener listener) {
        this.listener = listener;
    }

    @Override
    public void anadirAmigo(UsuarioEstandar amigo) {
        UsuarioEstandarRepository.getInstance().addUsuario(amigo);
        listener.onExito();
    }
}
