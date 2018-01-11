package com.example.showseverywhere.ui.login.presenter;

import com.example.showseverywhere.ui.login.contrato.LoginContrato;
import com.example.showseverywhere.ui.login.interactor.LoginInteractor;
import com.example.showseverywhere.ui.login.interactor.LoginInteractorImpl;

/**
 * Created by carlos on 11/01/18.
 */

public class LoginPresenter implements LoginContrato.Presenter, LoginInteractorImpl.OnPeticionFinalizada {
    private LoginInteractor interactor;
    private LoginContrato.Vista vista;

    public LoginPresenter(LoginContrato.Vista vista) {
        this.vista = vista;
        this.interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void pedirVerificarCredenciales(String nombreUsuario, String contrasena) {
        interactor.verificarCredenciales(nombreUsuario, contrasena);
    }

    @Override
    public void onExito() {
        vista.onCredencialesCorrectas();
    }

    @Override
    public void onNombreUsuarioVacio() {
        vista.mostrarToastUsuarioVacio();
    }

    @Override
    public void onContrasenaVacia() {
        vista.mostrarToastContrasenaVacia();
    }

    @Override
    public void credencialesIncorrectos() {
        vista.mostrarToastCredencialesIncorrectas();
    }
}
