package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class BaseDatosActivity extends AppCompatActivity {

    private Spinner spinnerCines;
    private Button btnConsultaPeliculas;
    private ListView listPeliculas;
    private TextView tvPeliculas;
    private ArrayList<String> listaCines;
    private ArrayList<String> listaPeliculas;
    private ArrayAdapter<String> adaptadorCines;
    private ArrayAdapter<String> adaptadorPeliculas;

    // Datos de conexión a SQL Server
    private static final String URL = "jdbc:jtds:sqlserver://localhost:1433/cine";
    private static final String USER = "Luis-Garza/LUISJO";
    private static final String PASS = "170301";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos); // Asegúrate que el nombre del layout sea correcto

        // Inicializar vistas
        spinnerCines = findViewById(R.id.spinnerCines);
        btnConsultaPeliculas = findViewById(R.id.btnConsultaPeliculas);
        listPeliculas = findViewById(R.id.listPeliculas);
        tvPeliculas = findViewById(R.id.tvPeliculas);

        // Inicializar listas y adaptadores
        listaCines = new ArrayList<>();
        listaPeliculas = new ArrayList<>();
        adaptadorCines = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaCines);
        adaptadorPeliculas = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPeliculas);

        // Configurar adaptadores
        adaptadorCines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCines.setAdapter(adaptadorCines);
        listPeliculas.setAdapter(adaptadorPeliculas);

        // Cargar cines desde la base de datos (en un hilo de fondo)
        new Thread(() -> {
            cargarCines();
            runOnUiThread(() -> adaptadorCines.notifyDataSetChanged());
        }).start();

        // Configurar el evento clic del botón
        btnConsultaPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarPeliculas();
            }
        });

        // Configurar el evento de selección del Spinner
        spinnerCines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Limpiar la lista de películas al cambiar de cine
                listaPeliculas.clear();
                adaptadorPeliculas.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se necesita hacer nada aquí
            }
        });
    }

    // Método para cargar los cines desde la base de datos
    private void cargarCines() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT nombre FROM Cines")) { // Ajusta la consulta

            while (resultSet.next()) {
                listaCines.add(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            runOnUiThread(() -> Toast.makeText(this, "Error al cargar los cines", Toast.LENGTH_SHORT).show());
        }
    }

    // Método para consultar las películas del cine seleccionado
    private void consultarPeliculas() {
        String cineSeleccionado = spinnerCines.getSelectedItem().toString();

        new Thread(() -> {
            try (Connection connection = getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(
                         "SELECT titulo FROM Peliculas WHERE cine = '" + cineSeleccionado + "'")) { // Ajusta la consulta

                listaPeliculas.clear(); // Limpiar la lista antes de agregar nuevas películas

                while (resultSet.next()) {
                    listaPeliculas.add(resultSet.getString("titulo"));
                }

                runOnUiThread(() -> {
                    adaptadorPeliculas.notifyDataSetChanged();
                    tvPeliculas.setText("Películas Disponibles en " + cineSeleccionado); // Actualizar el título
                });
            } catch (SQLException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Error al consultar las películas", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    // Método para obtener la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error al cargar el driver JDBC", e);
        }
    }
}