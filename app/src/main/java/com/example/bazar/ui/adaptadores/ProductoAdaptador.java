package com.example.bazar.ui.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Producto;

import java.util.ArrayList;

public class ProductoAdaptador extends BaseAdapter {

    private final Activity actividad;
    private final ArrayList<Producto> lista;

    public ProductoAdaptador(Activity actividad, ArrayList<Producto> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        if (lista != null) {
            return lista.get(arg0);
        }
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        Producto unProducto = lista.get(arg0);
        return 1;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elemento_productos, null, true);

        Producto unProducto = lista.get(posicion);

        TextView nombreProducto = view.findViewById(R.id.tv_nombre_producto);
        nombreProducto.setText(unProducto.getNombre());
        TextView precio = view.findViewById(R.id.tv_precio_producto);
        precio.setText("" + unProducto.getPrecio());

        return view;
    }
}