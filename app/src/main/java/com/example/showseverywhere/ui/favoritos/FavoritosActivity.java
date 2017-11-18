package com.example.showseverywhere.ui.favoritos;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ArtistasFavoritosAdapter;
import com.example.showseverywhere.adapter.ArtistasFavoritosProximasActuacionesAdapter;

public class FavoritosActivity extends AppCompatActivity {
    private RecyclerView rclrFavoritos;
    private RecyclerView rclrActuacionesProximas;
    private Toolbar toolbar;
    private TabLayout tabs;
    private GridLayoutManager gridLayoutManager;
    private GridLayoutManager gridLayoutManager2;
    private ArtistasFavoritosAdapter artistasFavoritosAdapter;
    private ArtistasFavoritosProximasActuacionesAdapter artistasFavoritosProximasActuacionesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        gridLayoutManager = new GridLayoutManager(this, 2, 1, false);
        gridLayoutManager2 = new GridLayoutManager(this, 2, 1, false);

        artistasFavoritosAdapter = new ArtistasFavoritosAdapter();
        artistasFavoritosProximasActuacionesAdapter = new ArtistasFavoritosProximasActuacionesAdapter();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);

        rclrFavoritos = (RecyclerView) findViewById(R.id.rclrFavoritos);
        rclrActuacionesProximas = (RecyclerView) findViewById(R.id.rclrActuacionesProximas);
        rclrFavoritos.setLayoutManager(gridLayoutManager);
        rclrActuacionesProximas.setLayoutManager(gridLayoutManager2);
        rclrFavoritos.setAdapter(artistasFavoritosAdapter);
        rclrActuacionesProximas.setAdapter(artistasFavoritosProximasActuacionesAdapter);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    rclrActuacionesProximas.setVisibility(View.GONE);
                    rclrFavoritos.setVisibility(View.VISIBLE);
                } else if (tab.getPosition() == 1) {
                    rclrFavoritos.setVisibility(View.GONE);
                    rclrActuacionesProximas.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
