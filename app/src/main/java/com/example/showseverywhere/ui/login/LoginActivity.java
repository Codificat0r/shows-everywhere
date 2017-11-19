package com.example.showseverywhere.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.repository.ProvinciaRepository;
import com.example.showseverywhere.ui.contrasenaolvidada.ContrasenaOlvidadaActivity;
import com.example.showseverywhere.ui.dashboard.DashboardActivity;
import com.example.showseverywhere.ui.registro.RegistroActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAcceder;
    private TextView txvRegistrar;
    private TextView txvOlvidoContrasena;
    private Spinner spnrProvincia;
    private Spinner spnrProvinciaArtistas;
    private Spinner spnrProvinciaPropietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        btnAcceder.setOnClickListener(this);
        txvRegistrar = (TextView) findViewById(R.id.txvRegistrar);
        txvRegistrar.setOnClickListener(this);
        txvOlvidoContrasena = (TextView) findViewById(R.id.txvOlvidoContrasena);
        txvOlvidoContrasena.setOnClickListener(this);
        spnrProvincia = (Spinner) findViewById(R.id.spnrProvincia);
        spnrProvinciaArtistas = (Spinner) findViewById(R.id.spnrProvinciaArtista);
        spnrProvinciaPropietario = (Spinner) findViewById(R.id.spnrProvinciaPropietario);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnAcceder:
                i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);
                break;
            case R.id.txvRegistrar:
                i = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(i);
                break;
            case R.id.txvOlvidoContrasena:
                i = new Intent(LoginActivity.this, ContrasenaOlvidadaActivity.class);
                startActivity(i);
                break;
        }
    }
}
