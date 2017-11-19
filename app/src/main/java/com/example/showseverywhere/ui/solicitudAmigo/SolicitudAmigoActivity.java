package com.example.showseverywhere.ui.solicitudAmigo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.data.db.repository.ProvinciaRepository;
import com.example.showseverywhere.data.db.repository.UsuarioEstandarRepository;
import com.example.showseverywhere.ui.amigos.AmigosActivity;

import java.util.Collections;

public class SolicitudAmigoActivity extends AppCompatActivity {
    private EditText edtNombreAmigo;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_amigo);

        edtNombreAmigo = (EditText) findViewById(R.id.edtNombreAmigo);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!edtNombreAmigo.getText().toString().trim().isEmpty()) {
                        UsuarioEstandarRepository.getInstance().addUsuario(new UsuarioEstandar(edtNombreAmigo.getText().toString(), null, null, "1A2b3c", ProvinciaRepository.getInstance().getProvincias().get(0), "usuarioAñadido@gmail.com"));
                        Intent i = new Intent(SolicitudAmigoActivity.this, AmigosActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(SolicitudAmigoActivity.this, "Debe rellenar el campo del nick de su amigo", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}