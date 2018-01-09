package com.example.showseverywhere.ui.amigos.interactor;

import com.example.showseverywhere.data.db.model.Asistencia;
import com.example.showseverywhere.data.db.repository.AsistenciaRepository;

import java.util.List;

/**
 * Created by carlos on 8/01/18.
 */

public class AmigosListaAsistenciasInteractorImpl implements AmigosListaAsistenciasInteractor {
    private OnExitoOperacionRequeridaListener listener;

    public interface OnExitoOperacionRequeridaListener {
        void onExito(List<Asistencia> asistencias);
    }

    public AmigosListaAsistenciasInteractorImpl(OnExitoOperacionRequeridaListener listener) {
        this.listener = listener;
    }

    @Override
    public void obtenerListaAsistencias() {
        listener.onExito(AsistenciaRepository.getInstance().getAsistencias());
    }
}
