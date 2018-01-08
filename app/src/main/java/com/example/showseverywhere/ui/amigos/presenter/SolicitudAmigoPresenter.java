package com.example.showseverywhere.ui.amigos.presenter;

import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.ui.amigos.contrato.SolicitudAmigoContrato;
import com.example.showseverywhere.ui.amigos.interactor.SolicitudAmigoInteractor;
import com.example.showseverywhere.ui.amigos.interactor.SolicitudAmigoInteractorImpl;

/**
 * Created by carlos on 8/01/18.
 */

public class SolicitudAmigoPresenter implements SolicitudAmigoContrato.Presenter, SolicitudAmigoInteractorImpl.OnExitoOperacionRequeridaListener {
    private SolicitudAmigoInteractor interactor;
    private SolicitudAmigoContrato.Vista vista;

    public SolicitudAmigoPresenter(SolicitudAmigoContrato.Vista vista) {
        this.vista = vista;
        interactor = new SolicitudAmigoInteractorImpl(this);
    }

    @Override
    public void pedirAnadirAmigo(UsuarioEstandar amigo) {
        interactor.anadirAmigo(amigo);
    }

    @Override
    public void onExito() {
        vista.onExito();
    }
}
