package com.example.showseverywhere.ui.actuacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Actuacion;
import com.example.showseverywhere.data.db.repository.ActuacionRepository;

import java.util.ArrayList;

public class ActuacionActivity extends AppCompatActivity {

    private Actuacion actuacion;
    private TextView txvFecha;
    private TextView txvFechaInfo;
    private TextView txvArtistaGrupo;
    private TextView txvArtistaGrupoInfo;
    private TextView txvLocal;
    private TextView txvLocalInfo;
    private TextView txvHoraComienzo;
    private TextView txvHoraComienzoInfo;
    private TextView txvHoraFin;
    private TextView txvHoraFinInfo;
    private TextView txvDescripcion;
    private EditText edtDescripcionInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actuacion);

        actuacion = ActuacionRepository.getInstance().getActuaciones().get(0);

        txvFecha = (TextView) findViewById(R.id.txvFecha);
        txvFechaInfo = (TextView) findViewById(R.id.txvFechaInfo);
        txvArtistaGrupo = (TextView) findViewById(R.id.txvArtistaGrupo);
        txvArtistaGrupoInfo = (TextView) findViewById(R.id.txvArtistaGrupoInfo);
        txvLocal = (TextView) findViewById(R.id.txvLocal);
        txvLocalInfo = (TextView) findViewById(R.id.txvLocalInfo);
        txvHoraComienzo = (TextView) findViewById(R.id.txvHoraComienzo);
        txvHoraComienzoInfo = (TextView) findViewById(R.id.txvHoraComienzoInfo);
        txvHoraFin = (TextView) findViewById(R.id.txvHoraFin);
        txvHoraFinInfo = (TextView) findViewById(R.id.txvHoraFinInfo);
        txvDescripcion = (TextView) findViewById(R.id.txvDescripcion);
        edtDescripcionInfo = (EditText) findViewById(R.id.edtDescripcionInfo);

        txvFechaInfo.setText(actuacion.getFecha().toString().substring(0,10));
        txvArtistaGrupoInfo.setText(actuacion.getArtista().getNombre() + " " + actuacion.getArtista().getApellido());
        txvLocalInfo.setText(actuacion.getLocal().getNombre());
        txvHoraComienzoInfo.setText(actuacion.getHora_desde());
        txvHoraFinInfo.setText(actuacion.getHora_hasta());
        edtDescripcionInfo.setText(actuacion.getDescripcion());
    }
}
