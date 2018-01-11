package com.example.showseverywhere.ui.login.presenter;

import com.example.showseverywhere.ui.login.contrato.RegistroContrato;
import com.example.showseverywhere.ui.login.interactor.RegistroInteractor;
import com.example.showseverywhere.ui.login.interactor.RegistroInteractorImpl;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class RegistroPresenter implements RegistroContrato.Presenter, RegistroInteractorImpl.OnPeticionFinalizada {
    private RegistroInteractor interactor;
    private RegistroContrato.Vista vista;

    public RegistroPresenter(RegistroContrato.Vista vista) {
        this.vista = vista;
        this.interactor = new RegistroInteractorImpl(this);
    }

    @Override
    public void pedirProvincias() {
        interactor.obtenerProvincias();
    }

    @Override
    public void pedirVerificarDatosRegistroUsuarioEstandar(String nombreUsuario, String contrasena, String email, String provincia) {
        interactor.verificarDatosRegistroUsuarioEstandar(nombreUsuario, contrasena, email, provincia);
    }

    @Override
    public void onExitoObtenerProvincias(ArrayList<String> provincias) {
        vista.onProvinciasObtenidas(provincias);
    }

    @Override
    public void campoObligatorioVacio() {
        vista.mostrarCampoObligatorioVacío();
    }

    @Override
    public void onExitoRegistro() {
        vista.onExitoRegistro();
    }

    @Override
    public void contrasenaMalFormada() {
        vista.mostrarContrasenaMalFormada();
    }

    @Override
    public void emailMalFormado() {
        vista.mostrarEmailMalFormado();
    }
}
