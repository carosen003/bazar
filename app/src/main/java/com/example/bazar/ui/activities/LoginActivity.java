package com.example.bazar.ui.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bazar.R;
import com.example.bazar.ui.datos.Usuario;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText campoNombreUsuario;
    private EditText campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_login);
        campoNombreUsuario = (EditText) findViewById(R.id.email_login);
        campoPassword = (EditText) findViewById(R.id.contrasenia_login);
    }

    public void iniciarSesion(View view) {
        String email = campoNombreUsuario.getText().toString();
        String password = campoPassword.getText().toString();
        Log.i(TAG, "'" + email + "'" + password);


        boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

        if (estaComprobado) {
            Context context = getApplicationContext();
            CharSequence text = "Las credenciales son correctas";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            setUsuarioLogueado();
            Intent intentMenuPricipal = new Intent(this, MenuPrincipalActivity.class);
            startActivity(intentMenuPricipal);
        } else if (email.equals("") && password.equals("")) {
            desplegarMensajeCamposVacios();
        } else {

            desplegarMensajeCredencialesIncorrectas();

        }
    }

    public void desplegarMensajeCredencialesIncorrectas() {
        Context context = getApplicationContext();
        CharSequence text = "Las credenciales son incorrectas";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void desplegarMensajeCamposVacios() {
        final EditText entrada = new EditText(this);
        AlertDialog builder = new AlertDialog.Builder(this)
                .setTitle("Credenciales Incorrectas")
                .setMessage("Debe indicar usuario y contraseña:")
                .setView(entrada)
                .setPositiveButton("Ok", null).show();
        //  .show();
    }


    private void setUsuarioLogueado() {
        String email = campoNombreUsuario.getText().toString();
        Usuario.setUsuarioLogueado(Usuario.getUsuario(email));
    }


}