package com.example.eriq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private EditText userInput;
    private TextView convertedText;
    private String spValue1;
    private String spValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userInput = findViewById(R.id.userInput);
        convertedText = findViewById(R.id.convertedText);
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //This method checks the position of the first spinner
                //Assigns a value to a variable
                //Variable is used for decision making in onTextChanged method
                String text = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
                if(i == 0){
                    spValue1 = "meter";
                } else if(i == 1){
                    spValue1 = "centimeter";
                } else if(i == 2){
                    spValue1 = "inch";
                } else if(i == 3){
                    spValue1 = "foot";
                }
                convertedText.setText("......................");
                userInput.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //This method checks the position of the second spinner
                //Assigns a value to a variable
                //Variable is used for decision making in onTextChanged method
                String text = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
                if(i == 0){
                    spValue2 = "meter";
                } else if(i == 1){
                    spValue2 = "centimeter";
                } else if(i == 2){
                spValue2 = "inch";
                } else if(i == 3){
                    spValue2 = "foot";
                }
                convertedText.setText("......................");
                userInput.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        userInput.addTextChangedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence text, int i, int i1, int i2) {
        //This method takes variables that were determined in the two onItemSelected methods for the two spinners
        //Checks if the text length is greater than 0 and then compares spinner values
        //Performs calculation based on spinner values and assigns result to the convertedText TextView variable
        if(text.length() > 0){
            double amount = Double.parseDouble(text.toString());
            double amountValue;
            if(spValue1.equals("meter") && spValue2.equals("meter")){
                amountValue = amount;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("meter") && spValue2.equals("centimeter")) {
                amountValue = amount * 100;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("meter") && spValue2.equals("inch")) {
                amountValue = amount * 39.37;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("meter") && spValue2.equals("foot")) {
                amountValue = amount * 3.28084;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("centimeter") && spValue2.equals("meter")) {
                amountValue = amount / 100;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("centimeter") && spValue2.equals("centimeter")) {
                amountValue = amount;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("centimeter") && spValue2.equals("inch")) {
                amountValue = amount / 2.54;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("centimeter") && spValue2.equals("foot")) {
                amountValue = amount / 30.48;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("inch") && spValue2.equals("meter")) {
                amountValue = amount / 39.37;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("inch") && spValue2.equals("centimeter")) {
                amountValue = amount * 2.54;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("inch") && spValue2.equals("inch")) {
                amountValue = amount;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("inch") && spValue2.equals("foot")) {
                amountValue = amount / 12;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("foot") && spValue2.equals("meter")) {
                amountValue = amount / 3.28084;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("foot") && spValue2.equals("centimeter")) {
                amountValue = amount * 30.48;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("foot") && spValue2.equals("inch")) {
                amountValue = amount * 12;
                convertedText.setText(String.valueOf(amountValue));
            } else
            if(spValue1.equals("foot") && spValue2.equals("foot")) {
                amountValue = amount;
                convertedText.setText(String.valueOf(amountValue));
            }
        } else {
            convertedText.setText("......................");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
