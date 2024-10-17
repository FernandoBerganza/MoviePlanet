package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Mainpaw extends AppCompatActivity {

    private EditText editTextCardNumber, editTextExpirationDate, editTextCVV;
    private RadioGroup radioGroupPaymentMethod;
    private RadioButton radioButtonDebit, radioButtonCredit;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paw); // Asegúrate de que este sea tu layout de pago

        // Inicializar los elementos de la interfaz
        editTextCardNumber = findViewById(R.id.editText_cardNumber);
        editTextExpirationDate = findViewById(R.id.editText_expirationDate);
        editTextCVV = findViewById(R.id.editText_cvv);
        radioGroupPaymentMethod = findViewById(R.id.radioGroup_paymentMethod);
        radioButtonDebit = findViewById(R.id.radioButton_debit);
        radioButtonCredit = findViewById(R.id.radioButton_credit);
        buttonPay = findViewById(R.id.button_pay);

        // Configurar el botón de pagar
        buttonPay.setOnClickListener(v -> {
            String cardNumber = editTextCardNumber.getText().toString();
            String expirationDate = editTextExpirationDate.getText().toString();
            String cvv = editTextCVV.getText().toString();
            String paymentMethod = radioButtonDebit.isChecked() ? "Débito" : "Crédito";

            // Validar campos antes de proceder con el pago
            if (cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(Mainpaw.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Lógica para procesar el pago
                Toast.makeText(Mainpaw.this, "Pago realizado con " + paymentMethod, Toast.LENGTH_SHORT).show();

                // Redirigir a la actividad del ticket
                Intent intent = new Intent(Mainpaw.this, MainTicket.class); // Asegúrate de que TicketActivity sea el nombre de la actividad del ticket
                startActivity(intent);
            }
        });
    }
}
