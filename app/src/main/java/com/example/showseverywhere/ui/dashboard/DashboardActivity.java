package com.example.showseverywhere.ui.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.about.AboutMeActivity;
import com.example.showseverywhere.ui.amigos.vista.AmigosActivity;
import com.example.showseverywhere.ui.busqueda.BusquedaActivity;
import com.example.showseverywhere.ui.destacados.DestacadosActivity;
import com.example.showseverywhere.ui.favoritos.FavoritosActivity;
import com.example.showseverywhere.ui.perfil.PerfilActivity;
import com.example.showseverywhere.ui.proximas.ActuacionesProximasActivity;

public class DashboardActivity extends AppCompatActivity {
    private GridLayout grdDashboard;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        grdDashboard = (GridLayout) findViewById(R.id.grdDashboardRoot);
        int[] imagenes = {R.drawable.ic_profile, R.drawable.ic_favourite, R.drawable.ic_friends, R.drawable.ic_search, R.drawable.ic_toprated, R.drawable.ic_closeevents};;
        llenarGrid(imagenes);
    }

    public void llenarGrid(int[] imagenes) {
        ImageView img;
        GridLayout.LayoutParams params;
        DashboardClickListener dashboardListener;
        float height;
        float width;
        height = getResources().getDimension(R.dimen.imgDashboardHeight);
        width = getResources().getDimension(R.dimen.imgDashboardWidth);
        dashboardListener = new DashboardClickListener();

        for (int i = 0; i < imagenes.length; i++) {
            img = new ImageView(this);
            img.setId(imagenes[i]);
            img.setImageResource(imagenes[i]);
            //Creamos las especificaciones del grid
            params = new GridLayout.LayoutParams();
            params.height = (int) height;
            params.width = (int) width;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            //Las añadimos al grid y tambien le establecemos las especificaciones
            img.setLayoutParams(params);
            img.setOnClickListener(dashboardListener);
            grdDashboard.addView(img);
        }
    }

    class DashboardClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i;
            switch (v.getId()) {
                case R.drawable.ic_profile:
                    i = new Intent(DashboardActivity.this, PerfilActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_friends:
                    i = new Intent(DashboardActivity.this, AmigosActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_favourite:
                    i = new Intent(DashboardActivity.this, FavoritosActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_search:
                    i = new Intent(DashboardActivity.this, BusquedaActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_toprated:
                    i = new Intent(DashboardActivity.this, DestacadosActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_closeevents:
                    i = new Intent(DashboardActivity.this, ActuacionesProximasActivity.class);
                    startActivity(i);
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.mnuiAboutMe:
                i = new Intent(DashboardActivity.this, AboutMeActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
