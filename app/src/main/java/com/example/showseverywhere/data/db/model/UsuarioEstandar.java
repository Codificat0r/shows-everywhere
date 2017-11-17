package com.example.showseverywhere.data.db.model;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Clase que dara soporte a un usuario estándar de la base de datos
 */

public class UsuarioEstandar implements Usuario, Comparable<UsuarioEstandar>{
    private String nick;
    private Image foto;
    private Image foto_fondo;
    private String password;
    private Provincia provincia;
    private String correo_electronico;

    //CONSTRUCTOR

    public UsuarioEstandar(String nick, @Nullable Image foto, @Nullable Image foto_fondo, String password, Provincia provincia, String correo_electronico) {
        this.nick = nick;
        this.foto = foto;
        this.foto_fondo = foto_fondo;
        this.password = password;
        this.provincia = provincia;
        this.correo_electronico = correo_electronico;
    }

    //GETTERS AND SETTERS

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public int compareTo(@NonNull UsuarioEstandar o) {
        return getNick().compareTo(o.getNick());
    }
}
