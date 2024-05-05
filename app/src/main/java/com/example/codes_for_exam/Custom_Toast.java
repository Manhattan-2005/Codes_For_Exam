package com.example.codes_for_exam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Custom_Toast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        // Find buttons by their IDs
        findViewById(R.id.buttonRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCustomToast(Color.RED);
            }
        });

        findViewById(R.id.buttonBlue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCustomToast(Color.GREEN);
            }
        });

        findViewById(R.id.buttonGreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCustomToast(Color.BLUE);
            }
        });

        findViewById(R.id.buttonYellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCustomToast(Color.YELLOW);
            }
        });
    }

    // Method to display custom toast with specified background color
    private void displayCustomToast(int backgroundColor) {
        View layout = getLayoutInflater().inflate(R.layout.custom_toast_layout, null);

        // Set background color
        layout.setBackgroundColor(backgroundColor);

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
