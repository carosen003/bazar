package com.example.bazar.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;

public class VisorImagen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

    ImageView img =(ImageView) findViewById(R.id.ivImagenCompleta) ;

    Intent intent = getIntent();
    Bundle b = intent.getExtras();

    if(b!=null){
        img.setImageResource(b.getInt("IMG"));
    }
    }

}

