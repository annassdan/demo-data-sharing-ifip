package com.example.ifip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_random);
        TextView textView = findViewById(R.id.text_view_ifip);


        button.setOnClickListener(v -> {
            final int random = (int) (Math.random() * 100);
//            Toast.makeText(getApplicationContext(), "SEND A NUMBER: " + String.valueOf(random), Toast.LENGTH_SHORT).show();
            textView.setText("Delivering random : " + random);

            Toast.makeText(getApplicationContext(), "Redirecting in 2 seconds...", Toast.LENGTH_SHORT).show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("IFIP_PROCESS_RESULT", String.valueOf(random));
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }, 2000); // Just delaying 2 second to send response back to host app, just to make sure the process its all good
            // remove dis delay on production mode
        });
    }
}