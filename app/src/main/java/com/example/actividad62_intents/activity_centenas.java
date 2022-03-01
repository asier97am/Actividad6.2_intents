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

public class activity_centenas extends AppCompatActivity {

    private EditText et1;
    private Button bt1;
    private TextView tvComprobacion;
    ActivityResultLauncher<Intent> my_ActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centenas);

        et1= (EditText) findViewById(R.id.et1);
        bt1= (Button) findViewById(R.id.bt1);
        tvComprobacion= (TextView) findViewById(R.id.tvComprobacion);

        my_ActivityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== Activity.RESULT_OK){
                            Intent intent_vuelta = result.getData();
                            String unidades_vuelta = intent_vuelta.getStringExtra("unidades_vuelta").toString();
                            String decenas_vuelta = intent_vuelta.getStringExtra("decenas_vuelta").toString();

                            String centenas_vuelta=et1.getText().toString();
                            String resultado = centenas_vuelta + decenas_vuelta + unidades_vuelta;
                            resultado= Integer.toBinaryString(Integer.parseInt(resultado))+" ---> "+resultado;

                            tvComprobacion.setText(resultado);

                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            String mensaje_vuelta = "Sin mensaje de vuelta";
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, mensaje_vuelta, duration);
                            toast.show();
                        }
                    }
                }
        );


    }

    public void siguienteActividad(View view) {
        Intent my_intent = new Intent(this, activity_decenas.class);
        my_ActivityResultLauncher.launch(my_intent);
    }
}