package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

public class LoginActivity extends AppCompatActivity {
    private EditText et_email, et_pass;
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioRepositorio = new UsuarioRepositorio(getApplicationContext());

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
            //Se chequea que el mail y contraseñas ingresados esten registrados
            for(Usuario u: usuarioRepositorio.listarUsuarios()){
                if(u.getEmail().equals(email) && u.getPass().equals(pass)){
                    Intent mainActivity = new Intent(this, MainActivity.class);
                    startActivity(mainActivity);
                }
                else{
                    Toast.makeText(this, "No existe registrado el usuario ingresado o la contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //metodo para el boton CREA UNA CUENTA
    public void registrar(View view){
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
}
