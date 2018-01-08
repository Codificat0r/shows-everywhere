package com.example.showseverywhere.ui.amigos.presenter;

import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.ui.amigos.contrato.AmigosListaContrato;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaInteractor;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaInteractorImpl;

import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaPresenter implements AmigosListaContrato.Presenter, AmigosListaInteractorImpl.OnExitoOperacionRequeridaListener{
    private AmigosListaInteractor interactor;
    private AmigosListaContrato.Vista vista;

    public AmigosListaPresenter(AmigosListaContrato.Vista vista) {
        this.vista = vista;
        interactor = new AmigosListaInteractorImpl(this);
    }

    @Override
    public void pedirListaAmigos() {
        interactor.obtenerListaAmigos();
    }

    @Override
    public void onExito(List<UsuarioEstandar> amigos) {
        vista.onExito(amigos);
    }
}
