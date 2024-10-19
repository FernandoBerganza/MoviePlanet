package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Mainreserva extends AppCompatActivity {

    private ArrayList<String> asientosSeleccionados = new ArrayList<>();
    private String selectedDate;
    private String selectedTime;
    private String totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        // Obtener datos de la actividad anterior
        Intent intent = getIntent();
        selectedDate = intent.getStringExtra("selectedDate");
        selectedTime = intent.getStringExtra("selectedTime");
        totalPrice = intent.getStringExtra("totalPrice");

        // Títulos
        TextView cineNombre = findViewById(R.id.textview_cine_nombre);
        TextView peliculaTitulo = findViewById(R.id.textview_pelicula_titulo);
        TextView textViewDate = findViewById(R.id.textview_fecha); // Asegúrate de tener este TextView en el layout
        TextView textViewTime = findViewById(R.id.textview_hora); // Asegúrate de tener este TextView en el layout
        TextView textViewTotalPrice = findViewById(R.id.textview_precio_total); // Asegúrate de tener este TextView en el layout

        // Mostrar la fecha, hora y precio total
        textViewDate.setText("Fecha: " + selectedDate);
        textViewTime.setText("Hora: " + selectedTime);
        textViewTotalPrice.setText("Total: " + totalPrice);

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
                        if (asientosSeleccionados.contains(asientoTexto)) {
                            asientosSeleccionados.remove(asientoTexto);
                            asiento.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                        } else {
                            asientosSeleccionados.add(asientoTexto);
                            asiento.setBackgroundTintList(getResources().getColorStateList(R.color.teal_700));
                        }
                    }
                });
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
                    StringBuilder seatStringBuilder = new StringBuilder();
                    for (String asiento : asientosSeleccionados) {
                        seatStringBuilder.append(asiento).append(", ");
                    }
                    if (seatStringBuilder.length() > 0) {
                        seatStringBuilder.setLength(seatStringBuilder.length() - 2);
                    }

                    // Redirigir a MainTicket
                    // En Mainreserva.java
                    // Dentro de Mainreserva, al crear el intent hacia Mainpaw
                    Intent intent = new Intent(Mainreserva.this, Mainpaw.class);
                    intent.putExtra("SEAT_INFO", seatStringBuilder.toString());
                    intent.putExtra("DATE_INFO", selectedDate);
                    intent.putExtra("TIME_INFO", selectedTime);

// Asegúrate de obtener el ticketQuantity del intent
                    int ticketQuantity = getIntent().getIntExtra("ticketQuantity", 0); // Valor por defecto 0
                    intent.putExtra("QUANTITY_INFO", String.valueOf(ticketQuantity)); // Pasar el valor correcto

// También pasa el totalPrice calculado en esta actividad
                    int amount = ticketQuantity * 25; // O el cálculo que estés usando
                    intent.putExtra("AMOUNT_INFO", String.valueOf(amount)); // Asegúrate de que esto sea variable

                    startActivity(intent);


                }
            }
        });
    }
}










