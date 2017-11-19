package com.example.showseverywhere.data.db.model;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by carlos on 19/11/2017.
 */

public class Comentario implements Comparable<Comentario> {
    private String contenido;
    private Date fecha;
    private UsuarioEstandar usuarioEstandar;

    //CONSTRUCTOR

    public Comentario(String contenido, Date fecha, UsuarioEstandar usuarioEstandar) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuarioEstandar = usuarioEstandar;
    }

    //GETTERS AND SETTERS

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public UsuarioEstandar getUsuarioEstandar() {
        return usuarioEstandar;
    }

    public void setUsuarioEstandar(UsuarioEstandar usuarioEstandar) {
        this.usuarioEstandar = usuarioEstandar;
    }

    @Override
    public int compareTo(@NonNull Comentario o) {
        return fecha.compareTo(o.getFecha());
    }
}
