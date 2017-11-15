package com.example.showseverywhere.data.db.model;

import android.support.annotation.Nullable;

import java.sql.Time;
import java.util.Date;

/**
 * Clase que dará soporte a una actuación de la base de datos.
 */

public class Actuacion {
    private Date fecha;
    //Se debe comprobar que sea un artista
    private Artista artista;
    private GrupoArtistico grupo_artistico;
    private String descripcion;
    private String hora_desde;
    private String hora_hasta;
    private Local local;

    //CONSTRUCTORES

    public Actuacion(Date fecha, Artista artista, @Nullable String descripcion, String hora_desde, String hora_hasta, Local local) {
        this.fecha = fecha;
        this.artista = artista;
        this.descripcion = descripcion;
        this.hora_desde = hora_desde;
        this.hora_hasta = hora_hasta;
        this.local = local;
    }

    public Actuacion(Date fecha, GrupoArtistico grupo_artistico, @Nullable String descripcion, String hora_desde, String hora_hasta, Local local) {
        this.fecha = fecha;
        this.grupo_artistico = grupo_artistico;
        this.descripcion = descripcion;
        this.hora_desde = hora_desde;
        this.hora_hasta = hora_hasta;
        this.local = local;
    }

    //GETTERS AND SETTERS

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public GrupoArtistico getGrupo_artistico() {
        return grupo_artistico;
    }

    public void setGrupo_artistico(GrupoArtistico grupo_artistico) {
        this.grupo_artistico = grupo_artistico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora_desde() {
        return hora_desde;
    }

    public void setHora_desde(String hora_desde) {
        this.hora_desde = hora_desde;
    }

    public String getHora_hasta() {
        return hora_hasta;
    }

    public void setHora_hasta(String hora_hasta) {
        this.hora_hasta = hora_hasta;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
