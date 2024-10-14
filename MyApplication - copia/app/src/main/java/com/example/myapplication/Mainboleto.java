package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent; // Asegúrate de importar Intent
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Mainboleto extends AppCompatActivity {

    private Spinner spinnerTicketType;
    private EditText etTicketQuantity;
    private Button btnSelectDate, btnSelectTime, btnProceedPayment;
    private String selectedDate, selectedTime, selectedTicketType;

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

        // Configurar Spinner para seleccionar tipo de boleto
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ticket_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTicketType.setAdapter(adapter);

        // Manejar la selección del tipo de boleto
        spinnerTicketType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTicketType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Por defecto, no hacer nada
            }
        });

        // Manejar la selección de la fecha
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        // Manejar la selección de la hora
        btnSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        // Manejar el clic en el botón "Proceder al Pago"
        btnProceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToPayment();
            }
        });
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
        if (quantityText.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la cantidad de boletos.", Toast.LENGTH_SHORT).show();
            return;
        }

        int ticketQuantity = Integer.parseInt(quantityText);

        // Validar que todos los campos estén llenos
        if (selectedDate == null || selectedTime == null || selectedTicketType == null) {
            Toast.makeText(this, "Por favor, complete toda la información antes de proceder.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Redireccionar al Mainpago
        Intent intent = new Intent(Mainboleto.this, Mainpago.class);
        startActivity(intent);
    }
}

