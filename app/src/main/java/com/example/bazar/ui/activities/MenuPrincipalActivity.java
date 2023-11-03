package com.example.bazar.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;

public class MenuPrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }
    public void lanzarCreacionProducto(View view) {
        Intent intentCreacionGrupo = new Intent( this, VenderActivity.class);
        startActivity( intentCreacionGrupo );
    }

    public void lanzarVerMisProdcutos(View view) {
        final EditText entrada = new EditText(this);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de grupo")
                .setMessage("Indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        int id = Integer.parseInt(entrada.getText().toString());
                        Intent i = new Intent(MenuPrincipalActivity.this, verMisProductos.class);
                        i.putExtra("idGrupo", id);
                        startActivity(i);
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }

}
