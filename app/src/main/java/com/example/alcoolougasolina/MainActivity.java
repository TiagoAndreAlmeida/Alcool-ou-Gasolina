package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        resultText = findViewById(R.id.resultText);
    }

    private void handlerCalc() {
        String alcoolText = editPrecoAlcool.getText().toString();
        String gasolinaText = editPrecoGasolina.getText().toString();

        if(validForm(alcoolText, gasolinaText)){
            Double alcoolValue = Double.parseDouble(alcoolText);
            Double gasolinaValue = Double.parseDouble(gasolinaText);
            Double result = alcoolValue / gasolinaValue;
            Log.d("DEBUG", "result: "+result);
            if(result >= 0.7) {
                resultText.setText("É melhor usar GASOLINA");
            } else {
                resultText.setText("É melhor usar ALCOOL");
            }
        }

    }

    private Boolean validForm(String alcoolValue, String gasolinaValue) {
        Log.d("DEBUG", "alcool: "+alcoolValue);
        Log.d("DEBUG", "gas: "+gasolinaValue);
        if(alcoolValue.isEmpty()) {
            editPrecoAlcool.setError("Informe um valor");
            return false;
        } else if(gasolinaValue.isEmpty()) {
            editPrecoGasolina.setError("Informe um valor");
            return false;
        }
        return true;
    }

    public void submit(View view) {
        handlerCalc();
    }
}