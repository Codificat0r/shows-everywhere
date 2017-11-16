package com.example.showseverywhere.data.db.repository;

import com.example.showseverywhere.data.db.model.Artista;

import java.util.ArrayList;

/**
 * Repositorio de datos de artistas
 */

public class ArtistaRepository {
    private ArrayList<Artista> artistas;
    private static ArtistaRepository artistaRepository;

    static {
        artistaRepository = new ArtistaRepository();
    }

    private ArtistaRepository() {
        this.artistas = new ArrayList<>();
        initialize();
    }

    public void addArtista(Artista artista) {
        artistas.add(artista);
    }

    private void initialize() {
        addArtista(new Artista(1, "Pepe","Gallego Ruiz","Cantante de rock, country, heavy metal ...","Destripper","653721263", "Soy un artista entregado a mi hobby y profesión ... ", 4.0, ProvinciaRepository.getInstance().getProvincias().get(0), null, "Artistas Referentes S.L.", "1A2b3c", "Cantante y guitarrista", null, 24, "artista1@gmail.com"));
        addArtista(new Artista(2, "Abdul","Fal Rute","Todo tipo de cuentos ...","Cuentomagico","649132564", "Soy un artista entregado a mi hobby y profesión ... ", 5.0, ProvinciaRepository.getInstance().getProvincias().get(1), null, null, "1A2b3c", "Cuentacuentos", null, 45, "artista2@gmail.com"));
        addArtista(new Artista(3, "Santiago","Bonilla Borras","Cardistry, juego con monedas ...","Skeletor","672839452", "Soy un artista entregado a mi hobby y profesión ... ", 3.7, ProvinciaRepository.getInstance().getProvincias().get(2), null, null, "1A2b3c", "Mago", null, 23, "artista3@gmail.com"));
        addArtista(new Artista(4, "Ismael","Acedo Blasco","Teatro dramático, de comedia, tragedia ...","Tragedico","600912783", "Soy un artista entregado a mi hobby y profesión ... ", 1.3, ProvinciaRepository.getInstance().getProvincias().get(3), null, "Dramas y tragedias S.L.", "1A2b3c", "Actor", null, 19, "artista4@gmail.com"));
        addArtista(new Artista(5, "Juana","González Millan","Monologos sobre política ...",null,"686725364", "Soy un artista entregado a mi hobby y profesión ... ", 2.9, ProvinciaRepository.getInstance().getProvincias().get(4), null, "Risas aseguradas S.L.", "1A2b3c", "Monologuista", null, 32, "artista5@gmail.com"));
    }

    public static ArtistaRepository getInstance() {
        return artistaRepository;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }
}
