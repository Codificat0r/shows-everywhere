package com.example.showseverywhere.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.showseverywhere.ui.amigos.vista.AmigosLista;
import com.example.showseverywhere.ui.amigos.vista.AmigosListaAsistencias;

import java.util.ArrayList;

/**
 * Created by carlos on 8/01/18.
 */

public class ViewPagerAmigosAdapter extends FragmentPagerAdapter {

    private int pageCount;
    private ArrayList<String> titulos;

    public ViewPagerAmigosAdapter(FragmentManager fragmentManager, int pageCount, ArrayList<String> titulos) {
        super(fragmentManager);
        this.pageCount = pageCount;
        this.titulos = titulos;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragmentActual = null;
        switch (position) {
            case 0:
                fragmentActual = AmigosLista.newInstance(null);
                break;
            case 1:
                fragmentActual = AmigosListaAsistencias.newInstance(null);
                break;
        }
        return fragmentActual;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }
}
