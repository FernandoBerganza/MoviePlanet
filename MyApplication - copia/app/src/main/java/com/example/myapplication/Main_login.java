package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Main_login extends AppCompatActivity {

    private EditText campoUsuario;
    private EditText campoContrasena;
    private Button btnIniciarSesion;
    private TextView txtRestablecerContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        txtRestablecerContrasena = findViewById(R.id.txtRestablecerContrasena);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        txtRestablecerContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restablecerContrasena();
            }
        });
    }

    private void iniciarSesion() {
        String usuario = campoUsuario.getText().toString().trim();
        String contrasena = campoContrasena.getText().toString().trim();

        // Validar correo y contraseña
        if (!validarCorreo(usuario)) {
            Toast.makeText(this, "Por favor, ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!validarContrasena(contrasena)) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar credenciales
        if (usuario.equals("staff@moviesplanet.com") && contrasena.equals("123456")) {
            // Redirigir a MainGestor si las credenciales son correctas
            Intent intent = new Intent(Main_login.this, MainGestor.class);
            startActivity(intent);
            finish();
        } else {
            // Redirigir a MainActivity en cualquier otro caso
            Intent intent = new Intent(Main_login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean validarCorreo(String email) {
        // Verifica si el campo de correo electrónico está vacío o no tiene un formato válido
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validarContrasena(String contrasena) {
        // Verifica si la contraseña tiene al menos 6 caracteres
        return contrasena.length() >= 6;
    }

    private void restablecerContrasena() {
        // Redirigir a la actividad de restablecimiento de contraseña
        Intent intent = new Intent(Main_login.this, RestablecerContrasenaActivity.class);
        startActivity(intent);
    }
}


