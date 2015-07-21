package com.example.cole.binaryclockapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;


public class MainActivity extends Activity {

    Button button;
    public boolean showRegTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(40);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                BinaryClock b = new BinaryClock();

                                String hour = b.getHours();
                                String minute = b.getMinutes();
                                String second = b.getSeconds();

                                String timeReg = b.getTimeReg();

                                TextView hours = (TextView) findViewById(R.id.textView2);
                                hours.setText(hour);

                                TextView minutes = (TextView) findViewById(R.id.textView4);
                                minutes.setText(minute);

                                TextView seconds = (TextView) findViewById(R.id.textView6);
                                seconds.setText(second);

                                if(showRegTime) {
                                    TextView time = (TextView) findViewById(R.id.time);
                                    time.setText(timeReg);
                                    button.setText("Remove Regular Time");
                                }

                                else {
                                    TextView time = (TextView) findViewById(R.id.time);
                                    time.setText("");
                                    button.setText("View Regular Time");
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();


        button = (Button) findViewById(R.id.button1);
        button.setWidth(650);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showRegTime = !showRegTime;
            }
        });

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toConversion(View view){
        Intent intent = new Intent(this, ConversionActivity.class);
        startActivity(intent);
    }

}
