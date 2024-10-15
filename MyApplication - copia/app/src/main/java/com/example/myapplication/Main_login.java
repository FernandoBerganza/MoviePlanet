package com.example.myapplication; // Cambia esto por el nombre de tu paquete real

import android.content.Intent; // Asegúrate de importar Intent
import android.os.Bundle;
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
        setContentView(R.layout.activity_login); // Asegúrate de que el nombre del archivo XML sea correcto

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

        // Verificar si el campo de usuario y contraseña está vacío
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            // Verificar si el usuario es "Moviesplanet" y la contraseña es "1234"
            if (usuario.equals("Moviesplanet") && contrasena.equals("1234")) {
                // Redirigir a MainGestor si las credenciales son correctas
                Intent intent = new Intent(Main_login.this, MainGestor.class); // Asegúrate de que MainGestor es correcto
                startActivity(intent);
                finish(); // Finaliza Main_login si no deseas volver a él
            } else {
                // Redirigir a MainActivity en cualquier otro caso
                Intent intent = new Intent(Main_login.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza Main_login si no deseas volver a él
            }
        }
    }

    private void restablecerContrasena() {
        // Redirigir a RestablecerContrasenaActivity en lugar de mostrar un mensaje
        Intent intent = new Intent(Main_login.this, RestablecerContrasenaActivity.class);
        startActivity(intent);
    }
}




