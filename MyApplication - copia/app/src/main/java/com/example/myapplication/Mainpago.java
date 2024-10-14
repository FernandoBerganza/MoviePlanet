package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Mainpago extends AppCompatActivity {

    private EditText etNumeroTarjeta, etFechaVencimiento, etCVV, etNombreTitular;
    private RadioGroup rgTipoTarjeta;
    private Button btnRealizarPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago); // Asegúrate de que el nombre del archivo XML sea correcto

        // Inicializar vistas
        etNumeroTarjeta = findViewById(R.id.et_numero_tarjeta);
        etFechaVencimiento = findViewById(R.id.et_fecha_vencimiento);
        etCVV = findViewById(R.id.et_cvv);
        etNombreTitular = findViewById(R.id.et_nombre_titular);
        rgTipoTarjeta = findViewById(R.id.rg_tipo_tarjeta);
        btnRealizarPago = findViewById(R.id.btn_realizar_pago);

        // Acción al presionar el botón de realizar pago
        btnRealizarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarPago();
            }
        });
    }

    private void realizarPago() {
        // Obtener valores ingresados
        String numeroTarjeta = etNumeroTarjeta.getText().toString().trim();
        String fechaVencimiento = etFechaVencimiento.getText().toString().trim();
        String cvv = etCVV.getText().toString().trim();
        String nombreTitular = etNombreTitular.getText().toString().trim();

        // Obtener tipo de tarjeta seleccionado
        RadioButton rbSeleccionado = findViewById(rgTipoTarjeta.getCheckedRadioButtonId());
        String tipoTarjeta = rbSeleccionado.getText().toString();

        // Validación básica
        if (numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || cvv.isEmpty() || nombreTitular.isEmpty()) {
            Toast.makeText(Mainpago.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Aquí agregar lógica para realizar el pago
        Toast.makeText(Mainpago.this, "Pago realizado con " + tipoTarjeta, Toast.LENGTH_SHORT).show();
    }
}

