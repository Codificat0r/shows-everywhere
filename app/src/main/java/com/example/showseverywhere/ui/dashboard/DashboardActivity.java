package com.example.showseverywhere.ui.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.busqueda.BusquedaActivity;

public class DashboardActivity extends AppCompatActivity {

    private GridLayout grdDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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

                    break;
                case R.drawable.ic_friends:

                    break;
                case R.drawable.ic_favourite:

                    break;
                case R.drawable.ic_search:
                    i = new Intent(DashboardActivity.this, BusquedaActivity.class);
                    startActivity(i);
                    break;
                case R.drawable.ic_toprated:

                    break;
                case R.drawable.ic_closeevents:

                    break;
            }
        }
    }
}
