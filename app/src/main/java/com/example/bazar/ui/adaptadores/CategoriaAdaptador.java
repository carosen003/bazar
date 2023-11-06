package com.example.bazar.ui.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bazar.R;

public class CategoriaAdaptador  extends BaseAdapter {
    private static LayoutInflater inflater =null;
    Context contexto;
    String [][] datos;
    int [][]datosImg;

    public CategoriaAdaptador(Context conexto, String[][]datos , int [] imagenes )
    {
        this.contexto= contexto;
        this.datos=datos;
        this.datosImg= new int[][]{imagenes};

        inflater=(LayoutInflater) conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_list_view,null);

        TextView titulo = (TextView) vista.findViewById(tv_nombre_categoria);
        titulo.setText([i][0]);
    }

}

