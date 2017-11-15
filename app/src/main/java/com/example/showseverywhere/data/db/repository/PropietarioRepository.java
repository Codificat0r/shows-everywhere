package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Propietario;

import java.util.ArrayList;

/**
 * Repositorio de datos de propietarios
 */

public class PropietarioRepository {
    private ArrayList<Propietario> propietarios;
    private static PropietarioRepository propietarioRepository;

    static {
        propietarioRepository = new PropietarioRepository();
    }

    private PropietarioRepository() {
        this.propietarios = new ArrayList<>();
        initialize();
    }

    public void addPropietario(Propietario propietario) {
        propietarios.add(propietario);
    }

    private void initialize() {
        addPropietario(new Propietario(1, "Carlos", "Cruz Domínguez", "Soy un propietario ambicioso ...", "626181211", "1A2b3c", null, "propietario1@gmail.com", null, ProvinciaRepository.getInstance().getProvincias().get(1)));
        addPropietario(new Propietario(2, "Paco", "Moya Alfa", "Soy un propietario ambicioso ...", "646567121", "1A2b3c", null, "propietario2@gmail.com", null, ProvinciaRepository.getInstance().getProvincias().get(1)));
        addPropietario(new Propietario(3, "Pluto", "Pérez Camboya", "Soy un propietario ambicioso ...", "638486241", "1A2b3c", null, "propietario3@gmail.com", null, ProvinciaRepository.getInstance().getProvincias().get(1)));
        addPropietario(new Propietario(4, "Maria", "Asta Rodriguez", "Soy un propietario ambicioso ...", "695421842", "1A2b3c", null, "propietario4@gmail.com", null, ProvinciaRepository.getInstance().getProvincias().get(1)));
        addPropietario(new Propietario(5, "Eva", "Torres Soto", "Soy un propietario ambicioso ...", "611223256", "1A2b3c", null, "propietario5@gmail.com", null, ProvinciaRepository.getInstance().getProvincias().get(1)));
    }

    public static PropietarioRepository getInstance() {
        return propietarioRepository;
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }
}
