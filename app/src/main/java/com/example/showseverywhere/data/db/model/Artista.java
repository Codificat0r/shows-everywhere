package com.example.showseverywhere.data.db.model;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Clase que dará soporte a un artista de la base de datos.
 */

public class Artista implements Usuario, Comparable<Artista>{
    private int id;
    private String nombre;
    private String apellido;
    private String habilidades;
    private String nombre_artistico;
    private String telefono;
    private String descripcion;
    private double puntuacion;
    private Provincia provincia;
    private Image foto_fondo;
    private String organizacion;
    private String password;
    private String tipo;
    private Image foto;
    private int edad;
    private String correo_electronico;

    //CONSTRUCTOR

    public Artista(int id, String nombre, String apellido, String habilidades, @Nullable String nombre_artistico, String telefono, @Nullable String descripcion, double puntuacion, Provincia provincia, @Nullable Image foto_fondo, @Nullable String organizacion, String password, String tipo, @Nullable Image foto, int edad, String correo_electronico) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
        this.nombre_artistico = nombre_artistico;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.provincia = provincia;
        this.foto_fondo = foto_fondo;
        this.organizacion = organizacion;
        this.password = password;
        this.tipo = tipo;
        this.foto = foto;
        this.edad = edad;
        this.correo_electronico = correo_electronico;
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

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getNombre_artistico() {
        return nombre_artistico;
    }

    public void setNombre_artistico(String nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Image getFoto_fondo() {
        return foto_fondo;
    }

    public void setFoto_fondo(Image foto_fondo) {
        this.foto_fondo = foto_fondo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public int compareTo(@NonNull Artista o) {
        return getNombre().compareTo(o.getNombre());
    }
}
