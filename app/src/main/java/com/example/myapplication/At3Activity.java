package com.example.myapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class At3Activity extends AppCompatActivity {
    private EditText editNome, editIdade, editCidade, editEstado, editEmail, editTelefone;
    private RadioGroup radioGroupTamanho;
    private CheckBox cbQuente, cbFrias, cbNeutra;
    private Button btnEnviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at3);

        initializeViews();

        btnEnviar.setOnClickListener(v -> enviarDados());

    }

    private void initializeViews() {

        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        editCidade = findViewById(R.id.editCidade);
        editEstado = findViewById(R.id.editEstado);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);


        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);


        RadioButton radioP = findViewById(R.id.radioP);
        RadioButton radioM = findViewById(R.id.radioM);
        RadioButton radioG = findViewById(R.id.radioG);
        RadioButton radioGG = findViewById(R.id.radioGG);


        cbQuente = findViewById(R.id.cbQuente);
        cbFrias = findViewById(R.id.cbFrias);
        cbNeutra = findViewById(R.id.cbNeutra);

        btnEnviar = findViewById(R.id.btn_Enviar);
    }

    private void enviarDados() {
        if (!ValidacaoInputs()) {
            return;
        }

        String nome = editNome.getText().toString().trim();
        String idade = editIdade.getText().toString().trim();
        String cidade = editCidade.getText().toString().trim();
        String estado = editEstado.getText().toString().trim();
        String telefone = editTelefone.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String tamanhoSelecionado = getTamanhoSelecionado();
        String cores = getCorSelecionada();


        String mensagem = String.format(
                "Detalhes do Cadastro foram Enviados"
        );

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    private boolean ValidacaoInputs() {
        boolean Validacao = true;


        if (editNome.getText().toString().trim().isEmpty()) {
            editNome.setError("Nome é obrigatório!");
            Validacao = false;
        }


        String idade = editIdade.getText().toString().trim();
        if (idade.isEmpty()) {
            editIdade.setError("Idade é obrigatória!");
            Validacao = false;
        } else {
            try {
                int age = Integer.parseInt(idade);
                if (age < 0 || age > 120) {
                    editIdade.setError("Idade inválida!");
                    Validacao = false;
                }
            } catch (NumberFormatException e) {
                editIdade.setError("Idade inválida!");
                Validacao = false;
            }
        }


        String email = editEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editEmail.setError("Email é obrigatório!");
            Validacao = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Email inválido!");
            Validacao = false;
        }
        if (radioGroupTamanho.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecione um tamanho de roupa", Toast.LENGTH_SHORT).show();
            Validacao = false;
        }

        return Validacao;
    }

    private void clearErrors() {
        editNome.setError(null);
        editIdade.setError(null);
        editEmail.setError(null);
    }

    private String getTamanhoSelecionado() {
        int selectedId = radioGroupTamanho.getCheckedRadioButtonId();

        if (selectedId == R.id.radioP) return "P";
        if (selectedId == R.id.radioM) return "M";
        if (selectedId == R.id.radioG) return "G";
        if (selectedId == R.id.radioGG) return "GG";

        return "Não selecionado";
    }

    private String getCorSelecionada() {
        StringBuilder cores = new StringBuilder();

        if (cbQuente.isChecked()) cores.append("Quentes ");
        if (cbFrias.isChecked()) cores.append("Frias ");
        if (cbNeutra.isChecked()) cores.append("Neutras ");

        return cores.toString().trim();
    }

}