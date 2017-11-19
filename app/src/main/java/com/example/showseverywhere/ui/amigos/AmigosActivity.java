package com.example.showseverywhere.ui.amigos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.adapter.AmigosAsistenciasAdapter;
import com.example.showseverywhere.ui.solicitudAmigo.SolicitudAmigoActivity;

public class AmigosActivity extends AppCompatActivity{
    private RecyclerView rclrAmigos;
    private RecyclerView rclrAsistencias;
    private Toolbar toolbar;
    private TabLayout tabs;
    private AmigosAdapter amigosAdapter;
    private AmigosAsistenciasAdapter amigosAsistenciasAdapter;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        gridLayoutManager = new GridLayoutManager(this, 2,1,false);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        amigosAdapter = new AmigosAdapter();
        amigosAsistenciasAdapter = new AmigosAsistenciasAdapter();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        rclrAmigos = (RecyclerView) findViewById(R.id.rclrAmigos);
        rclrAsistencias = (RecyclerView) findViewById(R.id.rclrAsistencias);
        rclrAmigos.setLayoutManager(gridLayoutManager);
        rclrAsistencias.setLayoutManager(linearLayoutManager);
        rclrAmigos.setAdapter(amigosAdapter);
        rclrAsistencias.setAdapter(amigosAsistenciasAdapter);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    rclrAsistencias.setVisibility(View.GONE);
                    rclrAmigos.setVisibility(View.VISIBLE);
                } else if (tab.getPosition() == 1) {
                    rclrAmigos.setVisibility(View.GONE);
                    rclrAsistencias.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                return;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                return;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AmigosActivity.this, SolicitudAmigoActivity.class);
                startActivity(i);
            }
        });
    }
}
