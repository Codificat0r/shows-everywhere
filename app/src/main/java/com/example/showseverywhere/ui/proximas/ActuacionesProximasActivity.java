package com.example.showseverywhere.ui.proximas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ActuacionesProximasAdapter;

public class ActuacionesProximasActivity extends AppCompatActivity {

    private RecyclerView rclrActuacionesProximas;
    private Toolbar toolbar;
    private ActuacionesProximasAdapter actuacionesProximasAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actuaciones_proximas);

        actuacionesProximasAdapter = new ActuacionesProximasAdapter();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rclrActuacionesProximas = (RecyclerView) findViewById(R.id.rclrActuacionesProximas);
        rclrActuacionesProximas.setLayoutManager(linearLayoutManager);
        rclrActuacionesProximas.setAdapter(actuacionesProximasAdapter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


}
