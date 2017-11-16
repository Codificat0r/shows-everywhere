package com.example.showseverywhere.ui.destacados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ArtistasDestacadosAdapter;
import com.example.showseverywhere.adapter.LocalesDestacadosAdapter;

public class DestacadosActivity extends AppCompatActivity {

    private ListView lstvDestacados;
    private Toolbar toolbar;
    private LocalesDestacadosAdapter localesDestacados;
    private ArtistasDestacadosAdapter artistasDestacados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destacados);

        localesDestacados = new LocalesDestacadosAdapter(this);
        artistasDestacados = new ArtistasDestacadosAdapter(this);

        lstvDestacados = (ListView) findViewById(R.id.lstvDestacados);
        lstvDestacados.setAdapter(localesDestacados);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Locales destacados");
        setSupportActionBar(toolbar);
    }
}
