package com.example.showseverywhere.ui.destacados.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.destacados.contrato.AnadirDestacadoContrato;
import com.example.showseverywhere.ui.destacados.presenter.AnadirDestacadoPresenter;

public class AnadirDestacadoActivity extends AppCompatActivity implements AnadirDestacadoContrato.Vista {

    private AnadirDestacadoContrato.Presenter presenter;
    private EditText edtNombreLocal;
    private EditText edtPuntuacion;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_destacado);

        presenter = new AnadirDestacadoPresenter(this);

        edtNombreLocal = (EditText) findViewById(R.id.edtNombreLocal);
        edtPuntuacion = (EditText) findViewById(R.id.edtPuntuacion);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pedirAnadirLocalDestacado(edtNombreLocal.getText().toString(), edtPuntuacion.getText().toString());
            }
        });
    }

    @Override
    public void mostrarPuntuacionVacia() {
        Toast.makeText(this, "La puntuación no puede estar vacía", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarNombreVacio() {
        Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocalAnadido() {
        finish();
    }
}
