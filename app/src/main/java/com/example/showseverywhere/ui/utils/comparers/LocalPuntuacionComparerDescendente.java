package com.example.showseverywhere.ui.utils.comparers;

import com.example.showseverywhere.data.db.model.Local;

import java.util.Comparator;

/**
 * Created by carlos on 16/11/2017.
 */

public class LocalPuntuacionComparerDescendente implements Comparator<Local>{
    @Override
    public int compare(Local o1, Local o2) {
        if (o1.getPuntuacion() > o2.getPuntuacion())
            return -1;
        if (o1.getPuntuacion() < o2.getPuntuacion())
            return 1;
        else
            return 0;
    }
}
