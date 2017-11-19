package com.example.showseverywhere.ui.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ScrollView;

import com.example.showseverywhere.R;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbtnUsuarioEstandar;
    private RadioButton rbtnArtista;
    private RadioButton rbtnPropietario;
    private ScrollView scrlvUsuarioEstandar;
    private ScrollView scrlvArtista;
    private ScrollView scrlvPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        rbtnUsuarioEstandar = (RadioButton) findViewById(R.id.rbtnUsuarioEstandar);
        rbtnUsuarioEstandar.setOnClickListener(this);
        rbtnArtista = (RadioButton) findViewById(R.id.rbtnArtista);
        rbtnArtista.setOnClickListener(this);
        rbtnPropietario = (RadioButton) findViewById(R.id.rbtnPropietario);
        rbtnPropietario.setOnClickListener(this);
        scrlvUsuarioEstandar = (ScrollView) findViewById(R.id.scrlvUsuarioEstandar);
        scrlvArtista = (ScrollView) findViewById(R.id.scrlvArtista);
        scrlvPropietario = (ScrollView) findViewById(R.id.scrlvPropietario);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbtnUsuarioEstandar:
                scrlvArtista.setVisibility(View.GONE);
                scrlvPropietario.setVisibility(View.GONE);
                scrlvUsuarioEstandar.setVisibility(View.VISIBLE);
                break;
            case R.id.rbtnArtista:
                scrlvUsuarioEstandar.setVisibility(View.GONE);
                scrlvPropietario.setVisibility(View.GONE);
                scrlvArtista.setVisibility(View.VISIBLE);
                break;
            case R.id.rbtnPropietario:
                scrlvUsuarioEstandar.setVisibility(View.GONE);
                scrlvArtista.setVisibility(View.GONE);
                scrlvPropietario.setVisibility(View.VISIBLE);
                break;
        }
    }
}
