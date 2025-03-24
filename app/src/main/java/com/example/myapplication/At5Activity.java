package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class At5Activity extends AppCompatActivity {
    private CheckBox cbNotifications, cbDarkMode, cbRememberLogin;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at5);

        cbNotifications = findViewById(R.id.cb_notifications);
        cbDarkMode = findViewById(R.id.cb_dark_mode);
        cbRememberLogin = findViewById(R.id.cb_remember_login);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
            }
        });
    }

    private void savePreferences() {
        StringBuilder selectedOptions = new StringBuilder();

        if (cbNotifications.isChecked()) {
            selectedOptions.append("• Receber notificações\n");
        }

        if (cbDarkMode.isChecked()) {
            selectedOptions.append("• Modo escuro\n");
        }

        if (cbRememberLogin.isChecked()) {
            selectedOptions.append("• Lembrar login\n");
        }

        if (selectedOptions.length() > 0) {
            Toast.makeText(this, "Preferências salvas:\n" + selectedOptions.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Nenhuma preferência foi escolhida", Toast.LENGTH_SHORT).show();
        }
    }
}