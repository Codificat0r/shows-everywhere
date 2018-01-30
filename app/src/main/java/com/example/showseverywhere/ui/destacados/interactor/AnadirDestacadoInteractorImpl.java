package com.example.showseverywhere.ui.destacados.interactor;

import com.example.showseverywhere.adapter.LocalesDestacadosAdapter;
import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.data.db.model.Provincia;
import com.example.showseverywhere.data.db.repository.LocalRepository;
import com.example.showseverywhere.data.db.repository.ProvinciaRepository;
import com.example.showseverywhere.ui.utils.TextUtils;

import java.util.ArrayList;

/**
 * Created by carlos on 11/01/18.
 */

public class AnadirDestacadoInteractorImpl implements AnadirDestacadoInteractor {
    private OnPeticionFinalizada listener;

    public interface OnPeticionFinalizada {
        void nombreLocalVacio();
        void puntuacionLocalVacia();
        void localAnadido();
    }

    public AnadirDestacadoInteractorImpl(OnPeticionFinalizada listener) {
        this.listener = listener;
    }

    @Override
    public void anadirLocalDestacado(String nombreLocal, String puntuacion) {
        if (!TextUtils.verificarCampoLleno(nombreLocal)) {
            listener.nombreLocalVacio();
        } else if (!TextUtils.verificarCampoLleno(puntuacion)) {
            listener.puntuacionLocalVacia();
        } else {
            ArrayList<Provincia> provincias = ProvinciaRepository.getInstance().getProvincias();
            LocalRepository.getInstance().addLocal(new Local(nombreLocal, null, provincias.get(0), null, null, 1, null, Double.parseDouble(puntuacion), null,null,null,null));
            listener.localAnadido();
        }
    }
}
