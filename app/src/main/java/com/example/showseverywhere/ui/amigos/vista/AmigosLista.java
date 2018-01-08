package com.example.showseverywhere.ui.amigos.vista;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.showseverywhere.R;
import com.example.showseverywhere.adapter.AmigosAdapter;
import com.example.showseverywhere.data.db.model.UsuarioEstandar;
import com.example.showseverywhere.ui.amigos.contrato.AmigosListaContrato;
import com.example.showseverywhere.ui.amigos.presenter.AmigosListaPresenter;

import java.io.Serializable;
import java.util.List;

public class AmigosLista extends Fragment implements AmigosListaContrato.Vista{

    private AmigosListaListener callback;
    private AmigosAdapter adapter;
    private RecyclerView rclrAmigos;
    private AmigosListaContrato.Presenter presenter;
    public static final String TAG = "AMIGOSLISTA";
    private FloatingActionButton fab;

    public interface AmigosListaListener {

    }

    //En mi onAttach conseguimos la actividad de la que proviene.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AmigosListaListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.getLocalClassName() + " debe implementar la interfaz necesaria (AmigosListaListener)");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_amigos, container, false);

        presenter = new AmigosListaPresenter(this);

        adapter = new AmigosAdapter();

        rclrAmigos = (RecyclerView) rootView.findViewById(R.id.rclrAmigos);
        rclrAmigos.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        rclrAmigos.setAdapter(adapter);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SolicitudAmigoActivity.class);
                startActivityForResult(i, 0);
            }
        });

        presenter.pedirListaAmigos();

        return rootView;
    }

    //Patrón factory
    public static AmigosLista newInstance(@Nullable Bundle arguments) {
        AmigosLista amigosLista = new AmigosLista();

        if (arguments != null) {
            amigosLista.setArguments(arguments);
        }

        return amigosLista;
    }

    @Override
    public void onExito(List<UsuarioEstandar> amigos) {
        adapter.limpiarLista();
        adapter.cargarDatos(amigos);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.pedirListaAmigos();
            }
        }
    }
}
