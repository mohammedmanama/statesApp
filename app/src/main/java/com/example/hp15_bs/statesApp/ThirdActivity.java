package com.example.hp15_bs.statesApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.HashMap;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Egypt","egypt");
        hashMap.put("France","france");
        hashMap.put("Jordan","jordan");
        hashMap.put("Palestin","palestin");
        hashMap.put("Syria","syria");


        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        String file = hashMap.get(country);
        int countryI = getResources().getIdentifier(file,"drawable",getPackageName());
        ImageView imageView = findViewById(R.id.imageView);

        imageView.setImageResource(countryI);

    }
}
