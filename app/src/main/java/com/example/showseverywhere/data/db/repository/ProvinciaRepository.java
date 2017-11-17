package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Provincia;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Repositorio de datos de provincias
 */

public class ProvinciaRepository {
    private ArrayList<Provincia> provincias;
    private static ProvinciaRepository provinciaRepository;

    static {
        provinciaRepository = new ProvinciaRepository();
    }

    private ProvinciaRepository() {
        this.provincias = new ArrayList<>();
        initialize();
    }

    public void addProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    private void initialize() {
        addProvincia(new Provincia(1, "Málaga"));
        addProvincia(new Provincia(2, "Cádiz"));
        addProvincia(new Provincia(3, "Huelva"));
        addProvincia(new Provincia(4, "Granada"));
        addProvincia(new Provincia(5, "Almería"));
    }

    public static ProvinciaRepository getInstance() {
        return provinciaRepository;
    }

    public ArrayList<Provincia> getProvincias() {
        Collections.sort(provincias);
        return provincias;
    }
}
