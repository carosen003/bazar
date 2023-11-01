package com.example.bazar.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bazar.R;

public class inicioActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_inicio);
    }

    public void lanzarCrearCuenta(View view) {
        Intent intentCrearCuenta = new Intent( this, CrearCuentaActivity.class );
        startActivity( intentCrearCuenta );
    }}
