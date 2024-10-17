package com.example.myapplication; // Asegúrate de que el paquete coincida con el de tu proyecto

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        // Establece información del boleto (puedes recibir estos datos de otro Activity)
        setTicketInfo("Asiento: A1", "Fecha: 20/10/2024", "Hora: 18:00", "Cantidad: 2", "Monto: $120");

        // Configura el botón de descarga de boleto
        buttonDownloadTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para descargar el boleto
            }
        });

        // Configura el botón de regreso al catálogo
        buttonBackToCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainTicket.this, MainActivity.class); // Cambia MainCatalog por el nombre de tu actividad de catálogo
                startActivity(intent);
                finish(); // Finaliza la actividad actual si no la necesitas en el back stack
            }
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

