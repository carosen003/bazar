package com.example.bazar.ui.activities;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Producto;

import com.example.bazar.ui.utils.LogUtils;
import com.example.bazar.ui.utils.RequestCode;

import java.util.ArrayList;
import java.util.List;

import com.example.bazar.R;
import com.example.bazar.ui.adaptadores.SlidePagerAdaptor;
import com.example.bazar.ui.fragments.PageFragment1;
import com.example.bazar.ui.fragments.PageFragment2;
import com.example.bazar.ui.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class verMisProductos extends AppCompatActivity {
    private int idProducto = 0;
    private Producto unProducto;
    private TextView nombre;
    private TextView categoria;
    private TextView marca;
    private TextView precio;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LogUtils.tag, "Inicia metodo en VerDatosProductoActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mis_productos);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idProducto = extras.getInt("idProducto", -1);
            Log.d(LogUtils.tag, "Id recibido del producto: " + idProducto);
        }

        actualizarVista();
        ///////////////////////////////////////////////
        Log.d(LogUtils.tag, "Inicia metodo en Carrrusel de imagenes .onCreate");

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());


        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdaptor(getSupportFragmentManager(), list);

        //pagerAdapter.getClass();
        // pagerAdapter.setAdapter(pagerAdapter);
        pager.setAdapter(pagerAdapter);
    }

    public void actualizarVista() {
        if (idProducto < 0 || idProducto > (Producto.productos.size() - 1)) {
            desplegarMensajeNoExisteProducto();
            finish();
            return;
        }

        unProducto = Producto.productos.get(idProducto);

        nombre = (TextView) findViewById(R.id.id_nombre_producto_valor);
        nombre.setText(unProducto.getNombre());

        categoria = (TextView) findViewById(R.id.id_categoria_producto_valor);
        categoria.setText(unProducto.getCategoria());

        precio = (TextView) findViewById(R.id.id_precio_producto_valor);
        precio.setText(unProducto.getPrecio());

        marca = (TextView) findViewById(R.id.id_marca_producto_valor);
        marca.setText(unProducto.getMarca());
    }


    private void siguienteProducto() {
        if (idProducto == Producto.productos.size() - 1) {
            Toast.makeText(getApplicationContext(), "Ya no existen productos en la lista",
                            Toast.LENGTH_SHORT)
                    .show();
            return;

        }

        idProducto++;
        actualizarVista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ver_producto_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editar_producto:
                lanzarActividadEdicionProducto();
                break;
            case R.id.eliminar_producto:
                Producto.productos.remove(idProducto);
                desplegarMensajeEliminacionProducto();
                finish();
            case R.id.siguiente_producto:
                siguienteProducto();
                break;
        }
        return true;
    }

    private void lanzarActividadEdicionProducto() {
        Intent i = new Intent(this, VenderActivity.class);
        i.putExtra("idProducto", idProducto);
        startActivityForResult(i, RequestCode.PETICION_EDITAR_PRODUCTO.getCodigo());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dato) {
        super.onActivityResult(requestCode, resultCode, dato);
        if (requestCode == RequestCode.PETICION_EDITAR_PRODUCTO.getCodigo()) {
            if (resultCode == RESULT_OK) {
                Bundle extras = dato.getExtras();
                int resultado = extras.getInt("resultado", -1);
                if (resultado == 1) {
                    desplegarMensajeEdicioProductoExitoso();
                    actualizarVista();
                }
            }
        }
    }

    public void desplegarMensajeEliminacionProducto() {
        Toast toast = Toast.makeText(this, "El producto fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioProductoExitoso() {
        Toast toast = Toast.makeText(this, "Los datos del producto fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteProducto() {
        Toast toast = Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT);
        toast.show();
    }




}
