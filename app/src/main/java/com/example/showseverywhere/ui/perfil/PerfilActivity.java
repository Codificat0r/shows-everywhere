package com.example.showseverywhere.ui.perfil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.ComentariosPerfilAdapter;
import com.example.showseverywhere.data.db.model.Artista;
import com.example.showseverywhere.data.db.repository.ArtistaRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

public class PerfilActivity extends AppCompatActivity {
    private MaterialLetterIcon icon;
    private ImageView imgvFotoFondo;
    private TextView txvNumeroSeguidores;
    private TextView txvNombreUsuarioYArtistico;
    private TextView txvTipoArtistaProvincia;
    private TextView txvDescripcion;
    private TextView txvTelefono;
    private TextView txvOrganizacion;
    private TextView txvDescripcionHabilidades;
    private ListView lstvComentarios;
    private ComentariosPerfilAdapter comentariosPerfilAdapter;
    private Artista artista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        comentariosPerfilAdapter = new ComentariosPerfilAdapter(this);
        artista = ArtistaRepository.getInstance().getArtistas().get(1);

        icon = (MaterialLetterIcon) findViewById(R.id.icon);
        imgvFotoFondo = (ImageView) findViewById(R.id.imgvFotoFondo);
        txvNumeroSeguidores = (TextView) findViewById(R.id.txvNumeroSeguidores);
        txvNombreUsuarioYArtistico = (TextView) findViewById(R.id.txvNombreUsuarioYArtistico);
        txvTipoArtistaProvincia = (TextView) findViewById(R.id.txvTipoArtistaProvincia);
        txvDescripcion = (TextView) findViewById(R.id.txvDescripcion);
        txvTelefono = (TextView) findViewById(R.id.txvTelefono);
        txvOrganizacion = (TextView) findViewById(R.id.txvOrganizacion);
        txvDescripcionHabilidades = (TextView) findViewById(R.id.txvDescripcionHabilidades);
        lstvComentarios = (ListView) findViewById(R.id.lstvComentarios);

        lstvComentarios.setAdapter(comentariosPerfilAdapter);

        icon.setLetter(artista.getNombre().substring(0,1));
        imgvFotoFondo.setImageResource(R.drawable.landscape2);
        txvNumeroSeguidores.setText("5");
        txvNombreUsuarioYArtistico.setText(artista.getNombre() + " " + artista.getApellido() + ", " + artista.getNombre_artistico());
        txvTipoArtistaProvincia.setText(artista.getTipo() + ", " + artista.getProvincia().getProvincia());
        txvDescripcion.setText(artista.getDescripcion());
        txvTelefono.setText(artista.getTelefono());
        txvOrganizacion.setText(artista.getOrganizacion());
        txvDescripcionHabilidades.setText(artista.getHabilidades());
    }
}
