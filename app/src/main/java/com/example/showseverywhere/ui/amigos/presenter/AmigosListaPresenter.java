package com.example.showseverywhere.ui.amigos.presenter;

import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.ui.amigos.contrato.AmigosListaContrato;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaInteractor;
import com.example.showseverywhere.ui.amigos.interactor.AmigosListaInteractorImpl;

import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaPresenter implements AmigosListaContrato.Presenter, AmigosListaInteractorImpl.OnExitoOperacionRequeridaListener{
    private AmigosListaInteractor interactor;
    private AmigosListaContrato.Vista vista;

    public AmigosListaPresenter(AmigosListaContrato.Vista vista) {
        this.vista = vista;
        interactor = new AmigosListaInteractorImpl(this);
    }

    @Override
    public void pedirListaAmigos() {
        interactor.obtenerListaAmigos();
    }

    @Override
    public void pedirMarcarSeleccionado(int position) {
        interactor.marcarSeleccionado(position);
    }

    @Override
    public void pedirDesmarcarSeleccionado(int position) {
        interactor.desmarcarSeleccionado(position);
    }

    @Override
    public void pedirDesmarcarTodos() {
        interactor.desmarcarTodos();
    }

    @Override
    public void pedirBorrarAmigos() {
        interactor.borrarAmigos();
    }

    @Override
    public void onExito(List<UsuarioEstandar> amigos) {
        vista.onExito(amigos);
    }

    @Override
    public void pedirVerificarNoMarcadoParaMarcar(int position) {
        interactor.verificarNoMarcadoParaMarcar(position);
    }

    @Override
    public void pedirVerificarMarcadoParaDesmarcar(int position) {
        interactor.verificarMarcadoParaDesmarcar(position);
    }

    @Override
    public void onNoMarcadoParaMarcar(int position) {
        vista.marcar(position);
    }

    @Override
    public void onMarcadoParaDesmarcar(int position) {
        vista.desmarcar(position);
    }
}
