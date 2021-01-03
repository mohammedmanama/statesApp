package com.example.hp15_bs.statesApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    int spinnerPosition;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("username")){
                String username = intent.getStringExtra("username");
                TextView usernameTV = findViewById(R.id.textView5);
                usernameTV.setText(username);
            }
        }

        Intent male = getIntent();
        final String input = male.getStringExtra("gender");
        TextView tv = findViewById(R.id.textView4);
        tv.setText(input);
        RadioGroup maleTv = findViewById(R.id.radioGroup);

        final Spinner sp = findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               spinnerPosition=position;
               country = sp.getItemAtPosition(position).toString();
                if(position==0){
                }else {
                    String country = sp.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(),country,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerPosition!=0){
                Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                intent.putExtra("country",country);
                startActivity(intent);}
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
