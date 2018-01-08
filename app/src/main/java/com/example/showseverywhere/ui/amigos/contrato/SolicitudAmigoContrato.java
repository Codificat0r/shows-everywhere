package com.example.showseverywhere.ui.amigos.contrato;

import com.example.showseverywhere.data.db.model.UsuarioEstandar;

/**
 * Created by carlos on 8/01/18.
 */

public interface SolicitudAmigoContrato {
    interface Vista {
        void onExito();
    }

    interface Presenter {
        void pedirAnadirAmigo(UsuarioEstandar amigo);
    }
}
