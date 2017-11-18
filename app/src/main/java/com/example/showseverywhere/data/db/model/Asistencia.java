package com.example.showseverywhere.data.db.model;

import android.support.annotation.NonNull;

/**
 * Created by carlos on 18/11/2017.
 */

public class Asistencia implements Comparable<Asistencia>{
    private UsuarioEstandar usuarioEstandar;
    private Actuacion actuacion;

    //CONSTRUCTOR

    public Asistencia(UsuarioEstandar usuarioEstandar, Actuacion actuacion) {
        this.usuarioEstandar = usuarioEstandar;
        this.actuacion = actuacion;
    }

    //GETTERS AND SETTERS

    public UsuarioEstandar getUsuarioEstandar() {
        return usuarioEstandar;
    }

    public void setUsuarioEstandar(UsuarioEstandar usuarioEstandar) {
        this.usuarioEstandar = usuarioEstandar;
    }

    public Actuacion getActuacion() {
        return actuacion;
    }

    public void setActuacion(Actuacion actuacion) {
        this.actuacion = actuacion;
    }

    @Override
    public int compareTo(@NonNull Asistencia o) {
        return usuarioEstandar.getNick().compareTo(o.getUsuarioEstandar().getNick());
    }
}
