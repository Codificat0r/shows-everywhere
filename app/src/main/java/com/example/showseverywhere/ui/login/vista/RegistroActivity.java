package com.example.showseverywhere.ui.login.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.dashboard.DashboardActivity;
import com.example.showseverywhere.ui.login.contrato.RegistroContrato;
import com.example.showseverywhere.ui.login.presenter.RegistroPresenter;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener, RegistroContrato.Vista {
    private RadioButton rbtnUsuarioEstandar;
    private RadioButton rbtnArtista;
    private RadioButton rbtnPropietario;
    private ScrollView scrlvUsuarioEstandar;
    private ScrollView scrlvArtista;
    private ScrollView scrlvPropietario;
    private Spinner spnrProvincia;
    private Spinner spnrProvinciaArtistas;
    private Spinner spnrProvinciaPropietario;

    //Usuario Estándar
    private Button btnRegistrarme;
    private EditText edtUsuario;
    private EditText edtContrasena;
    private EditText edtEmail;

    private ArrayAdapter<String> spinnerAdapter;

    private ArrayList<String> provincias;

    private RegistroContrato.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        presenter = new RegistroPresenter(this);

        rbtnUsuarioEstandar = (RadioButton) findViewById(R.id.rbtnUsuarioEstandar);
        rbtnUsuarioEstandar.setOnClickListener(this);
        rbtnArtista = (RadioButton) findViewById(R.id.rbtnArtista);
        rbtnArtista.setOnClickListener(this);
        rbtnPropietario = (RadioButton) findViewById(R.id.rbtnPropietario);
        rbtnPropietario.setOnClickListener(this);
        scrlvUsuarioEstandar = (ScrollView) findViewById(R.id.scrlvUsuarioEstandar);
        scrlvArtista = (ScrollView) findViewById(R.id.scrlvArtista);
        scrlvPropietario = (ScrollView) findViewById(R.id.scrlvPropietario);
        spnrProvincia = (Spinner) findViewById(R.id.spnrProvincia);
        spnrProvinciaArtistas = (Spinner) findViewById(R.id.spnrProvinciaArtista);
        spnrProvinciaPropietario = (Spinner) findViewById(R.id.spnrProvinciaPropietario);

        //Usuario estándar
        btnRegistrarme = (Button) findViewById(R.id.btnRegistrarme);
        btnRegistrarme.setOnClickListener(this);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtContrasena = (EditText) findViewById(R.id.edtContrasena);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        presenter.pedirProvincias();
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
            case R.id.btnRegistrarme:
                presenter.pedirVerificarDatosRegistroUsuarioEstandar(edtUsuario.getText().toString(), edtContrasena.getText().toString(), edtEmail.getText().toString(), (String)spnrProvincia.getSelectedItem());
                break;
        }
    }

    @Override
    public void onProvinciasObtenidas(ArrayList<String> provincias) {
        this.provincias = provincias;
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, this.provincias);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrProvincia.setAdapter(spinnerAdapter);
        spnrProvinciaArtistas.setAdapter(spinnerAdapter);
        spnrProvinciaPropietario.setAdapter(spinnerAdapter);
    }

    @Override
    public void mostrarCampoObligatorioVacío() {
        Toast.makeText(this, getResources().getText(R.string.error_campo_obligatorio_vacio), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExitoRegistro() {
        Toast.makeText(this, getResources().getText(R.string.exito_registro), Toast.LENGTH_SHORT).show();
        finish();
        Intent i = new Intent(RegistroActivity.this, DashboardActivity.class);
        startActivity(i);
    }

    @Override
    public void mostrarEmailMalFormado() {
        Toast.makeText(this, getResources().getText(R.string.error_email_mal_formado), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarContrasenaMalFormada() {
        Toast.makeText(this, getResources().getText(R.string.error_contrasena_mal_formada), Toast.LENGTH_SHORT).show();
    }
}
