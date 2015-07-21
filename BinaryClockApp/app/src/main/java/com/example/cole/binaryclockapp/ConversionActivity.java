package com.example.cole.binaryclockapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ConversionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_conversion);

        //spinner settings
        final Spinner spinner = (Spinner) findViewById(R.id.ConOptions);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversion_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(40);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String text = spinner.getSelectedItem().toString();

                                TextView conType = (TextView) findViewById(R.id.ConversionType);
                                conType.setText(text.substring(0,3) + ". Number?");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversion, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toPractice(View view) {
        Intent intent = new Intent(this, PracticeMode.class);
        startActivity(intent);

    }

    public void convert(View view){

        NumberConverter n = new NumberConverter();

        Spinner spinner = (Spinner) findViewById(R.id.ConOptions);
        String text = spinner.getSelectedItem().toString();

        EditText myNum   = (EditText)findViewById(R.id.editText);


        if(text.equals("Decimal-to-Binary")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in binary is " + n.DecimalToBinary(Integer.valueOf(myNum.getText().toString())));
        }
        if(text.equals("Binary-to-Decimal")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in decimal is " + n.BinaryToDecimal(myNum.getText().toString()));
        }
        if(text.equals("Decimal-to-Hex")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in hexadecimal is " + n.DecimalToHex(Integer.valueOf(myNum.getText().toString())));
        }
        if(text.equals("Hex-to-Decimal")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in decimal is " + n.HexToDecimal(myNum.getText().toString()));
        }
        if(text.equals("Binary-to-Hex")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in hexadecimal is " + n.BinaryToHex(myNum.getText().toString()));
        }
        if(text.equals("Hex-to-Binary")){
            TextView finalNum = (TextView) findViewById(R.id.convertedNum);
            finalNum.setText(myNum.getText().toString() + " in binary is " + n.HexToBinary(myNum.getText().toString()));
        }


    }
}