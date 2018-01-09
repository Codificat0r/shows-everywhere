package com.example.showseverywhere.ui.amigos.interactor;

import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;

import java.util.HashMap;

/**
 * Created by carlos on 8/01/18.
 */

public interface AmigosListaInteractor {
    void obtenerListaAmigos();
    void marcarSeleccionado(int position);
    void desmarcarSeleccionado(int position);
    void desmarcarTodos();
    void borrarAmigos();
}
