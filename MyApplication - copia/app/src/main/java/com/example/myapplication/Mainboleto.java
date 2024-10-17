package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Mainboleto extends AppCompatActivity {

    private Spinner spinnerTicketType;
    private EditText etTicketQuantity;
    private Button btnSelectDate, btnSelectTime, btnProceedPayment;
    private TextView tvTotalPrice;
    private String selectedDate, selectedTime, selectedTicketType;
    private static final int TICKET_PRICE = 25;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleto);

        // Inicializar los componentes de la UI
        spinnerTicketType = findViewById(R.id.spinner_ticket_type);
        etTicketQuantity = findViewById(R.id.et_ticket_quantity);
        btnSelectDate = findViewById(R.id.btn_select_date);
        btnSelectTime = findViewById(R.id.btn_select_time);
        btnProceedPayment = findViewById(R.id.btn_proceed_payment);
        tvTotalPrice = findViewById(R.id.tv_total_price);

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

        // Manejar la selección de la hora
        btnSelectTime.setOnClickListener(v -> showTimePicker());

        // Manejar el clic en el botón "Proceder al Pago"
        btnProceedPayment.setOnClickListener(v -> proceedToPayment());
    }

    private void calcularPrecioTotal() {
        String quantityText = etTicketQuantity.getText().toString();
        if (!quantityText.isEmpty()) {
            int ticketQuantity = Integer.parseInt(quantityText);
            int totalPrice = ticketQuantity * TICKET_PRICE;
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

    // Método para mostrar el selector de hora
    private void showTimePicker() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                Mainboleto.this,
                (view, hourOfDay, minute1) -> {
                    selectedTime = hourOfDay + ":" + String.format("%02d", minute1);
                    Toast.makeText(Mainboleto.this, "Hora seleccionada: " + selectedTime, Toast.LENGTH_SHORT).show();
                },
                hour, minute, true);
        timePickerDialog.show();
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

        if (selectedTime == null) {
            Toast.makeText(this, "Por favor, seleccione una hora.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Redireccionar al Mainpago (Mainpaw) solo si todos los datos están completos
        Intent intent = new Intent(Mainboleto.this, Mainreserva.class);
        startActivity(intent);
    }
}
