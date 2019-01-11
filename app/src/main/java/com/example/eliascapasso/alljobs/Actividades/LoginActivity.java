package com.example.eliascapasso.alljobs.Actividades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

public class LoginActivity extends AppCompatActivity {
    private EditText et_email, et_pass;
    private CheckBox chkRecordarEmailPass;
    private UsuarioRepositorio usuarioRepositorio;
    private static String PREFS_KEY = "login_preferences";

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
        chkRecordarEmailPass = (CheckBox) findViewById(R.id.chkRecordarEmailPass);

        et_email.setText(obtenerLoginSharedPreferencesString(getApplicationContext(),"email"));
        et_pass.setText(obtenerLoginSharedPreferencesString(getApplicationContext(),"pass"));
        chkRecordarEmailPass.setChecked(obtenerLoginSharedPreferencesBool(getApplicationContext(), "recordar"));
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
            boolean existeUsuario = false;
            if(usuarioRepositorio.listarUsuarios().size() != 0){
                for(Usuario u: usuarioRepositorio.listarUsuarios()){
                    if(u.getEmail().equals(email) && u.getPass().equals(pass)){

                        //Preferencias compartidas
                        if(chkRecordarEmailPass.isChecked()){
                            guardarLoginSharedPreferences(email, pass);
                        }
                        else{
                            guardarLoginSharedPreferences("", "");
                        }

                        //Se pasa a la otra actividad
                        Intent mainActivity = new Intent(this, MainActivity.class);
                        startActivity(mainActivity);

                        existeUsuario = true;
                    }
                }
            }

            if(!existeUsuario){
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void guardarLoginSharedPreferences(String email, String pass) {
        SharedPreferences sharedPref = getSharedPreferences("login_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", email);
        editor.putString("pass", pass);

        if(email.equals("") && pass.equals("")){
            editor.putBoolean("recordar", false);
        }
        else{
            editor.putBoolean("recordar", true);
        }

        editor.apply();
        editor.commit();
    }

    public static String obtenerLoginSharedPreferencesString(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }

    public static boolean obtenerLoginSharedPreferencesBool(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getBoolean(keyPref, false);
    }

    //metodo para el boton CREA UNA CUENTA
    public void registrar(View view){
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
}
