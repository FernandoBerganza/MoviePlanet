package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;  // Asegúrate de importar esta clase
import androidx.appcompat.app.AppCompatActivity;

public class MainTicket extends AppCompatActivity {

    private TextView ticketTitle;
    private TextView textViewSeatInfo;
    private TextView textViewDateInfo;
    private TextView textViewTimeInfo;
    private TextView textViewQuantityInfo;
    private TextView textViewAmountInfo;
    private ImageView imageViewQRCode;
    private Button buttonDownloadTicket;
    private Button buttonBackToCatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ticket);

        // Inicializa los elementos de la interfaz
        ticketTitle = findViewById(R.id.ticketTitle);
        textViewSeatInfo = findViewById(R.id.textViewSeatInfo);
        textViewDateInfo = findViewById(R.id.textViewDateInfo);
        textViewTimeInfo = findViewById(R.id.textViewTimeInfo);
        textViewQuantityInfo = findViewById(R.id.textViewQuantityInfo);
        textViewAmountInfo = findViewById(R.id.textViewAmountInfo);
        imageViewQRCode = findViewById(R.id.imageViewQRCode);
        buttonDownloadTicket = findViewById(R.id.buttonDownloadTicket);
        buttonBackToCatalog = findViewById(R.id.buttonBackToCatalog);

        // Obtener los datos del Intent
        Intent intent = getIntent();
        String seatInfo = intent.getStringExtra("SEAT_INFO");
        String dateInfo = intent.getStringExtra("DATE_INFO");
        String timeInfo = intent.getStringExtra("TIME_INFO");
        String quantityInfo = intent.getStringExtra("QUANTITY_INFO");
        String amountInfo = intent.getStringExtra("AMOUNT_INFO");

        // Log para depuración
        Log.d("MainTicket", "Seat Info: " + seatInfo);
        Log.d("MainTicket", "Date Info: " + dateInfo);
        Log.d("MainTicket", "Time Info: " + timeInfo);
        Log.d("MainTicket", "Quantity Info: " + quantityInfo);
        Log.d("MainTicket", "Amount Info: " + amountInfo);

        // Comprobar si los datos son null y mostrar un mensaje si es necesario
        if (seatInfo == null || seatInfo.isEmpty()) seatInfo = "No hay asientos seleccionados";
        if (dateInfo == null || dateInfo.isEmpty()) dateInfo = "Fecha no disponible";
        if (timeInfo == null || timeInfo.isEmpty()) timeInfo = "Hora no disponible";
        if (quantityInfo == null || quantityInfo.isEmpty()) quantityInfo = "Cantidad no disponible";
        if (amountInfo == null || amountInfo.isEmpty()) amountInfo = "Monto no disponible";

        // Establecer la información del boleto
        setTicketInfo("Asientos: " + seatInfo, "Fecha: " + dateInfo, "Hora: " + timeInfo, "Cantidad: " + quantityInfo, "Monto: " + amountInfo);

        // Configura el botón de descarga de boleto
        buttonDownloadTicket.setOnClickListener(v -> {
            // Aquí puedes implementar la lógica para descargar el boleto
            Toast.makeText(MainTicket.this, "Descargando boleto...", Toast.LENGTH_SHORT).show(); // Asegúrate de que esta línea sea correcta
        });

        // Configura el botón de regreso al catálogo
        buttonBackToCatalog.setOnClickListener(v -> {
            Intent intentBack = new Intent(MainTicket.this, MainActivity.class);
            startActivity(intentBack);
            finish(); // Finaliza la actividad actual si no la necesitas en el back stack
        });
    }

    // Método para establecer información del boleto
    private void setTicketInfo(String seat, String date, String time, String quantity, String amount) {
        textViewSeatInfo.setText(seat);
        textViewDateInfo.setText(date);
        textViewTimeInfo.setText(time);
        textViewQuantityInfo.setText(quantity);
        textViewAmountInfo.setText(amount);
    }
}






