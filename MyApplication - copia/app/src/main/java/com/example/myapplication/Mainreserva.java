package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Mainreserva extends AppCompatActivity {

    // Lista para almacenar los asientos seleccionados
    private ArrayList<String> asientosSeleccionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        // Lista de IDs de botones de asientos
        int[] asientosIds = {
                R.id.button_asiento_A1, R.id.button_asiento_A2, R.id.button_asiento_A3, R.id.button_asiento_A4,
                R.id.button_asiento_A5, R.id.button_asiento_A6, R.id.button_asiento_A7, R.id.button_asiento_A8,
                R.id.button_asiento_B1, R.id.button_asiento_B2, R.id.button_asiento_B3, R.id.button_asiento_B4,
                R.id.button_asiento_B5, R.id.button_asiento_B6, R.id.button_asiento_B7, R.id.button_asiento_B8,
                R.id.button_asiento_C1, R.id.button_asiento_C2, R.id.button_asiento_C3, R.id.button_asiento_C4,
                R.id.button_asiento_C5, R.id.button_asiento_C6, R.id.button_asiento_C7, R.id.button_asiento_C8,
                R.id.button_asiento_D1, R.id.button_asiento_D2, R.id.button_asiento_D3, R.id.button_asiento_D4,
                R.id.button_asiento_D5, R.id.button_asiento_D6, R.id.button_asiento_D7, R.id.button_asiento_D8,
                R.id.button_asiento_E1, R.id.button_asiento_E2, R.id.button_asiento_E3, R.id.button_asiento_E4,
                R.id.button_asiento_E5, R.id.button_asiento_E6, R.id.button_asiento_E7, R.id.button_asiento_E8
        };

        // Asignar listeners a los botones de los asientos
        for (int id : asientosIds) {
            Button asiento = findViewById(id);
            asiento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String asientoTexto = asiento.getText().toString();

                    // Cambiar el color del botón y agregar o quitar de la lista de seleccionados
                    if (asientosSeleccionados.contains(asientoTexto)) {
                        asientosSeleccionados.remove(asientoTexto);
                        asiento.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                    } else {
                        asientosSeleccionados.add(asientoTexto);
                        asiento.setBackgroundTintList(getResources().getColorStateList(R.color.teal_700));
                    }
                }
            });
        }

        // Botón de Reservar Asientos
        Button botonReservar = findViewById(R.id.button_reservar);
        botonReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (asientosSeleccionados.isEmpty()) {
                    Toast.makeText(Mainreserva.this, "No has seleccionado ningún asiento", Toast.LENGTH_SHORT).show();
                } else {
                    String mensaje = "Asientos seleccionados: " + asientosSeleccionados.toString();
                    Toast.makeText(Mainreserva.this, mensaje, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}







