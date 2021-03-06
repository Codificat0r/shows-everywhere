package com.example.showseverywhere.data.db.model;

import android.support.annotation.NonNull;

/**
 * Clase que dará soporte a una provincia de la base de datos
 */

public class Provincia implements Comparable<Provincia>{
    private int id_provincia;
    private String provincia;

    //CONSTRUCTOR

    public Provincia(int id_provincia, String provincia) {
        this.id_provincia = id_provincia;
        this.provincia = provincia;
    }

    //GETTERS AND SETTERS

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int compareTo(@NonNull Provincia o) {
        return provincia.compareTo(o.provincia);
    }
}
