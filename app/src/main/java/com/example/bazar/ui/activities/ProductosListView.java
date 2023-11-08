package com.example.bazar.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;
import com.example.bazar.ui.adaptadores.ProductoAdaptador;
import com.example.bazar.ui.datos.Producto;

public class ProductosListView extends AppCompatActivity {
    String TAG = "ProductosListView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_producto);


        // : 1. obtener el ListView
        ListView listView = findViewById(R.id.lv_productos);

        // : 2. crear el objeto GrupoAdaptador
        ProductoAdaptador adaptador = new ProductoAdaptador(this, Producto.productos);
        // : 3. establecer el adaptador al listView
        listView.setAdapter(adaptador);
        // : 4. establecer el item click listener del listView donde se lance la actividad
        //          VerDatosGrupoActivity cuando se presiona un item de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Log.i(TAG,"itemClick Producto:" + posicion);
                Intent intent = new Intent(ProductosListView.this , verMisProductos.class);
                intent.putExtra("idProducto",posicion);
                startActivity(intent);
            }
        });
    }
}