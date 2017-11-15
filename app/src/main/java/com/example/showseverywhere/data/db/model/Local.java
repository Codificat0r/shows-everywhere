package com.example.showseverywhere.data.db.model;

import android.media.Image;
import android.support.annotation.Nullable;

/**
 * Clase que dará soporte a una provincia de la base de datos
 */

public class Local {
    private String nombre;
    private Image foto_fondo;
    private Provincia provincia;
    private String descripcion;
    private String telefono;
    private int aforo;
    private String direccion;
    private double puntuacion;
    private Propietario propietario;
    private Image foto;
    private String sitio_web;
    private String correo_electronico;

    //CONSTRUCTOR

    public Local(String nombre, @Nullable Image foto_fondo, Provincia provincia, @Nullable String descripcion, String telefono, @Nullable int aforo, String direccion, double puntuacion, Propietario propietario, @Nullable Image foto, @Nullable String sitio_web, @Nullable String correo_electronico) {
        this.nombre = nombre;
        this.foto_fondo = foto_fondo;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.aforo = aforo;
        this.direccion = direccion;
        this.puntuacion = puntuacion;
        this.propietario = propietario;
        this.foto = foto;
        this.sitio_web = sitio_web;
        this.correo_electronico = correo_electronico;
    }

    //GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getFoto_fondo() {
        return foto_fondo;
    }

    public void setFoto_fondo(Image foto_fondo) {
        this.foto_fondo = foto_fondo;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}
