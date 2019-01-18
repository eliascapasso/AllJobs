package com.example.eliascapasso.alljobs.Actividades;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

import java.io.File;
import java.io.IOException;

public class RegistroActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private Button btnRegistrar;
    private ImageButton btnFoto;
    private UsuarioRepositorio usuarioRepositorio;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_SAVE = 2;
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
        btnFoto = (ImageButton) findViewById(R.id.btnFoto);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(registrar(view)){
                    Intent login = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(login);
                }
            }
        });

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    public boolean registrar(View view){
        final String nombre = et_nombre.getText().toString();
        final String apellido = et_apellido.getText().toString();
        final String email = et_email.getText().toString();
        final String pass = et_pass.getText().toString();
        final String nacimiento = et_nacimiento.getText().toString();

        boolean emailExistente = false;

        for(Usuario u: usuarioRepositorio.listarUsuarios()){
            if(email.equals(u.getEmail())){
                emailExistente = true;
                Toast.makeText(this, "Email ya registrado", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if(!emailExistente){
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
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            btnFoto.setImageBitmap(imageBitmap);
        }
    }
}
