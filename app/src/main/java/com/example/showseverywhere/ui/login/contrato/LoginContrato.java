package com.example.showseverywhere.ui.login.contrato;

/**
 * Created by carlos on 11/01/18.
 */

public interface LoginContrato {
    interface Vista {
        void onCredencialesCorrectas();
        void mostrarToastUsuarioVacio();
        void mostrarToastContrasenaVacia();
        void mostrarToastCredencialesIncorrectas();
    }

    interface Presenter {
        void pedirVerificarCredenciales(String nombreUsuario, String contrasena);
    }
}
