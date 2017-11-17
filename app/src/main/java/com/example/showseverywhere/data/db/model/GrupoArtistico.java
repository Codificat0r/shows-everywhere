package com.example.showseverywhere.data.db.model;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Clase que dará soporte a un grupo artístico de la base de datos
 */

public class GrupoArtistico implements Comparable<GrupoArtistico>{
    private int id;
    private Image foto;
    private Image foto_fondo;
    private String nombre;
    private String descripcion;

    //CONSTRUCTOR

    public GrupoArtistico(int id, @Nullable Image foto, @Nullable Image foto_fondo, String nombre, @Nullable String descripcion) {
        this.id = id;
        this.foto = foto;
        this.foto_fondo = foto_fondo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto_fondo() {
        return foto_fondo;
    }

    public void setFoto_fondo(Image foto_fondo) {
        this.foto_fondo = foto_fondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int compareTo(@NonNull GrupoArtistico o) {
        return getNombre().compareTo(o.getNombre());
    }
}
