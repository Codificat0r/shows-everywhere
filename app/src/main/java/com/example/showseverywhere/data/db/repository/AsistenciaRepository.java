package com.example.showseverywhere.data.db.repository;

import android.support.annotation.NonNull;

import com.example.showseverywhere.data.db.model.Asistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by carlos on 18/11/2017.
 */

public class AsistenciaRepository{
    private ArrayList<Asistencia> asistencias;
    private static AsistenciaRepository asistenciaRepository;

    static {
        asistenciaRepository = new AsistenciaRepository();
    }

    private AsistenciaRepository() {
        this.asistencias = new ArrayList<>();
        initialize();
    }

    public void addAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    private void initialize() {
        addAsistencia(new Asistencia(UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(0), ActuacionRepository.getInstance().getActuaciones().get(4)));
        addAsistencia(new Asistencia(UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(1), ActuacionRepository.getInstance().getActuaciones().get(3)));
        addAsistencia(new Asistencia(UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(2), ActuacionRepository.getInstance().getActuaciones().get(2)));
        addAsistencia(new Asistencia(UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(3), ActuacionRepository.getInstance().getActuaciones().get(1)));
        addAsistencia(new Asistencia(UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(4), ActuacionRepository.getInstance().getActuaciones().get(0)));
    }

    public static AsistenciaRepository getInstance() {
        return asistenciaRepository;
    }

    public ArrayList<Asistencia> getAsistencias() {
        Collections.sort(asistencias);
        return asistencias;
    }

}
