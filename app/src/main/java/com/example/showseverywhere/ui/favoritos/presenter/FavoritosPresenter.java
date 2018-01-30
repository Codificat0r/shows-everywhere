package com.example.showseverywhere.ui.favoritos.presenter;

import com.example.showseverywhere.ui.favoritos.contrato.FavoritosContrato;
import com.example.showseverywhere.ui.favoritos.interactor.FavoritosInteractor;
import com.example.showseverywhere.ui.favoritos.interactor.FavoritosInteractorImpl;

/**
 * Created by carlos on 11/01/18.
 */

public class FavoritosPresenter implements FavoritosContrato.Presenter, FavoritosInteractorImpl.OnPeticionFinalizada {
    private FavoritosInteractor interactor;
    private FavoritosContrato.Vista vista;

    public FavoritosPresenter(FavoritosContrato.Vista vista) {
        this.vista = vista;
        this.interactor = new FavoritosInteractorImpl(this);
    }
}
