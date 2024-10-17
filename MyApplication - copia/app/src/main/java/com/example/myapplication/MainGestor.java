package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainGestor extends AppCompatActivity {

    private EditText etBuscarPelicula, etCantidadBoletos;
    private Button btnBuscar, btnNuevoBoleto, btnEliminarBoleto, btnCerrarBoleto;
    private RecyclerView rvTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor);

        // Inicializar los componentes
        etBuscarPelicula = findViewById(R.id.etBuscarPelicula);
        etCantidadBoletos = findViewById(R.id.etCantidadBoletos);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnNuevoBoleto = findViewById(R.id.btnNuevoBoleto);
        btnEliminarBoleto = findViewById(R.id.btnEliminarBoleto);
        btnCerrarBoleto = findViewById(R.id.btnCerrarBoleto);
        rvTickets = findViewById(R.id.rvTickets);

        // Configurar acciones de los botones
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarBoletos();
            }
        });

        btnNuevoBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoBoleto();
            }
        });

        btnEliminarBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarBoleto();
            }
        });

        btnCerrarBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarBoleto();
            }
        });
    }

    private void buscarBoletos() {
        // Lógica para buscar boletos
    }

    private void nuevoBoleto() {
        // Lógica para crear un nuevo boleto
    }

    private void eliminarBoleto() {
        // Lógica para eliminar un boleto
    }

    private void cerrarBoleto() {
    }
}

