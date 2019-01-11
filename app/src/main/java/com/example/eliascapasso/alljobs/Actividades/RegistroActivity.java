package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

public class RegistroActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private Button btnRegistrar;
    private UsuarioRepositorio usuarioRepositorio;
    private static int idUsuarioNuevo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioRepositorio = new UsuarioRepositorio(getApplicationContext());

        inicializarAtributos();
    }

    private void inicializarAtributos(){
        et_nombre = (EditText)findViewById(R.id.txtNombre);
        et_apellido = (EditText)findViewById(R.id.txtApellido);
        et_email = (EditText)findViewById(R.id.txtEmail);
        et_pass = (EditText)findViewById(R.id.txtPass);
        et_nacimiento = (EditText)findViewById(R.id.txtFechaNacimiento);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(view);
                Intent login = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }

    public boolean registrar(View view){
        final String nombre = et_nombre.getText().toString();
        final String apellido = et_apellido.getText().toString();
        final String email = et_email.getText().toString();
        final String pass = et_pass.getText().toString();
        final String nacimiento = et_nacimiento.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this, "Debe ingresar su nombre", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(apellido.length() == 0){
            Toast.makeText(this, "Debe ingresar su apellido", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(email.length() == 0){
            Toast.makeText(this, "Debe ingresar su email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(pass.length() == 0){
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(nacimiento.length() == 0){
            Toast.makeText(this, "Debe ingresar su fecha de nacimiento", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            //Se almacena el nuevo usuario
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Usuario nuevoUsuario = new Usuario(idUsuarioNuevo, apellido, nombre, email, pass, nacimiento);
                            usuarioRepositorio.crearUsuario(nuevoUsuario);
                        }
                    });
                }
            };
            Thread unHilo = new Thread(r);
            unHilo.start();

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
        return true;
    }
}
