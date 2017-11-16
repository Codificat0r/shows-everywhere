package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Actuacion;

import java.util.ArrayList;
import java.util.Date;

/**
 * Repositorio de datos de actuaciones
 */

public class ActuacionRepository {
    private ArrayList<Actuacion> actuaciones;
    private static ActuacionRepository actuacionRepository;

    static {
        actuacionRepository = new ActuacionRepository();
    }

    private ActuacionRepository() {
        this.actuaciones = new ArrayList<>();
        initialize();
    }

    public void addActuacion(Actuacion actuacion) {
        actuaciones.add(actuacion);
    }

    private void initialize() {
        addActuacion(new Actuacion(new Date(1997, 10, 10), ArtistaRepository.getInstance().getArtistas().get(1), "Actuacion del cuentacuentos Abdul ...", "15:00", "18:00", LocalRepository.getInstance().getLocales().get(1)));
        addActuacion(new Actuacion(new Date(1997, 8, 12), GrupoArtisticoRepository.getInstance().getGruposArtisticos().get(0), "Actuacion del grupo artistico ...", "12:00", "15:00", LocalRepository.getInstance().getLocales().get(2)));
        addActuacion(new Actuacion(new Date(1997, 11, 13), GrupoArtisticoRepository.getInstance().getGruposArtisticos().get(1), "Actuacion del grupo artistico ...", "13:00", "17:00", LocalRepository.getInstance().getLocales().get(3)));
        addActuacion(new Actuacion(new Date(1997, 6, 16), GrupoArtisticoRepository.getInstance().getGruposArtisticos().get(2), "Actuacion del grupo artistico ...", "10:00", "15:00", LocalRepository.getInstance().getLocales().get(4)));
        addActuacion(new Actuacion(new Date(1997, 4, 22), ArtistaRepository.getInstance().getArtistas().get(0), "Actuacion del rockero ...", "19:00", "23:00", LocalRepository.getInstance().getLocales().get(5)));
    }

    public static ActuacionRepository getInstance() {
        return actuacionRepository;
    }

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }
}
