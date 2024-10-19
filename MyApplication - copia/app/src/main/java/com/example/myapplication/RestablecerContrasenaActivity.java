package com.example.myapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RestablecerContrasenaActivity extends AppCompatActivity {

    private TextInputEditText campoNombre, campoEmail, campoCodigo, campoNuevaContrasena, campoConfirmarContrasena;
    private TextInputLayout tilNombre, tilEmail, tilCodigo, tilNuevaContrasena, tilConfirmarContrasena;
    private MaterialButton btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasena);

        // Inicialización de vistas
        initializeViews();

        // Configuración del botón para restablecer contraseña
        btnResetPassword.setOnClickListener(v -> resetPassword());
    }

    private void initializeViews() {
        // Vinculamos los TextInputEditText con sus IDs del layout XML
        campoNombre = findViewById(R.id.campoNombre);
        campoEmail = findViewById(R.id.campoEmail);
        campoCodigo = findViewById(R.id.campoCodigo);
        campoNuevaContrasena = findViewById(R.id.campoNuevaContrasena);
        campoConfirmarContrasena = findViewById(R.id.campoConfirmarContrasena);

        // Vinculamos los TextInputLayout con sus IDs del layout XML
        tilNombre = findViewById(R.id.tilNombre);
        tilEmail = findViewById(R.id.tilEmail);
        tilCodigo = findViewById(R.id.tilCodigo);
        tilNuevaContrasena = findViewById(R.id.tilNuevaContrasena);
        tilConfirmarContrasena = findViewById(R.id.tilConfirmarContrasena);

        // Vinculamos el botón con su ID del layout XML
        btnResetPassword = findViewById(R.id.btnResetPassword);
    }

    private void resetPassword() {
        if (!validateInputs()) {
            return; // Si la validación falla, no continúa.
        }

        // Obtiene los valores de los campos
        String nombre = campoNombre.getText().toString().trim();
        String email = campoEmail.getText().toString().trim();
        String codigo = campoCodigo.getText().toString().trim();
        String nuevaContrasena = campoNuevaContrasena.getText().toString();

        // Simulación de restablecimiento de contraseña
        resetPasswordOnServer(nombre, email, codigo, nuevaContrasena);
    }

    private boolean validateInputs() {
        boolean isValid = true;

        // Validación del campo nombre
        if (campoNombre.getText().toString().trim().isEmpty()) {
            tilNombre.setError("El nombre es requerido");
            isValid = false;
        } else {
            tilNombre.setError(null);
        }

        // Validación del campo email
        if (campoEmail.getText().toString().trim().isEmpty()) {
            tilEmail.setError("El email es requerido");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(campoEmail.getText().toString().trim()).matches()) {
            tilEmail.setError("Email inválido");
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        // Validación del campo código
        if (campoCodigo.getText().toString().trim().isEmpty()) {
            tilCodigo.setError("El código es requerido");
            isValid = false;
        } else {
            tilCodigo.setError(null);
        }

        // Validación de la nueva contraseña
        String nuevaContrasena = campoNuevaContrasena.getText().toString();
        String confirmarContrasena = campoConfirmarContrasena.getText().toString();

        if (nuevaContrasena.isEmpty()) {
            tilNuevaContrasena.setError("La nueva contraseña es requerida");
            isValid = false;
        } else if (nuevaContrasena.length() < 8) {
            tilNuevaContrasena.setError("La contraseña debe tener al menos 8 caracteres");
            isValid = false;
        } else {
            tilNuevaContrasena.setError(null);
        }

        // Validación de confirmación de contraseña
        if (confirmarContrasena.isEmpty()) {
            tilConfirmarContrasena.setError("Debe confirmar la contraseña");
            isValid = false;
        } else if (!nuevaContrasena.equals(confirmarContrasena)) {
            tilConfirmarContrasena.setError("Las contraseñas no coinciden");
            isValid = false;
        } else {
            tilConfirmarContrasena.setError(null);
        }

        return isValid;
    }

    private void resetPasswordOnServer(String nombre, String email, String codigo, String nuevaContrasena) {
        // Aquí iría la lógica para restablecer la contraseña en el servidor
        // Por ejemplo, enviar una solicitud API al servidor usando Retrofit o Volley

        // Mostramos un mensaje de éxito por ahora
        Toast.makeText(this, "Solicitud de restablecimiento de contraseña enviada", Toast.LENGTH_LONG).show();

        // Podrías redirigir al usuario a la pantalla de inicio de sesión
        // finish();
    }
}
