package com.example.eliascapasso.alljobs.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.eliascapasso.alljobs.R;

public class RegistroActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

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
                //TODO: implementar

                registrar(view);
                Intent login = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }

    public boolean registrar(View view){
        String nombre = et_nombre.getText().toString();
        String apellido = et_apellido.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();
        String nacimiento = et_nacimiento.getText().toString();

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
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
        return true;
    }
}
