package com.example.dec2bin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    public void convertToBinary(View viewElement){
        TextView decimalInput = findViewById(R.id.main_decimalInput);

        String decimalInputString = decimalInput.getText().toString();

        if (decimalInputString.isEmpty()) {
            Toast.makeText(this, "Insert a decimal number", Toast.LENGTH_LONG).show();
            return;
        }

        int decimalInteger = Integer.parseInt(decimalInputString);

        TextView binaryOutput = findViewById(R.id.main_binaryOutput);
        String decimalToBinary = Integer.toBinaryString(decimalInteger);
        binaryOutput.setText(decimalToBinary);
    }
}