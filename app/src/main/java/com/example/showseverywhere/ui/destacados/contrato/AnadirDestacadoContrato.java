package com.example.showseverywhere.ui.destacados.contrato;

/**
 * Created by carlos on 11/01/18.
 */

public interface AnadirDestacadoContrato {
    interface Vista {
        void mostrarPuntuacionVacia();
        void mostrarNombreVacio();
        void onLocalAnadido();
    }

    interface Presenter {
        void pedirAnadirLocalDestacado(String nombreLocal, String puntuacion);
    }
}
