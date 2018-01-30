package com.example.showseverywhere.ui.destacados.presenter;

import com.example.showseverywhere.ui.destacados.contrato.AnadirDestacadoContrato;
import com.example.showseverywhere.ui.destacados.interactor.AnadirDestacadoInteractorImpl;
import com.example.showseverywhere.ui.destacados.interactor.AnadirDestacadoInteractor;

/**
 * Created by carlos on 11/01/18.
 */

public class AnadirDestacadoPresenter implements AnadirDestacadoContrato.Presenter, AnadirDestacadoInteractorImpl.OnPeticionFinalizada {
    private AnadirDestacadoInteractor interactor;
    private AnadirDestacadoContrato.Vista vista;

    public AnadirDestacadoPresenter(AnadirDestacadoContrato.Vista vista) {
        this.vista = vista;
        this.interactor = new AnadirDestacadoInteractorImpl(this);
    }

    @Override
    public void pedirAnadirLocalDestacado(String nombreLocal, String puntuacion) {
        interactor.anadirLocalDestacado(nombreLocal, puntuacion);
    }

    @Override
    public void nombreLocalVacio() {
        vista.mostrarNombreVacio();
    }

    @Override
    public void puntuacionLocalVacia() {
        vista.mostrarPuntuacionVacia();
    }

    @Override
    public void localAnadido() {
        vista.onLocalAnadido();
    }
}
