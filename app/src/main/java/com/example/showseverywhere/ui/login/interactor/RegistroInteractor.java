package com.example.showseverywhere.ui.login.interactor;

/**
 * Created by carlos on 11/01/18.
 */

public interface RegistroInteractor {
    void obtenerProvincias();
    void verificarDatosRegistroUsuarioEstandar(String nombreUsuario, String contrasena, String email, String provincia);
}
