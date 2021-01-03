package com.example.hp15_bs.statesApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup rg = findViewById(R.id.radioGroup);
        Button startBtn = findViewById(R.id.startBtn);
        final EditText nameEd = findViewById(R.id.nameEd);
        final RadioButton male = findViewById(R.id.maleTv);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEd.getText().toString();
                if (name != null && !name.trim().equals("")) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("username", nameEd.getText().toString());
                    int rgCheckedRadioButtonId = rg.getCheckedRadioButtonId();
                    RadioButton radioButton = findViewById(rgCheckedRadioButtonId);
                    if (radioButton.getText().toString().equals(male.getText().toString())){
                        intent.putExtra("gender", "Mr");
                    }else {
                        intent.putExtra("gender", "Ms");
                    }
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter your name",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}