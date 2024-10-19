package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaración de los elementos
    private EditText campoUsuario;
    private EditText campoContrasena;
    private Button btnIniciarSesion;
    private TextView txtRestablecerContrasena;
    private TextView Texview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los elementos con sus IDs
        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        txtRestablecerContrasena = findViewById(R.id.txtRestablecerContrasena);
        Texview = findViewById(R.id.Texview);





        // Agregar funcionalidad al botón de Iniciar Sesión
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = campoUsuario.getText().toString();
                String contrasena = campoContrasena.getText().toString();

                // Verificar que los campos no estén vacíos
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí puedes implementar la lógica de autenticación
                    // Por ahora, solo mostrar un mensaje de éxito
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Agregar funcionalidad al texto de "Restablecer contraseña"
        txtRestablecerContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para restablecer la contraseña
                // Por ejemplo, redirigir a otra actividad o mostrar un mensaje
                Toast.makeText(MainActivity.this, "Funcionalidad de restablecer contraseña no implementada", Toast.LENGTH_SHORT).show();
            }
        });

        Texview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para restablecer la contraseña
                // Por ejemplo, redirigir a otra actividad o mostrar un mensaje
                Toast.makeText(MainActivity.this, "Funcionalidad de restablecer contraseña no implementada", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
