package com.example.eriq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Switch;

import static com.example.eriq.myapplication.R.style;

public class Main2Activity extends AppCompatActivity{
    private Switch changeTheme;
    private GridLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button backButton = findViewById(R.id.backButton);
        changeTheme = findViewById(R.id.changeTheme);
        ll = findViewById(R.id.ll);

        changeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(changeTheme.isChecked()){
                    ll.setBackgroundColor(R.style.darkTheme);
                } else {
                    ll.setBackgroundColor(style.AppTheme);
                }
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}