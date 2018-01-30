package com.example.showseverywhere.ui.favoritos.interactor;

/**
 * Created by carlos on 11/01/18.
 */

public class FavoritosInteractorImpl implements FavoritosInteractor {
    private OnPeticionFinalizada listener;

    public interface OnPeticionFinalizada {

    }

    public FavoritosInteractorImpl(OnPeticionFinalizada listener) {
        this.listener = listener;
    }
}
