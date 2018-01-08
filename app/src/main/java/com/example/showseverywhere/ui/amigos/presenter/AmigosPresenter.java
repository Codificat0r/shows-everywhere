package com.example.showseverywhere.ui.amigos.presenter;

import com.example.showseverywhere.ui.amigos.contrato.AmigosContrato;
import com.example.showseverywhere.ui.amigos.interactor.AmigosInteractor;
import com.example.showseverywhere.ui.amigos.interactor.AmigosInteractorImpl;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosPresenter implements AmigosContrato.Presenter, AmigosInteractorImpl.OnExitoOperacionRequeridaListener {
    private AmigosInteractor interactor;
    private AmigosContrato.Vista vista;

    public AmigosPresenter(AmigosContrato.Vista vista) {
        this.vista = vista;
        interactor = new AmigosInteractorImpl(this);
    }
}
