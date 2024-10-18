package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Mainreserva extends AppCompatActivity {

    // Lista para almacenar los asientos seleccionados
    private ArrayList<String> asientosSeleccionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        // Títulos
        TextView cineNombre = findViewById(R.id.textview_cine_nombre);
        TextView peliculaTitulo = findViewById(R.id.textview_pelicula_titulo);

        // GridLayout para los asientos
        GridLayout gridLayout = findViewById(R.id.gridlayout_asientos);

        // Crear botones de asientos dinámicamente
        String[] filas = {"A", "B", "C", "D", "E"};
        for (String fila : filas) {
            for (int numero = 1; numero <= 8; numero++) {
                String asientoTexto = fila + numero;
                Button asiento = new Button(this);
                asiento.setText(asientoTexto);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 0;
                params.height = GridLayout.LayoutParams.WRAP_CONTENT;
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
                asiento.setLayoutParams(params);
                asiento.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                asiento.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
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
                // Agregar el botón al GridLayout
                gridLayout.addView(asiento);
            }
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
                    Intent intent = new Intent(Mainreserva.this, Mainpaw.class);
                    startActivity(intent);
                }
            }
        });
    }
}






