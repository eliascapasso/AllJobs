package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.eliascapasso.alljobs.R;

public class LoginActivity extends AppCompatActivity {
    private EditText et_email, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarAtributos();
    }

    private void inicializarAtributos(){
        et_email = (EditText)findViewById(R.id.txtEmail);
        et_pass = (EditText)findViewById(R.id.txtPass);
    }

    //metodo para el boton iniciar sesion
    public void iniciarSesion(View view){
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        //Validacion de la entrada
        if(email.length() == 0){
            Toast.makeText(this, "Debe ingresar un Email", Toast.LENGTH_SHORT).show();
        }
        else if(pass.length() == 0){
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent oficios = new Intent(this, MainActivity.class);
            startActivity(oficios);
        }
    }

    //metodo para el boton CREA UNA CUENTA
    public void registrar(View view){
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
}
