package com.example.showseverywhere.data.db.model;

import android.media.Image;

/**
 * Interfaz que servirá para preguntar por qué tipo de usuario es y así
 * saber que layout cargar al reutilizar actividades.
 */

public interface Usuario {

    Image getFoto();

    void setFoto(Image foto);

    Image getFoto_fondo();

    void setFoto_fondo(Image foto_fondo);

    String getPassword();

    void setPassword(String password);

    Provincia getProvincia();

    void setProvincia(Provincia provincia);

    String getCorreo_electronico();

    void setCorreo_electronico(String correo_electronico);
}
