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
import android.widget.Spinner;


public class PracticeMode extends Activity {
    Spinner type;
    Spinner number;
    Spinner bits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practice_mode);

        type = (Spinner) findViewById(R.id.typeQuestion);
        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.question_array, android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        type.setAdapter(adapterType);

        number = (Spinner) findViewById(R.id.numQuestions);
        ArrayAdapter<CharSequence> adapterNum = ArrayAdapter.createFromResource(this, R.array.number_array, android.R.layout.simple_spinner_item);
        adapterNum.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        number.setAdapter(adapterNum);

        bits = (Spinner) findViewById(R.id.numBits);
        ArrayAdapter<CharSequence> adapterBits = ArrayAdapter.createFromResource(this, R.array.bit_array, android.R.layout.simple_spinner_item);
        adapterBits.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bits.setAdapter(adapterBits);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practice_mode, menu);
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
    public void toClock(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toQuiz(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("TYPE", type.getSelectedItem().toString());
        intent.putExtra("NUMBER", number.getSelectedItem().toString());
        intent.putExtra("BITS", bits.getSelectedItem().toString());
        startActivity(intent);
    }
}
