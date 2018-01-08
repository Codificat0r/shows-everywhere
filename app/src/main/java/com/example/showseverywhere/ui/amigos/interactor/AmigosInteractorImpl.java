package com.example.showseverywhere.ui.amigos.interactor;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosInteractorImpl implements AmigosInteractor {

    private OnExitoOperacionRequeridaListener listener;

    public interface OnExitoOperacionRequeridaListener {

    }

    public AmigosInteractorImpl(OnExitoOperacionRequeridaListener listener) {
        this.listener = listener;
    }
}
