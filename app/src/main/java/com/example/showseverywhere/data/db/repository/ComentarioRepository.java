package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Comentario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by carlos on 19/11/2017.
 */

public class ComentarioRepository {
    private ArrayList<Comentario> comentarios;
    private static ComentarioRepository comentarioRepository;

    static {
        comentarioRepository = new ComentarioRepository();
    }

    private ComentarioRepository() {
        this.comentarios = new ArrayList<>();
        initialize();
    }

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    private void initialize() {
        comentarios.add(new Comentario("Gran artista, me encanto tu actuacion el otro dia ...", new Date(2017, 5, 20), UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(0)));
        comentarios.add(new Comentario("El dia 10 del pasado mes triunfastes, fue una actuación con cuerpo y sin desperdicio ninguno. Espero que siempre sigas teniendo trabajo y no tengas que perder el tiempo debido a lo ocupado que estes, saludos ...", new Date(2017, 6, 1), UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(1)));
        comentarios.add(new Comentario("Por supuesto que se puede mejorar, no vaya a ser que nos flipamos, pero aunque estuvo bien siempre habia cosas que mejorar, por ejemplo, a la hora de cantar podrias haberte metido más en el papel ...", new Date(2017, 4, 12), UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(2)));
        comentarios.add(new Comentario("Bueno solo decir que me dejastes sin palabras, da igual lo que digan los demas comentarios lo hicistes super genial! ...", new Date(2017, 9, 4), UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(3)));
        comentarios.add(new Comentario("Pienso asistir a la siguiente actuación sin duda ninguna. Fue absolutamente increible, nunca escuché a nadie cantar de esa manera, tienes talento chico, no lo desperdicies nunca! ...", new Date(2017, 2, 21), UsuarioEstandarRepository.getInstance().getUsuariosEstandar().get(4)));
    }

    public static ComentarioRepository getInstance() {
        return comentarioRepository;
    }

    public ArrayList<Comentario> getComentarios() {
        Collections.sort(comentarios);
        return comentarios;
    }
}
