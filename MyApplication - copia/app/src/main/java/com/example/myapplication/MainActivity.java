package com.example.myapplication; // Cambia esto al paquete de tu aplicación

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private Button settingsButton;

    // Declarar los ImageView
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa los elementos de la interfaz
        searchView = findViewById(R.id.searchView);
        settingsButton = findViewById(R.id.settingsButton);

        // Inicializar los ImageView
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

        // Configura el listener para la barra de búsqueda
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Aquí puedes manejar la búsqueda
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Aquí puedes manejar los cambios en el texto de búsqueda
                return false;
            }
        });

        // Configura los listeners para los botones de las películas
        findViewById(R.id.buttonMovie1).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen1, "En el vasto universo de Marvel, Richard Rider, un joven común de la Tierra, es elegido por el moribundo Rhomann Dey, último superviviente de los Nova Corps, para heredar el inmenso poder del Cuerpo Nova. Sin preparación y sin saber en qué se ha metido, Richard se convierte en Nova, el Centurión de la Tierra, cargando con la responsabilidad de proteger no solo su planeta, sino también galaxias enteras."));
        findViewById(R.id.buttonMovie2).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen2, "Riley está entrando en la adolescencia, una etapa llena de emociones nuevas y desafíos inesperados. Dentro de su mente, Alegría, Tristeza, Temor, Furia y Desagrado enfrentan cambios en el cuartel general de emociones. A medida que Riley experimenta situaciones más complejas como la presión social, los primeros enamoramientos y las dudas sobre su identidad, sus emociones tienen que aprender a trabajar juntas de nuevas maneras."));
        findViewById(R.id.buttonMovie3).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen3, "En Joker: Folie à Deux, Arthur Fleck (Joaquin Phoenix) regresa a las calles de Gotham, pero ahora como una figura consolidada en el caos y la anarquía. Tras los eventos del primer film, Arthur se encuentra internado en el Arkham State Hospital, donde la línea entre su realidad y sus fantasías sigue difuminándose. Sin embargo, esta vez no está solo."));
        findViewById(R.id.buttonMovie4).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen4, "En esta explosiva y divertida aventura, Deadpool (Ryan Reynolds) y Wolverine (Hugh Jackman) se ven obligados a unir fuerzas de manera inesperada. Cuando una oscura organización clandestina conocida como Weapon X resurge, ambos héroes se convierten en los principales objetivos, debido a sus habilidades regenerativas y su pasado como experimentos genéticos."));
        findViewById(R.id.buttonMovie5).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen5, "En esta nueva aventura animada, Garfield (con la voz de Chris Pratt), el famoso gato amante de la lasaña, regresa a la pantalla grande con su típico sarcasmo, flojera y desdén por el lunes. En esta versión moderna, Garfield vive felizmente con su dueño Jon Arbuckle (Nicholas Hoult) y su ingenuo compañero canino Odie. Sin embargo, la vida tranquila de Garfield se ve interrumpida cuando un misterioso gato del pasado de Jon aparece inesperadamente."));
        findViewById(R.id.buttonMovie6).setOnClickListener(v -> openMovieDescription(R.mipmap.imagen6, "Transformers One lleva a los espectadores al origen de la épica batalla entre los Autobots y los Decepticons en su planeta natal, Cybertron. En esta precuela, seguimos la historia del joven Optimus Prime y su transformación de ser el idealista Orion Pax a convertirse en el legendario líder de los Autobots. La película también profundiza en la relación entre Optimus y Megatron, quien alguna vez fue su cercano amigo y hermano de armas, antes de que la ambición y el poder lo llevaran a encabezar a los Decepticons."));
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
        Intent intent = new Intent(MainActivity.this, Main_configures.class); // Cambia 'SettingsActivity' al nombre de tu actividad de configuraciones
        startActivity(intent);
    }
}










