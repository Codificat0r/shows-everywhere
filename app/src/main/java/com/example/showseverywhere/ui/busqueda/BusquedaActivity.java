package com.example.showseverywhere.ui.busqueda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ArtistaAdapter;
import com.example.showseverywhere.adapter.LocalAdapter;
import com.example.showseverywhere.adapter.PropietarioAdapter;

public class BusquedaActivity extends AppCompatActivity {

    private ListView lstvBusqueda;
    private Toolbar toolbar;
    private ArtistaAdapter artistas;
    private LocalAdapter locales;
    private PropietarioAdapter propietarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        artistas = new ArtistaAdapter(this);
        locales = new LocalAdapter(this);
        propietarios = new PropietarioAdapter(this);

        lstvBusqueda = (ListView) findViewById(R.id.lstvBusqueda);
        lstvBusqueda.setAdapter(artistas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Búsqueda de artistas");
        setSupportActionBar(toolbar);
    }
}
