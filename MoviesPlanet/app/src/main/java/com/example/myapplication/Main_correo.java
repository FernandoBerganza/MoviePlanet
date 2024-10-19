package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Main_correo extends AppCompatActivity {

    private TextInputEditText inputNombre;
    private TextInputEditText inputCorreo;
    private TextInputEditText inputTelefono;
    private TextInputEditText inputPassword;
    private MaterialButton btnRegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);

        inputNombre = findViewById(R.id.inputNombre);
        inputCorreo = findViewById(R.id.inputCorreo);
        inputTelefono = findViewById(R.id.inputTelefono);
        inputPassword = findViewById(R.id.inputPassword);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
    }

    private void crearUsuario() {
        String nombre = inputNombre.getText().toString().trim();
        String correo = inputCorreo.getText().toString().trim();
        String telefono = inputTelefono.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        boolean isValid = true;

        if (TextUtils.isEmpty(nombre)) {
            inputNombre.setError("Por favor, ingrese su nombre.");
            isValid = false;
        }
        if (TextUtils.isEmpty(correo)) {
            inputCorreo.setError("Por favor, ingrese su correo.");
            isValid = false;
        }
        if (TextUtils.isEmpty(telefono)) {
            inputTelefono.setError("Por favor, ingrese su teléfono.");
            isValid = false;
        }
        if (TextUtils.isEmpty(password)) {
            inputPassword.setError("Por favor, ingrese su contraseña.");
            isValid = false;
        }

        if (isValid) {
            // Aquí puedes agregar la lógica para registrar al usuario en tu base de datos
            Toast.makeText(this, "Usuario creado con éxito.", Toast.LENGTH_SHORT).show();
            // Redireccionar a Main_login
            Intent intent = new Intent(Main_correo.this, Main_login.class);
            startActivity(intent);
            finish(); // Opcional: cerrar la actividad actual
        }
    }
}


