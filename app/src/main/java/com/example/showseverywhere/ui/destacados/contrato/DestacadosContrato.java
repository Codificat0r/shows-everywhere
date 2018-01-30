package com.example.showseverywhere.ui.destacados.contrato;

import com.example.showseverywhere.data.db.model.Local;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public interface DestacadosContrato {
    interface Vista {
        void onLocalesObtenidos(ArrayList<Local> locales);
    }

    interface Presenter {
        void pedirLocalesDestacados();
        void pedirBorrarLocal(Local local);
    }
}
