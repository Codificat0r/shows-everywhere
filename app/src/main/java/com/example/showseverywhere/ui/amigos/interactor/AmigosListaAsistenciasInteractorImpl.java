package com.example.showseverywhere.ui.amigos.interactor;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaAsistenciasInteractorImpl implements AmigosListaAsistenciasInteractor {
    private OnExitoOperacionRequeridaListener listener;

    public interface OnExitoOperacionRequeridaListener {

    }

    public AmigosListaAsistenciasInteractorImpl(OnExitoOperacionRequeridaListener listener) {
        this.listener = listener;
    }
}
