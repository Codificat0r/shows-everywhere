package com.example.showseverywhere.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.showseverywhere.R;
import com.example.showseverywhere.ui.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAcceder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        btnAcceder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnAcceder:
                i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);
                break;
        }
    }
}
