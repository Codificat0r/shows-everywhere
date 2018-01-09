package com.example.showseverywhere.ui.amigos.contrato;

import com.example.showseverywhere.data.db.model.Asistencia;

import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public interface AmigosListaAsistenciasContrato {
    interface Vista {
        void onExito(List<Asistencia> asistencias);
    }

    interface Presenter {
        void pedirListaAsistencias();
    }
}
