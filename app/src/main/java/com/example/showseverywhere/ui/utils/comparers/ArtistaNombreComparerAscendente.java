package com.example.showseverywhere.ui.utils.comparers;

import com.example.showseverywhere.data.db.model.Artista;

import java.util.Comparator;

/**
 * Created by carlos on 16/11/2017.
 */

public class ArtistaNombreComparerAscendente implements Comparator<Artista>{
    final String ORDER = "abcdefghijklmnñopqrstuvwxyz";

    @Override
    public int compare(Artista o1, Artista o2) {
        return ORDER.indexOf(o1.getNombre().substring(0,1).toLowerCase()) - ORDER.indexOf(o2.getNombre().substring(0,1).toLowerCase());
    }
}
