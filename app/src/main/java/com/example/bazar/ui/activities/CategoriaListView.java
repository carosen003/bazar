package com.example.bazar.ui.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;
import com.example.bazar.ui.adaptadores.CategoriaAdaptador;

public class CategoriaListView extends AppCompatActivity {
    ListView lista ;

    String[][] datos ={
            {"ROPA"},
            {"CALZADOS"},
            {"ACCESORIOS"},
    };
    int[]datosImg ={R.drawable.prendas,R.drawable.calzados,R.drawable.accesorio};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_comprar);
        lista = (ListView) findViewById(R.id.lv_lista);
        lista.setAdapter(new CategoriaAdaptador(this, datos, datosImg));
    }




}
