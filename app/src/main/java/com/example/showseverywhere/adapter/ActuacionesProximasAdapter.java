package com.example.showseverywhere.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.showseverywhere.R;
import com.example.showseverywhere.data.db.model.Actuacion;
import com.example.showseverywhere.data.db.repository.ActuacionRepository;
import com.example.showseverywhere.ui.actuacion.ActuacionActivity;

import java.util.ArrayList;

/**
 * Created by carlos on 17/11/2017.
 */

public class ActuacionesProximasAdapter extends RecyclerView.Adapter<ActuacionesProximasAdapter.ActuacionesProximasViewHolder>{
    private ArrayList<Actuacion> actuaciones;
    ButtonsOnClickListener buttonsOnClickListener;

    public ActuacionesProximasAdapter() {
        actuaciones = ActuacionRepository.getInstance().getActuaciones();
        buttonsOnClickListener = new ButtonsOnClickListener();
    }



    @Override
    public ActuacionesProximasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_actuacion_proxima, null);
        ActuacionesProximasViewHolder actuacionesProximasViewHolder = new ActuacionesProximasViewHolder(view);
        return actuacionesProximasViewHolder;
    }

    @Override
    public void onBindViewHolder(ActuacionesProximasViewHolder holder, int position) {
        holder.txvFecha.setText(actuaciones.get(position).getFecha().toString().substring(0,10));
        holder.txvNombreLocal.setText(actuaciones.get(position).getLocal().getNombre());
        holder.txvDireccionLocal.setText(actuaciones.get(position).getLocal().getDireccion());
        holder.txvArtista.setText(actuaciones.get(position).getArtista().getNombre() + " " + actuaciones.get(position).getArtista().getApellido());
        holder.txvTipoArtista.setText(actuaciones.get(position).getArtista().getTipo());
        //OnClickListener de los buttons
        holder.btnNoAsistir.setOnClickListener(buttonsOnClickListener);
        holder.btnAsistir.setOnClickListener(buttonsOnClickListener);
        holder.btnDetalles.setOnClickListener(buttonsOnClickListener);
    }

    @Override
    public int getItemCount() {
        return actuaciones.size();
    }

    public static class ActuacionesProximasViewHolder extends RecyclerView.ViewHolder {
        private TextView txvNombreLocal;
        private TextView txvDireccionLocal;
        private TextView txvFecha;
        private TextView txvArtista;
        private TextView txvTipoArtista;
        private Button btnNoAsistir;
        private Button btnAsistir;
        private Button btnDetalles;
        private static Context context;

        public ActuacionesProximasViewHolder(View itemView) {
            super(itemView);
            txvNombreLocal = (TextView) itemView.findViewById(R.id.txvNombreLocal);
            txvDireccionLocal = (TextView) itemView.findViewById(R.id.txvDireccionLocal);
            txvFecha = (TextView) itemView.findViewById(R.id.txvFecha);
            txvArtista = (TextView) itemView.findViewById(R.id.txvArtista);
            txvTipoArtista = (TextView) itemView.findViewById(R.id.txvTipoArtistaProvincia);
            btnNoAsistir = (Button) itemView.findViewById(R.id.btnNoAsistir);
            btnAsistir = (Button) itemView.findViewById(R.id.btnAsistir);
            btnDetalles = (Button) itemView.findViewById(R.id.btnDetalles);
            context = itemView.getContext();
        }
    }

    class ButtonsOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i;
            switch (v.getId()) {
                case R.id.btnNoAsistir:
                    Toast.makeText(((View)v.getParent()).getContext(), "Has indicado que no vas a asistir a esta actuación.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnAsistir:
                    Toast.makeText(((View)v.getParent()).getContext(), "Has indicado que vas a asistir a esta actuación.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnDetalles:
                    i = new Intent(((View)v.getParent()).getContext(), ActuacionActivity.class);
                    ActuacionesProximasViewHolder.context.startActivity(i);
                    break;
            }
        }
    }
}
