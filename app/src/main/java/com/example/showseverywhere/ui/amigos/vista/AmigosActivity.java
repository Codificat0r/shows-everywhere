package com.example.showseverywhere.ui.amigos.vista;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewParent;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ViewPagerAmigosAdapter;
import com.example.showseverywhere.ui.amigos.contrato.AmigosContrato;
import com.example.showseverywhere.ui.amigos.presenter.AmigosPresenter;

import java.util.ArrayList;
import java.util.Arrays;

public class AmigosActivity extends AppCompatActivity implements AmigosContrato.Vista, AmigosLista.AmigosListaListener, AmigosListaAsistencias.AmigosListaAsistenciasListener{
    private AmigosContrato.Presenter presenter;
    private AmigosLista amigosLista;
    private AmigosListaAsistencias amigosListaAsistencias;
    private ViewPager viewPager;
    private ViewPagerAmigosAdapter viewPagerAmigosAdapter;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        presenter = new AmigosPresenter(this);

        tabs = (TabLayout) findViewById(R.id.tabs);

        //Añadimos los tabs
        for (String s : getResources().getStringArray(R.array.amigos_tabs)) {
            tabs.addTab(tabs.newTab().setText(s));
        }

        //Configuramos el viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAmigosAdapter = new ViewPagerAmigosAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.amigos_tabs).length, new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.amigos_tabs))));
        viewPager.setAdapter(viewPagerAmigosAdapter);

        tabs.setupWithViewPager(viewPager);
    }


}
