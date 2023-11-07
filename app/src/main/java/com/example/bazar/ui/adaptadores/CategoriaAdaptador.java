package com.example.bazar.ui.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bazar.R;
import com.example.bazar.ui.activities.VisorImagen;

public class CategoriaAdaptador  extends BaseAdapter {
    private static LayoutInflater inflater =null;
    Context contexto;
    String [][] datos;
    int []datosImg;

    public CategoriaAdaptador(Context conexto, String[][]datos , int [] imagenes )
    {
        this.contexto= conexto;
        this.datos=datos;
        this.datosImg= imagenes;

        inflater=(LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);

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
        final View vista = inflater.inflate(R.layout.elemento_lista,null);

        TextView titulo = (TextView) vista.findViewById(R.id.tvTitulo);
       ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);
      // titulo.setText([i][0]);
       imagen.setImageResource(datosImg[i]);
        imagen.setTag(i);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });
    return vista;
    }

}

