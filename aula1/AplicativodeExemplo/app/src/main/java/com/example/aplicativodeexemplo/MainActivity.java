package com.example.aplicativodeexemplo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button alterarTexto = findViewById(R.id.alterarTextoButton);
        Button invocarToastButton = findViewById(R.id.invocarToastButton);
        Button verificarOpc = findViewById(R.id.checarOpcaoSelecionadaButton);
        Button abrirOutraTela = findViewById(R.id.abrirOutraTelaButton);
        EditText inserirTexto = findViewById(R.id.recebeTextoInput);
        TextView recebeTexto = findViewById(R.id.textView);
        RadioButton r1 = findViewById(R.id.radioButton);
        RadioButton r2 = findViewById(R.id.radioButton2);
        RadioButton r3 = findViewById(R.id.radioButton3);
        RadioGroup rg = findViewById(R.id.rg);
        alterarTexto.setOnClickListener( v -> {
            recebeTexto.setText( inserirTexto.getText() );
        });
        abrirOutraTela.setOnClickListener( v -> {
            Intent intent = new Intent (this, SegundaTela.class);
            startActivity(intent);
        });
        invocarToastButton.setOnClickListener( v -> {
            Toast t = Toast.makeText(this,inserirTexto.getText(), Toast.LENGTH_LONG);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
            t.show();
        });
        verificarOpc.setOnClickListener( v -> {
            int checked = 0;

            if ( r1.isChecked() ) {
                checked = 1;
            } else if ( r2.isChecked() ) {
                checked = 2;
            } else if ( r3.isChecked() ) {
                checked = 3;
            }

            Toast t = Toast.makeText(this,"Opção " + checked + " foi checada!", Toast.LENGTH_LONG);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 200);
            t.show();
        });
    }
}