package com.example.myapplication; // Cambia esto al paquete de tu aplicación

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MovieDescriptionActivity extends AppCompatActivity {

    private ImageView selectedMovieImage;
    private TextView movieDescription;
    private Button btnBuyTicket; // Botón para comprar boleto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);

        // Inicializa los elementos de la interfaz
        selectedMovieImage = findViewById(R.id.selectedMovieImage);
        movieDescription = findViewById(R.id.movieDescription);
        btnBuyTicket = findViewById(R.id.btn_buy_ticket); // Inicializa el botón

        // Obtener datos de la intención
        int imageResId = getIntent().getIntExtra("imageResId", R.mipmap.default_image);
        String description = getIntent().getStringExtra("description");

        // Establecer la imagen y la descripción
        selectedMovieImage.setImageResource(imageResId);
        movieDescription.setText(description);

        // Configurar el botón para comprar boleto
        btnBuyTicket.setOnClickListener(v -> {
            // Iniciar la actividad de compra de boletos
            Intent intent = new Intent(MovieDescriptionActivity.this, Mainboleto.class);
            startActivity(intent);
        });
    }
}






