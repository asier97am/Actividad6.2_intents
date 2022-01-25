package com.example.actividad62_intents;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_decenas extends AppCompatActivity {

    private EditText et2;
    private Button bt2;

    ActivityResultLauncher<Intent> my_ActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decenas);

        et2= (EditText) findViewById(R.id.et2);
        bt2= (Button) findViewById(R.id.bt2);

        my_ActivityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== Activity.RESULT_OK){
                            Intent intent_vuelta = result.getData();
                            String unidades_vuelta = intent_vuelta.getStringExtra("unidades").toString();
                            String decenas_vuelta = et2.getText().toString();

                            Intent my_resultado = new Intent();
                            my_resultado.putExtra("unidades_vuelta", unidades_vuelta);
                            my_resultado.putExtra("decenas_vuelta", decenas_vuelta);
                            setResult(RESULT_OK, my_resultado);

                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            String mensaje_vuelta = "Sin mensaje de vuelta";
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, mensaje_vuelta, duration);
                            toast.show();
                        }
                        finish();
                    }
                }
        );


    }

    public void siguienteActividad(View view) {
        Intent my_intent = new Intent(this, activity_unidades.class);
        my_ActivityResultLauncher.launch(my_intent);
    }
}