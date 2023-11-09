package com.example.bazar.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Producto;
import com.example.bazar.ui.datos.Usuario;

public class VenderActivity extends AppCompatActivity {
    private EditText campoNombre;
    private EditText campoCategoria;
    private EditText campoMarca;
    private EditText campoPrecio;
    private int idProducto = -1;
    private boolean modoEdicion = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender);

        campoNombre = (EditText) findViewById(R.id.vender_nombre);
        campoCategoria = (EditText) findViewById(R.id.vender_categoria);
        campoMarca = (EditText) findViewById(R.id.vender_marca);
        campoPrecio = (EditText) findViewById(R.id.vender_precio);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idProducto = extras.getInt("idProducto", -1);
            if (idProducto != -1) {
                modoEdicion = true;
                campoNombre.setText(Producto.productos.get(idProducto).getNombre());
                campoCategoria.setText(Producto.productos.get(idProducto).getCategoria());
                campoMarca.setText(Producto.productos.get(idProducto).getMarca());
                campoPrecio.setText(Producto.productos.get(idProducto).getPrecio());
            }
        }


    }

    public void crearProducto(View view) {


        String nombre = campoNombre.getText().toString();
        String categoria = campoCategoria.getText().toString();
        String marca = campoMarca.getText().toString();
        String precio = campoPrecio.getText().toString();


        if (nombre.equals("") || categoria.equals("") || marca.equals("") || precio.equals("")) {
            desplegarMensajeCamposRequeridos();
        } else {
            if (modoEdicion) {
                Producto producto = Producto.productos.get(idProducto);
                producto.setNombre(nombre);
                producto.setCategoria(categoria);
                producto.setMarca(marca);
                producto.setPrecio(precio);

                Intent intent = new Intent();
                intent.putExtra("resultado", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Producto producto = new Producto(nombre, categoria, marca, precio, Usuario.getUsuarioLogueado());
                Producto.agregarProducto(producto);
                desplegarMensajeResgistroExitoso();

                Intent intent = new Intent();
                intent.putExtra("resultado", 10);
                setResult(RESULT_OK, intent);
                finish();
            }
        }

    }

    public void limpiarCampo() {
        campoNombre.setText("");
        campoCategoria.setText("");
        campoMarca.setText("");
        campoPrecio.setText("");

    }


    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void desplegarMensajeHome() {
        Toast toast = Toast.makeText(this, "Ir al menu principal", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crear_producto_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.guardar_producto:
                crearProducto(findViewById(R.id.guardar_producto));
                break;
            case R.id.limpiar_producto:
                limpiarCampo();
                finish();
            case R.id.ir_menuprincipal:
                Intent intentMenuPrincipal = new Intent(this, MenuPrincipalActivity.class);
                startActivity(intentMenuPrincipal);
                desplegarMensajeHome();
        }
        return true;

    }

}
