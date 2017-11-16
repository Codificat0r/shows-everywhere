package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.UsuarioEstandar;

import java.util.ArrayList;

/**
 * Repositorio de datos de usuarios estandar
 */

public class UsuarioEstandarRepository {
    private ArrayList<UsuarioEstandar> usuariosEstandar;
    private static UsuarioEstandarRepository usuarioEstandarRepository;

    static {
        usuarioEstandarRepository = new UsuarioEstandarRepository();
    }

    private UsuarioEstandarRepository() {
        this.usuariosEstandar = new ArrayList<>();
        initialize();
    }

    public void addUsuario(UsuarioEstandar usuarioEstandar) {
        usuariosEstandar.add(usuarioEstandar);
    }

    private void initialize() {
        addUsuario(new UsuarioEstandar("Usuario1", null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(0), "usuario1@gmail.com"));
        addUsuario(new UsuarioEstandar("Usuario2", null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(1), "usuario2@gmail.com"));
        addUsuario(new UsuarioEstandar("Usuario3", null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(2), "usuario3@gmail.com"));
        addUsuario(new UsuarioEstandar("Usuario4", null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(3), "usuario4@gmail.com"));
        addUsuario(new UsuarioEstandar("Usuario5", null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(4), "usuario5@gmail.com"));
    }

    public static UsuarioEstandarRepository getInstance() {
        return usuarioEstandarRepository;
    }

    public ArrayList<UsuarioEstandar> getUsuariosEstandar() {
        return usuariosEstandar;
    }
}
