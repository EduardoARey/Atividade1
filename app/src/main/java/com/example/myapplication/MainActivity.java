package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        }
    public void carregarActivityAt1(View view)
    {
        Intent intent = new Intent(MainActivity.this, At1Activity.class);
        startActivity(intent);
    }
    public void carregarActivityAt2(View view)
    {
        Intent intent = new Intent(MainActivity.this, At2Activity.class);
        startActivity(intent);
    }
    public void carregarActivityAt3(View view)
    {
        Intent intent = new Intent(MainActivity.this, At3Activity.class);
        startActivity(intent);
    }
    public void carregarActivityAt4(View view)
    {
        Intent intent = new Intent(MainActivity.this, At4Activity.class);
        startActivity(intent);
    }
     public void carregarActivityAt5(View view)
     {
            Intent intent = new Intent(MainActivity.this, At5Activity.class);
            startActivity(intent);
     }
}