package com.example.showseverywhere.ui.amigos.vista;

import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ViewParent;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.AmigosAsistenciasAdapter;
import com.example.showseverywhere.adapter.ViewPagerAmigosAdapter;
import com.example.showseverywhere.ui.amigos.ActionModeCallback;
import com.example.showseverywhere.ui.amigos.contrato.AmigosContrato;
import com.example.showseverywhere.ui.amigos.presenter.AmigosPresenter;

import java.util.ArrayList;
import java.util.Arrays;

public class AmigosActivity extends AppCompatActivity implements AmigosContrato.Vista, AmigosLista.AmigosListaListener, AmigosListaAsistencias.AmigosListaAsistenciasListener, ActionModeCallback.OnActionModeSuceso{
    private AmigosContrato.Presenter presenter;
    private AmigosLista amigosLista;
    private AmigosListaAsistencias amigosListaAsistencias;
    private ViewPager viewPager;
    private ViewPagerAmigosAdapter viewPagerAmigosAdapter;
    private TabLayout tabs;
    private AmigosLista fragmentAmigosLista;
    private AmigosListaAsistencias fragmentAmigosListaAsistencias;
    //ActionModeCallback
    private ActionModeCallback actionModeCallback;
    //ActionMode
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        actionModeCallback = new ActionModeCallback(this);

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

        //Recogemos los fragment para poder comunicarnos con ellos.

        fragmentAmigosLista = (AmigosLista) viewPagerAmigosAdapter.getRegisteredFragment(0);
        fragmentAmigosListaAsistencias = (AmigosListaAsistencias) viewPagerAmigosAdapter.getRegisteredFragment(1);
    }


    @Override
    public void comenzarSupportActionMode() {
        actionMode = startSupportActionMode(actionModeCallback);
    }

    @Override
    public void finalizarSupportActionMode() {
        actionMode.finish();
    }

    @Override
    public void modificarTextoActionMode(String texto) {
        actionMode.setTitle(texto);
    }

    //Heredados del ActionModeCallback interfaz interna

    @Override
    public void borrarPulsado() {
        fragmentAmigosLista.borrarPulsado();
    }

    @Override
    public void actionModeDestruido() {
        fragmentAmigosLista.desmarcarTodos();
    }
}
