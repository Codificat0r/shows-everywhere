package com.example.showseverywhere.ui.destacados.interactor;

import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.data.db.repository.LocalRepository;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class DestacadosInteractorImpl implements DestacadosInteractor {
    OnPeticionFinalizada listener;

    public interface OnPeticionFinalizada {
        void onExitoLocalesObtenidos(ArrayList<Local> locales);
    }

    public DestacadosInteractorImpl(OnPeticionFinalizada listener) {
        this.listener = listener;
    }

    @Override
    public void obtenerLocalesDestacados() {
        listener.onExitoLocalesObtenidos(LocalRepository.getInstance().getLocales());
    }

    @Override
    public void borrarLocal(Local local) {
        LocalRepository.getInstance().borrarLocal(local);
        listener.onExitoLocalesObtenidos(LocalRepository.getInstance().getLocales());
    }
}
