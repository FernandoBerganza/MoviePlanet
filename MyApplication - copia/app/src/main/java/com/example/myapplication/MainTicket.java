package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainTicket extends AppCompatActivity {

    private TextView textViewSeatInfo, textViewDateInfo, textViewTimeInfo, textViewQuantityInfo, textViewAmountInfo;
    private ImageView ticketLayout; // Cambia esto según el id de tu diseño
    private Button buttonDownloadTicket, buttonBackToCatalog;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ticket);

        // Inicialización de elementos
        textViewSeatInfo = findViewById(R.id.textViewSeatInfo);
        textViewDateInfo = findViewById(R.id.textViewDateInfo);
        textViewTimeInfo = findViewById(R.id.textViewTimeInfo);
        textViewQuantityInfo = findViewById(R.id.textViewQuantityInfo);
        textViewAmountInfo = findViewById(R.id.textViewAmountInfo);
        ticketLayout = findViewById(R.id.ticketLayout); // Layout del ticket
        buttonDownloadTicket = findViewById(R.id.buttonDownloadTicket);
        buttonBackToCatalog = findViewById(R.id.buttonBackToCatalog);

        // Obtener datos de la intención
        Intent intent = getIntent();
        String seatInfo = intent.getStringExtra("seatInfo");
        String dateInfo = intent.getStringExtra("dateInfo");
        String timeInfo = intent.getStringExtra("timeInfo");
        String quantityInfo = intent.getStringExtra("quantityInfo");
        String amountInfo = intent.getStringExtra("amountInfo");

        // Mostrar datos en el boleto
        textViewSeatInfo.setText("Asiento: " + seatInfo);
        textViewDateInfo.setText("Fecha: " + dateInfo);
        textViewTimeInfo.setText("Hora: " + timeInfo);
        textViewQuantityInfo.setText("Cantidad: " + quantityInfo);
        textViewAmountInfo.setText("Monto: " + amountInfo);

        // Configurar botón de descargar
        buttonDownloadTicket.setOnClickListener(v -> downloadTicketAsImage());

        // Configurar botón de volver al catálogo
        buttonBackToCatalog.setOnClickListener(v -> {
            Intent catalogIntent = new Intent(MainTicket.this, MainActivity.class);
            startActivity(catalogIntent);
        });
    }

    private void downloadTicketAsImage() {
        BitmapDrawable drawable = (BitmapDrawable) ticketLayout.getBackground();
        Bitmap bitmap = drawable.getBitmap();
        String filePath = getExternalFilesDir(null) + "/ticket.png"; // Cambia esto si necesitas otra ubicación

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // PNG es el formato del boleto
            // Mostrar un mensaje de éxito
            Toast.makeText(this, "Boleto descargado exitosamente en: " + filePath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al descargar el boleto.", Toast.LENGTH_SHORT).show();
        }
    }
}
