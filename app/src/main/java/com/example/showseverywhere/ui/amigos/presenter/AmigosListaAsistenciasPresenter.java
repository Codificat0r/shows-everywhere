package com.example.showseverywhere.ui.amigos.presenter;

import com.example.showseverywhere.ui.amigos.contrato.AmigosListaAsistenciasContrato;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaAsistenciasInteractor;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaAsistenciasInteractorImpl;
import com.example.showseverywhere.ui.amigos.vista.AmigosListaAsistencias;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaAsistenciasPresenter implements AmigosListaAsistenciasContrato.Presenter, AmigosListaAsistenciasInteractorImpl.OnExitoOperacionRequeridaListener {
    private AmigosListaAsistenciasInteractor interactor;
    private AmigosListaAsistenciasContrato.Vista vista;

    public AmigosListaAsistenciasPresenter(AmigosListaAsistenciasContrato.Vista vista) {
        this.vista = vista;
        interactor = new AmigosListaAsistenciasInteractorImpl(this);
    }
}
