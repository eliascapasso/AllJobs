package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.eliascapasso.alljobs.R;

public class RegistroActivity extends AppCompatActivity {
    private EditText et_nombreApellido;
    private EditText et_nombreUsuario;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private EditText et_codigoPostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializarAtributos();
    }

    private void inicializarAtributos(){
        et_nombreApellido = (EditText)findViewById(R.id.et_nombreApellido);
        et_nombreUsuario = (EditText)findViewById(R.id.et_nombreUsuario);
        et_email = (EditText)findViewById(R.id.et_email);
        et_pass = (EditText)findViewById(R.id.et_pass);
        et_nacimiento = (EditText)findViewById(R.id.et_nacimiento);
        et_codigoPostal = (EditText)findViewById(R.id.et_CP);
    }

    public void registrar(View view){
        String nombreApellido = et_nombreApellido.getText().toString();
        String nombreUsuario = et_nombreUsuario.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();
        String nacimiento = et_nacimiento.getText().toString();
        String CP = et_codigoPostal.getText().toString();

        if(nombreApellido.length() == 0){
            Toast.makeText(this, "Debe ingresar su nombre y apellido", Toast.LENGTH_SHORT).show();
        }
        else if(nombreUsuario.length() == 0){
            Toast.makeText(this, "Debe ingresar un nombre de usuario", Toast.LENGTH_SHORT).show();
        }
        else if(email.length() == 0){
            Toast.makeText(this, "Debe ingresar su email", Toast.LENGTH_SHORT).show();
        }
        else if(pass.length() == 0){
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
        }
        else if(nacimiento.length() == 0){
            Toast.makeText(this, "Debe ingresar su fecha de nacimiento", Toast.LENGTH_SHORT).show();
        }
        else if(CP.length() == 0){
            Toast.makeText(this, "Debe ingresar el código postál en donde resíde", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
    }
}
