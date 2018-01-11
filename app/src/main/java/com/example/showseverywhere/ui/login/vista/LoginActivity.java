package com.example.showseverywhere.ui.login.vista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.contrasenaolvidada.ContrasenaOlvidadaActivity;
import com.example.showseverywhere.ui.dashboard.DashboardActivity;
import com.example.showseverywhere.ui.login.contrato.LoginContrato;
import com.example.showseverywhere.ui.login.presenter.LoginPresenter;
import com.example.showseverywhere.ui.utils.others.Preferencias;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContrato.Vista {
    private Button btnAcceder;
    private TextView txvRegistrar;
    private TextView txvOlvidoContrasena;
    private EditText edtUsuario;
    private EditText edtContrasena;
    private CheckBox chbxRecordarUsuario;
    private SharedPreferences preferences;

    private LoginContrato.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        preferences = getPreferences(MODE_PRIVATE);

        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        btnAcceder.setOnClickListener(this);
        txvRegistrar = (TextView) findViewById(R.id.txvRegistrar);
        txvRegistrar.setOnClickListener(this);
        txvOlvidoContrasena = (TextView) findViewById(R.id.txvOlvidoContrasena);
        txvOlvidoContrasena.setOnClickListener(this);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtContrasena = (EditText) findViewById(R.id.edtContrasena);
        chbxRecordarUsuario = (CheckBox) findViewById(R.id.chbxRecordarUsuario);
        chbxRecordarUsuario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(Preferencias.RECORDAR_USUARIO, b);
                editor.commit();
            }
        });

        chbxRecordarUsuario.setChecked(preferences.getBoolean(Preferencias.RECORDAR_USUARIO, false));

        if (chbxRecordarUsuario.isChecked())
            recordarUsuario();

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnAcceder:
                presenter.pedirVerificarCredenciales(edtUsuario.getText().toString(), edtContrasena.getText().toString());
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

    private void recordarUsuario() {
        edtUsuario.setText(preferences.getString(Preferencias.USUARIO_RECORDADO, ""));
        edtContrasena.setText(preferences.getString(Preferencias.CONTRASENA_RECORDADA, ""));
    }

    @Override
    public void onCredencialesCorrectas() {
        //Si las credenciales son correctas, ademas de acceder, si esta marcado el recordar usuario, se
        //recuerda el usuario y la contraseña.
        if (chbxRecordarUsuario.isChecked()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Preferencias.USUARIO_RECORDADO, edtUsuario.getText().toString());
            editor.putString(Preferencias.CONTRASENA_RECORDADA, edtContrasena.getText().toString());
            editor.commit();
        }
        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(i);
    }

    @Override
    public void mostrarToastUsuarioVacio() {
        Toast.makeText(this, getResources().getText(R.string.error_usuario_vacio), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarToastContrasenaVacia() {
        Toast.makeText(this, getResources().getText(R.string.error_contrasena_vacia), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarToastCredencialesIncorrectas() {
        Toast.makeText(this, getResources().getText(R.string.error_credenciales_incorrectos), Toast.LENGTH_SHORT).show();
    }
}
