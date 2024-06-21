package com.toshakbhat.agribot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    Button b1;
    TextView solution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        solution = findViewById(R.id.solutions);
        //b1 = findViewById(R.id.expert);

        String value = getIntent().getStringExtra("response");
        solution.setText(value);

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SuccessActivity.this,ExpertActivity.class);
                startActivity(intent);
            }
        });
        */


    }
}