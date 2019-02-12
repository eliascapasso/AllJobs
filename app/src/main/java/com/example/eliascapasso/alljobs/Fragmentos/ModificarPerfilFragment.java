package com.example.eliascapasso.alljobs.Fragmentos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.Actividades.LoginActivity;
import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

import java.io.File;

public class ModificarPerfilFragment extends Fragment {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private Button btnRegistrar;
    private ImageView ivFotoPerfil;

    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_registro, container, false);

        usuarioRepositorio = new UsuarioRepositorio(getContext());

        inicializarAtributos(v);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(view);
            }
        });
        return v;
    }

    public boolean registrar(View view){
        String nombre = et_nombre.getText().toString();
        String apellido = et_apellido.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();
        String nacimiento = et_nacimiento.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(getActivity(), "Debe ingresar su nombre", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(apellido.length() == 0){
            Toast.makeText(getActivity(), "Debe ingresar su apellido", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(email.length() == 0){
            Toast.makeText(getActivity(), "Debe ingresar su email", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(pass.length() == 0){
            Toast.makeText(getActivity(), "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(nacimiento.length() == 0){
            Toast.makeText(getActivity(), "Debe ingresar su fecha de nacimiento", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            //Se modifica el usuario
            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setFechaNacieminto(nacimiento);
            usuario.setPass(pass);

            usuarioRepositorio.modificarUsuario(usuario);

            Toast.makeText(getActivity(), "Modificación exitosa", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void inicializarAtributos(View v) {
        et_nombre = (EditText) v.findViewById(R.id.txtNombre);
        et_apellido = (EditText) v.findViewById(R.id.txtApellido);
        et_email = (EditText) v.findViewById(R.id.txtEmail);
        et_pass = (EditText) v.findViewById(R.id.txtPass);
        et_nacimiento = (EditText) v.findViewById(R.id.txtFechaNacimiento);
        btnRegistrar = (Button) v.findViewById(R.id.btnRegistro);
        ivFotoPerfil = (ImageView) v.findViewById(R.id.btnFoto);

        String emailUsuario = LoginActivity.obtenerLoginSharedPreferencesString(getContext(), "email");

        usuario = usuarioRepositorio.obtenerUsuario(emailUsuario);

        if(usuario != null){
            File imgFile = new  File(usuario.getPathFoto());

            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                ivFotoPerfil.setImageBitmap(myBitmap);
            }

            et_nombre.setText(usuario.getNombre());
            et_apellido.setText(usuario.getApellido());
            et_email.setText(usuario.getEmail());
            et_nacimiento.setText(usuario.getFechaNacieminto());
            et_pass.setText(usuario.getPass());
        }
    }
}
