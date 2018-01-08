package com.example.showseverywhere.ui.amigos.vista;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.amigos.contrato.AmigosListaAsistenciasContrato;
import com.example.showseverywhere.ui.amigos.presenter.AmigosListaAsistenciasPresenter;

public class AmigosListaAsistencias extends Fragment implements AmigosListaAsistenciasContrato.Vista{
    private AmigosListaAsistenciasContrato.Presenter presenter;
    private AmigosListaAsistenciasListener callback;
    private RecyclerView rclrAmigosAsistencias;
    public static final String TAG = "AMIGOSLISTAASISTENCIAS";

    public interface AmigosListaAsistenciasListener{

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AmigosListaAsistenciasListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.getLocalClassName() + " debe implementar la interfaz necesaria (AmigosListaAsistenciasListener)");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_amigos_asistencias, container, false);

        rclrAmigosAsistencias = (RecyclerView) rootView.findViewById(R.id.rclrAmigosAsistencias);

        presenter = new AmigosListaAsistenciasPresenter(this);

        return rootView;
    }

    //Patrón factory
    public static AmigosListaAsistencias newInstance(@Nullable Bundle arguments) {
        AmigosListaAsistencias amigosListaAsistencias = new AmigosListaAsistencias();

        if (arguments != null) {
            amigosListaAsistencias.setArguments(arguments);
        }

        return amigosListaAsistencias;
    }
}
