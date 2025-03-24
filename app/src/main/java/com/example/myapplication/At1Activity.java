package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class At1Activity extends Activity {
    private EditText editNome;
    private EditText editIdade;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at1);

        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void verificarIdade(View view) {
        String nome = editNome.getText().toString();
        String idadeStr = editIdade.getText().toString();

        if (nome.isEmpty() || idadeStr.isEmpty()) {
            txtResultado.setText("Preencha todos os campos!");
            return;
        }

        int idade = Integer.parseInt(idadeStr);
        String mensagem = nome + ", você é " + (idade >= 18 ? "maior" : "menor") + " de idade.";

        txtResultado.setText(mensagem);
    }
}
