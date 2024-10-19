package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Mainboleto extends AppCompatActivity {

    private Spinner spinnerTicketType, spinnerTimeSelection;
    private EditText etTicketQuantity;
    private Button btnSelectDate, btnProceedPayment;
    private TextView tvTotalPrice;
    private String selectedDate, selectedTime;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleto);

        // Inicializar los componentes de la UI
        spinnerTicketType = findViewById(R.id.spinner_ticket_type);
        spinnerTimeSelection = findViewById(R.id.spinner_time_selection);
        etTicketQuantity = findViewById(R.id.et_ticket_quantity);
        btnSelectDate = findViewById(R.id.btn_select_date);
        btnProceedPayment = findViewById(R.id.btn_proceed_payment);
        tvTotalPrice = findViewById(R.id.tv_total_price);

        // Configurar adaptador personalizado para el Spinner de tipo de boleto
        ArrayAdapter<CharSequence> adapterTicketType = ArrayAdapter.createFromResource(
                this, R.array.ticket_type_limited, R.layout.spinner_item
        );
        adapterTicketType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTicketType.setAdapter(adapterTicketType);

        // Configurar adaptador personalizado para el Spinner de selección de hora
        ArrayAdapter<CharSequence> adapterTimeSelection = ArrayAdapter.createFromResource(
                this, R.array.time_options, R.layout.spinner_item
        );
        adapterTimeSelection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTimeSelection.setAdapter(adapterTimeSelection);

        // Escuchar cambios en la cantidad de boletos para actualizar el precio total
        etTicketQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calcularPrecioTotal();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Manejar la selección de la fecha
        btnSelectDate.setOnClickListener(v -> showDatePicker());

        // Manejar el clic en el botón "Proceder al Pago"
        btnProceedPayment.setOnClickListener(v -> proceedToPayment());
    }

    private void calcularPrecioTotal() {
        String quantityText = etTicketQuantity.getText().toString();
        if (!quantityText.isEmpty()) {
            int ticketQuantity = Integer.parseInt(quantityText);
            int ticketPrice;

            // Obtener el tipo de boleto seleccionado
            String selectedTicketType = spinnerTicketType.getSelectedItem().toString();

            // Asignar el precio según el tipo de boleto
            if (selectedTicketType.equals("Adulto")) {
                ticketPrice = 25;  // Precio para adultos
            } else if (selectedTicketType.equals("Niño")) {
                ticketPrice = 15;  // Precio para niños
            } else {
                ticketPrice = 0; // Valor predeterminado en caso de que no se seleccione
            }

            int totalPrice = ticketQuantity * ticketPrice;
            tvTotalPrice.setText("Q" + totalPrice + ".00");
        } else {
            tvTotalPrice.setText("Q0.00");
        }
    }

    // Método para mostrar el selector de fecha
    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                Mainboleto.this,
                (view, year1, month1, dayOfMonth) -> {
                    selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                    Toast.makeText(Mainboleto.this, "Fecha seleccionada: " + selectedDate, Toast.LENGTH_SHORT).show();
                },
                year, month, day);
        datePickerDialog.show();
    }

    // Método para proceder al pago
    private void proceedToPayment() {
        String quantityText = etTicketQuantity.getText().toString();

        // Validar que la cantidad de boletos no esté vacía
        if (quantityText.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la cantidad de boletos.", Toast.LENGTH_SHORT).show();
            return;
        }

        int ticketQuantity = Integer.parseInt(quantityText);

        // Validar que todos los campos estén llenos antes de proceder
        if (selectedDate == null) {
            Toast.makeText(this, "Por favor, seleccione una fecha.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Redireccionar a la pantalla de reserva
        Intent intent = new Intent(Mainboleto.this, Mainreserva.class);
        startActivity(intent);
    }
}




