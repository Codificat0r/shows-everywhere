package com.example.showseverywhere.data.db.model;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Clase que dará soporte a un propietario de la base de datos
 */

public class Propietario implements Usuario, Comparable<Propietario>{
    private int id;
    private String nombre;
    private String apellido;
    private String descripcion;
    private String telefono;
    private String password;
    private Image foto_fondo;
    private String correo_electronico;
    private Image foto;
    private Provincia provincia;

    //CONSTRUCTOR

    public Propietario(int id, String nombre, String apellido, @Nullable String descripcion, String telefono, String password, @Nullable Image foto_fondo, String correo_electronico, @Nullable Image foto, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.password = password;
        this.foto_fondo = foto_fondo;
        this.correo_electronico = correo_electronico;
        this.foto = foto;
        this.provincia = provincia;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getFoto_fondo() {
        return foto_fondo;
    }

    public void setFoto_fondo(Image foto_fondo) {
        this.foto_fondo = foto_fondo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int compareTo(@NonNull Propietario o) {
        return getNombre().compareTo(o.getNombre());
    }
}
