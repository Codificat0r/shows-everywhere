package com.example.showseverywhere.ui.utils.comparers;

import com.example.showseverywhere.data.db.model.Artista;

import java.util.Comparator;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistaPuntuacionComparerDescendente implements Comparator<Artista> {
    @Override
    public int compare(Artista o1, Artista o2) {
        if (o1.getPuntuacion() > o2.getPuntuacion())
            return -1;
        if (o1.getPuntuacion() < o2.getPuntuacion())
            return 1;
        else
            return 0;
    }
}
