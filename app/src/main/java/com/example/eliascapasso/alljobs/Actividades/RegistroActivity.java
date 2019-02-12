package com.example.eliascapasso.alljobs.Actividades;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.DAO.UsuarioRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Usuario;
import com.example.eliascapasso.alljobs.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_email;
    private EditText et_pass;
    private EditText et_nacimiento;
    private Button btnRegistrar;
    private ImageView btnFoto;
    private UsuarioRepositorio usuarioRepositorio;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_SAVE = 2;
    private static int idUsuarioNuevo = 1;
    private Usuario nuevoUsuario;

    private String pathFoto;

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
        btnFoto = (ImageView) findViewById(R.id.btnFoto);

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
                if (ContextCompat.checkSelfPermission(RegistroActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(RegistroActivity.this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {


                    if (ActivityCompat.shouldShowRequestPermissionRationale(RegistroActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    } else {
                        ActivityCompat.requestPermissions(RegistroActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                225);
                    }


                    if (ActivityCompat.shouldShowRequestPermissionRationale(RegistroActivity.this,
                            Manifest.permission.CAMERA)) {

                    } else {
                        ActivityCompat.requestPermissions(RegistroActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                226);
                    }
                } else {
                    sacarGuardarFoto();
                }
            }
        });
    }

    private File createImageFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                dir);

        pathFoto = image.getAbsolutePath();

        return image;
    }

    private void sacarGuardarFoto(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            try {
                photoFile = createImageFile();
            }catch (IOException ex){
                ex.printStackTrace();
            }

            if (photoFile != null){
                Uri photoURI = FileProvider.getUriForFile(RegistroActivity.this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
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
                nuevoUsuario = new Usuario(idUsuarioNuevo, apellido, nombre, email, pass, nacimiento);



                //Se almacena el nuevo usuario
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if((String.valueOf(pathFoto) != nuevoUsuario.getPathFoto()) && (String.valueOf(pathFoto) != null))
                                {
                                    File file = new File(String.valueOf(pathFoto));
                                    if(file.delete()) System.out.println("Foto borrada");
                                    else System.out.println("No se pudo borrar la foto");
                                }

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
            File file = new File(pathFoto);
            Bitmap imageBitmap = null;
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
            } catch (IOException e) {
                e.printStackTrace();
            }

            btnFoto.setImageBitmap(imageBitmap);
        }
    }
}
