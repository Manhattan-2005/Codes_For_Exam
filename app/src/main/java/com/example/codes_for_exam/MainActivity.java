package com.example.codes_for_exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.currentLocation)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity(CurrentLocation.class);
            }
        });

        ((Button) findViewById(R.id.geocoding)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity(GeoCoding_And_ReverseGeoCoding.class);
            }
        });

        ((Button) findViewById(R.id.sourceDestination)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity(Source_To_Destination.class);
            }
        });

        ((Button) findViewById(R.id.customToast)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity(Custom_Toast.class);
            }
        });

    }

    public void OpenActivity(Class activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
    
}
