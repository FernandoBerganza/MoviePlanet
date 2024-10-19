package com.example.myapplication; // Cambia esto al paquete de tu aplicación

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button settingsButton;

    // Declarar los ImageView
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa los elementos de la interfaz
        settingsButton = findViewById(R.id.settingsButton);

        // Inicializar los ImageView
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);

        // Configura el listener para el botón de configuraciones
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        // Configura los listeners para los botones de las películas
        findViewById(R.id.buttonMovie1).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen1, "NOVA" + "\n" + "En el vasto universo de Marvel, Richard Rider, es elegido por el moribundo Rhomann Dey, para heredar el inmenso poder del Cuerpo Nova."));
        findViewById(R.id.buttonMovie2).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen2, "INTENSAMENTE 2" + "\n" + "Riley está entrando en la adolescencia, una etapa llena de emociones nuevas y desafíos inesperados. Dentro de su mente, Alegría, Tristeza, Temor, Furia y Desagrado enfrentan cambios en el cuartel general de emociones."));
        findViewById(R.id.buttonMovie3).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen3, "Joker: Folie à Deux" + "\n" + "Arthur Fleck (Joaquin Phoenix) regresa a las calles de Gotham, pero ahora como una figura consolidada en el caos y la anarquía."));
        findViewById(R.id.buttonMovie4).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen4, "DEADPOOL AND WOLVERINE" + "\n" + "En esta explosiva y divertida aventura, Deadpool (Ryan Reynolds) y Wolverine (Hugh Jackman) se ven obligados a unir fuerzas de manera inesperada."));
        findViewById(R.id.buttonMovie5).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen5, "GARFIELD" + "\n" + "En esta nueva aventura animada, Garfield (con la voz de Chris Pratt), el famoso gato amante de la lasaña, regresa a la pantalla grande con su típico sarcasmo, flojera y desdén por el lunes."));
        findViewById(R.id.buttonMovie6).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen6, "Transformers One" + "\n" + "Lleva a los espectadores al origen de la épica batalla entre los Autobots y los Decepticons en su planeta natal, Cybertron."));
    }

    // Método para abrir la actividad de descripción de películas
    private void openMovieDescription(int imageResId, String description) {
        Intent intent = new Intent(MainActivity.this, MovieDescriptionActivity.class);
        intent.putExtra("imageResId", imageResId);
        intent.putExtra("description", description);
        startActivity(intent);
    }

    // Método para abrir la actividad de configuración
    private void openSettings() {
        Intent intent = new Intent(MainActivity.this, Main_configures.class); // Cambia 'Main_configures' al nombre de tu actividad de configuraciones
        startActivity(intent);
    }
}







