package com.example.bazar.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Producto;
import com.example.bazar.ui.datos.Usuario;

public class VenderActivity extends AppCompatActivity {
    private EditText campoNombre;
    private EditText campoCategoria;
    private EditText campoMarca;
    private EditText campoPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender);

        campoNombre = (EditText) findViewById(R.id.vender_nombre);
        campoCategoria = (EditText) findViewById(R.id.vender_categoria);
        campoMarca = (EditText) findViewById(R.id.vender_marca);
        campoPrecio = (EditText) findViewById(R.id.vender_precio);


    }

    public void crearProducto(View view) {


        Producto producto = new Producto(campoNombre.getText().toString(),
                campoCategoria.getText().toString(), campoMarca.getText().toString(), campoPrecio.getText().toString(), Usuario.getUsuarioLogueado());
        Producto.agregarProducto(producto);
        String TAG = null;
        Log.i(TAG, "Se creó el producto ");
        Intent intent = new Intent();
        intent.putExtra("resultado", 10);
        setResult(RESULT_OK, intent);
        finish();

    }


}
