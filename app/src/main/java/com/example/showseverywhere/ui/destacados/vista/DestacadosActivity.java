package com.example.showseverywhere.ui.destacados.vista;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ArtistasDestacadosAdapter;
import com.example.showseverywhere.adapter.LocalesDestacadosAdapter;
import com.example.showseverywhere.data.db.model.Local;
import com.example.showseverywhere.ui.destacados.contrato.DestacadosContrato;
import com.example.showseverywhere.ui.destacados.presenter.DestacadosPresenter;

import java.util.ArrayList;

public class DestacadosActivity extends AppCompatActivity implements DestacadosContrato.Vista {

    private ListView lstvDestacados;
    private Toolbar toolbar;
    private LocalesDestacadosAdapter localesDestacados;
    private ArtistasDestacadosAdapter artistasDestacados;
    private FloatingActionButton fab;
    private DestacadosContrato.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destacados);

        presenter = new DestacadosPresenter(this);

        localesDestacados = new LocalesDestacadosAdapter(this);
        artistasDestacados = new ArtistasDestacadosAdapter(this);

        lstvDestacados = (ListView) findViewById(R.id.lstvDestacados);
        lstvDestacados.setAdapter(localesDestacados);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Locales destacados");
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DestacadosActivity.this, AnadirDestacadoActivity.class);
                startActivity(i);
            }
        });

        presenter.pedirLocalesDestacados();
        registerForContextMenu(lstvDestacados);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.pedirLocalesDestacados();
    }

    @Override
    public void onLocalesObtenidos(ArrayList<Local> locales) {
        localesDestacados.clear();
        localesDestacados.addAll(locales);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Acciones sobre el local");
        getMenuInflater().inflate(R.menu.menu_contextual_borrar, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.mitm_borrar) {
            presenter.pedirBorrarLocal(localesDestacados.getItem(info.position));
        }
        return super.onContextItemSelected(item);
    }
}
