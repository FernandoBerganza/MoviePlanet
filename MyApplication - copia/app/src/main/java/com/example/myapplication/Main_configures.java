package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Main_configures extends AppCompatActivity {

    // Opciones de configuración
    String[] options = {
            "Cambiar a modo noche",
            "Configuraciones generales",
            "Cambiar fondo",
            "Salir del inicio de sesión"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configures);

        // Obtener la referencia del ListView
        ListView listView = findViewById(R.id.list_configures);

        // Crear un adaptador para llenar el ListView con las opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );

        // Asignar el adaptador al ListView
        listView.setAdapter(adapter);

        // Manejar los clics en los ítems del ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener la opción seleccionada
                String selectedOption = options[position];

                // Mostrar un mensaje para la opción seleccionada (temporal)
                Toast.makeText(Main_configures.this, "Seleccionado: " + selectedOption, Toast.LENGTH_SHORT).show();

                // Aquí puedes agregar la lógica para cada opción seleccionada
                switch (position) {
                    case 0:
                        // Cambiar a modo noche
                        cambiarModoNoche();
                        break;
                    case 1:
                        // Configuraciones generales
                        abrirConfiguracionesGenerales();
                        break;
                    case 2:
                        // Cambiar fondo
                        cambiarFondo();
                        break;
                    case 3:
                        // Salir del inicio de sesión
                        cerrarSesion();
                        break;
                }
            }
        });
    }

    private void cambiarModoNoche() {
        // Lógica para cambiar a modo noche
        Toast.makeText(this, "Modo noche activado", Toast.LENGTH_SHORT).show();
    }

    private void abrirConfiguracionesGenerales() {
        // Lógica para abrir las configuraciones generales
        Toast.makeText(this, "Configuraciones generales abiertas", Toast.LENGTH_SHORT).show();
    }

    private void cambiarFondo() {
        // Lógica para cambiar el fondo
        Toast.makeText(this, "Cambiando fondo", Toast.LENGTH_SHORT).show();
    }

    private void cerrarSesion() {
        // Lógica para cerrar sesión
        Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
    }
}

