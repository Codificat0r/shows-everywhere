package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Local;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Repositorio de datos de locales
 */

public class LocalRepository {
    private ArrayList<Local> locales;
    private static LocalRepository localRepository;

    static {
        localRepository = new LocalRepository();
    }

    private LocalRepository() {
        this.locales = new ArrayList<>();
        initialize();
    }

    public void addLocal(Local local) {
        locales.add(local);
    }

    private void initialize() {
        addLocal(new Local("Venecian Food", null, ProvinciaRepository.getInstance().getProvincias().get(0), "Local amplio con bellas vistas ...", "952626262", 50, "Calle Alcalá", 5.0, PropietarioRepository.getInstance().getPropietarios().get(0), null, "www.local1.com", "local1@gmail.com"));
        addLocal(new Local("Chicken'n'chips", null, ProvinciaRepository.getInstance().getProvincias().get(1), "Local amplio con bellas vistas ...", "974958216", 35, "Calle Donaire", 3.5, PropietarioRepository.getInstance().getPropietarios().get(1), null, "www.local2.com", "local2@gmail.com"));
        addLocal(new Local("Tree Hall", null, ProvinciaRepository.getInstance().getProvincias().get(2), "Local amplio con bellas vistas ...", "984721332", 20, "Calle Hazam", 2.3, PropietarioRepository.getInstance().getPropietarios().get(2), null, "www.local3.com", "local3@gmail.com"));
        addLocal(new Local("Horrible taste", null, ProvinciaRepository.getInstance().getProvincias().get(3), "Local amplio con bellas vistas ...", "900236401", 80, "Calle Buen Aire", 4.9, PropietarioRepository.getInstance().getPropietarios().get(3), null, "www.local4.com", "local4@gmail.com"));
        addLocal(new Local("Where's my food?", null, ProvinciaRepository.getInstance().getProvincias().get(4), "Local amplio con bellas vistas ...", "951010291", 55, "Calle Gozo", 4.2, PropietarioRepository.getInstance().getPropietarios().get(4), null, "www.local5.com", "local5@gmail.com"));
    }

    public static LocalRepository getInstance() {
        return localRepository;
    }

    public ArrayList<Local> getLocales() {
        Collections.sort(locales);
        return locales;
    }

    public void borrarLocal(Local local) {
        locales.remove(local);
    }
}
