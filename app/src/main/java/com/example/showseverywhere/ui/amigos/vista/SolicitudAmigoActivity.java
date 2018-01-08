package com.example.showseverywhere.ui.amigos.vista;

import android.app.Activity;
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
import com.example.showseverywhere.ui.amigos.contrato.SolicitudAmigoContrato;
import com.example.showseverywhere.ui.amigos.presenter.SolicitudAmigoPresenter;

public class SolicitudAmigoActivity extends AppCompatActivity implements SolicitudAmigoContrato.Vista {
    private EditText edtNombreAmigo;
    private FloatingActionButton fab;
    private SolicitudAmigoContrato.Presenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_amigo);

        presenter = new SolicitudAmigoPresenter(this);

        edtNombreAmigo = (EditText) findViewById(R.id.edtNombreAmigo);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtNombreAmigo.getText().toString().trim().isEmpty()) {
                    presenter.pedirAnadirAmigo(new UsuarioEstandar(edtNombreAmigo.getText().toString(), null, null, "1a2D3V", ProvinciaRepository.getInstance().getProvincias().get(0), "carslsldkk@gmail.com"));
                } else {
                    Toast.makeText(SolicitudAmigoActivity.this, "Debe rellenar el campo del nick de su amigo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onExito() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}