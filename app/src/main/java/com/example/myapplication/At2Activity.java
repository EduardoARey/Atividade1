package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class At2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at2);
    }

    private double getInputValue(EditText editText) {
        String valueStr = editText.getText().toString().trim();
        if (valueStr.isEmpty()) {
            return Double.NaN;
        }
        try {
            return Double.parseDouble(valueStr);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    private void calculate(View view, char operation) {
        EditText editValor1 = findViewById(R.id.editNum1);
        EditText editValor2 = findViewById(R.id.editNum2);
        TextView txtResultado = findViewById(R.id.txtResultado);

        double valor1 = getInputValue(editValor1);
        double valor2 = getInputValue(editValor2);

        if (Double.isNaN(valor1) || Double.isNaN(valor2)) {
            txtResultado.setText("Digite números válidos!");
            return;
        }

        double resultado = 0;
        switch (operation) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case '*':
                resultado = valor1 * valor2;
                break;
            case '/':
                if (valor2 == 0) {
                    txtResultado.setText("Erro: divisão por zero!");
                    return;
                }
                resultado = valor1 / valor2;
                break;
        }

        txtResultado.setText(String.format("Resultado: %.2f", resultado));
    }

    public void somar(View view) {
        calculate(view, '+');
    }

    public void subtrair(View view) {
        calculate(view, '-');
    }

    public void multiplicar(View view) {
        calculate(view, '*');
    }

    public void dividir(View view) {
        calculate(view, '/');
    }
    public void voltarParaMain(View view) {
        finish();
    }
}
