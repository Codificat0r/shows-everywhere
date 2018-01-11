package com.example.showseverywhere.ui.amigos.contrato;

import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;

import java.util.HashMap;
import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public interface AmigosListaContrato {
    interface Vista {
        void onExito(List<UsuarioEstandar> amigos);
        void marcar(int position);
        void desmarcar(int position);
    }

    interface Presenter {
        void pedirListaAmigos();
        void pedirMarcarSeleccionado(int position);
        void pedirDesmarcarSeleccionado(int position);
        void pedirDesmarcarTodos();
        void pedirBorrarAmigos();
        void pedirVerificarNoMarcadoParaMarcar(int position);
        void pedirVerificarMarcadoParaDesmarcar(int position);
    }
}
