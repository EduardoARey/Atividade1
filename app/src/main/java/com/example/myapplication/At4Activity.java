package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class At4Activity extends AppCompatActivity {
    private EditText editText;
    private Button btnCheckboxes;
    private LinearLayout checkboxesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at4);

        editText = findViewById(R.id.editText);
        btnCheckboxes = findViewById(R.id.btn_gerar_checkboxes);
        checkboxesContainer = findViewById(R.id.checkboxesContainer);

        btnCheckboxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateCheckboxes();
            }
        });
    }

    private void generateCheckboxes() {
        String nome = editText.getText().toString().trim();
        checkboxesContainer.removeAllViews();

        if (nome.isEmpty()) {
            showErrorMessage("Por favor, digite um nome.");
            return;
        }

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);
            addCheckbox(String.valueOf(letra), i);
        }
    }

    private void addCheckbox(String text, int id) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(text);
        checkBox.setId(id);
        checkboxesContainer.addView(checkBox);
    }

    private void showErrorMessage(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        checkboxesContainer.addView(textView);
    }
}