package com.example.showseverywhere.ui.destacados.presenter;

import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.ui.destacados.contrato.DestacadosContrato;
import com.example.showseverywhere.ui.destacados.interactor.DestacadosInteractor;
import com.example.showseverywhere.ui.destacados.interactor.DestacadosInteractorImpl;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class DestacadosPresenter implements DestacadosContrato.Presenter, DestacadosInteractorImpl.OnPeticionFinalizada {
    private DestacadosInteractor interactor;
    private DestacadosContrato.Vista vista;

    public DestacadosPresenter(DestacadosContrato.Vista vista) {
        this.vista = vista;
        this.interactor = new DestacadosInteractorImpl(this);
    }

    @Override
    public void pedirLocalesDestacados() {
        interactor.obtenerLocalesDestacados();
    }

    @Override
    public void pedirBorrarLocal(Local local) {
        interactor.borrarLocal(local);
    }

    @Override
    public void onExitoLocalesObtenidos(ArrayList<Local> locales) {
        vista.onLocalesObtenidos(locales);
    }
}
