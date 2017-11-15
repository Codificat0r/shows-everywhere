package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.GrupoArtistico;

import java.util.ArrayList;

/**
 * Repositorio de datos de grupos artisticos
 */

public class GrupoArtisticoRepository {
    private ArrayList<GrupoArtistico> gruposArtisticos;
    private static GrupoArtisticoRepository grupoArtisticoRepository;

    static {
        grupoArtisticoRepository = new GrupoArtisticoRepository();
    }

    private GrupoArtisticoRepository() {
        this.gruposArtisticos = new ArrayList<>();
        initialize();
    }

    public void addGrupoArtistico(GrupoArtistico grupoArtistico) {
        gruposArtisticos.add(grupoArtistico);
    }

    private void initialize() {
        addGrupoArtistico(new GrupoArtistico(1, null, null, "Aves negras", "Somos un pequeño grupo artístico ..."));
        addGrupoArtistico(new GrupoArtistico(2, null, null, "Agua manantial", "Somos un pequeño grupo artístico ..."));
        addGrupoArtistico(new GrupoArtistico(3, null, null, "Old Rockers", "Somos un pequeño grupo artístico ..."));
        addGrupoArtistico(new GrupoArtistico(4, null, null, "Charlas nocturnas", "Somos un pequeño grupo artístico ..."));
        addGrupoArtistico(new GrupoArtistico(5, null, null, "Monologuistas locos", "Somos un pequeño grupo artístico ..."));
    }

    public static GrupoArtisticoRepository getInstance() {
        return grupoArtisticoRepository;
    }

    public ArrayList<GrupoArtistico> getGruposArtisticos() {
        return gruposArtisticos;
    }
}
