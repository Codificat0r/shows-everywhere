package com.example.showseverywhere.ui.destacados.interactor;

import com.example.showseverywhere.data.db.model.Local;

/**
 * Created by carlos on 11/01/18.
 */

public interface DestacadosInteractor {
    void obtenerLocalesDestacados();
    void borrarLocal(Local local);
}
