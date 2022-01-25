package com.example.actividad62_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class activity_unidades extends AppCompatActivity {

    private EditText et3;
    private Button bt3;
    String unidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidades);

        et3= (EditText) findViewById(R.id.et3);
        bt3= (Button) findViewById(R.id.bt3);

    }

    public void retornar(View view) {

        //et3 = findViewById(R.id.et3);
        unidades = et3.getText().toString();
        Intent my_resultado = new Intent();
        my_resultado.putExtra("unidades", unidades);
        setResult(RESULT_OK, my_resultado);
        this.finish();
    }
}