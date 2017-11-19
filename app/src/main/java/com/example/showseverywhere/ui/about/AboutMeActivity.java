package com.example.showseverywhere.ui.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.showseverywhere.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.landscape2)
                .setDescription("Soy un programador dedicado, y con muchas ganas para todo.")
                .addGroup("Conecta conmigo")
                .addEmail("carloscruzdomiguez@gmail.com")
                .addWebsite("https://codificat0r.github.io/")
                .addFacebook("aniloracrami.anilora")
                .addGitHub("codificat0r")
                .create();

        setContentView(aboutPage);
    }
}
