package com.example.bazar.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Producto;

import com.ui.bazar.utils.LogUtils;

public class verMisProductos extends Activity {
    private int idProducto = 0;
    private Producto unProducto;
    private TextView nombre;
    private TextView categoria;

    private TextView marca;
    private TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LogUtils.tag, "Inicia metodo en VerDatosProductoActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mis_productos);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idProducto = extras.getInt("idGrupo", -1);
            Log.d(LogUtils.tag, "Id recibido del grupo: "+idProducto);
        }

        actualizarVista();
    }

    public void actualizarVista(){

        unProducto = Producto.productos.get( idProducto);

        nombre = (TextView) findViewById(R.id.id_nombre_grupo_valor);
        nombre.setText(unProducto.getNombre());

        categoria = (TextView) findViewById(R.id.id_categoria_grupo_valor);
        categoria.setText(unProducto.getCategoria());

        precio = (TextView) findViewById(R.id.id_precio_grupo_valor);
        precio.setText(unProducto.getPrecio());

        marca = (TextView) findViewById(R.id.id_marca_grupo_valor);
        marca.setText(unProducto.getMarca());

    }


}
