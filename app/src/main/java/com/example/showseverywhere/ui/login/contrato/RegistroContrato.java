package com.example.showseverywhere.ui.login.contrato;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public interface RegistroContrato {
    interface Vista {
        void onProvinciasObtenidas(ArrayList<String> provincias);
        void mostrarCampoObligatorioVacío();
        void onExitoRegistro();
        void mostrarEmailMalFormado();
        void mostrarContrasenaMalFormada();
    }

    interface Presenter {
        void pedirProvincias();
        void pedirVerificarDatosRegistroUsuarioEstandar(String nombreUsuario, String contrasena, String email, String provincia);
    }
}
