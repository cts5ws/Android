package com.example.cole.binaryclockapp;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public final class QuizActivity extends Activity {

    int currentNum = 1;
    String currentCorrect;
    int numCorrect;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        final String type = getIntent().getStringExtra("TYPE");
        final String number = getIntent().getStringExtra("NUMBER");
        final int bits = Integer.parseInt(getIntent().getStringExtra("BITS"));

        this.newQuestion(type,number,bits);


        button = (Button) findViewById(R.id.nextQuestion);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswers();
                if (currentNum == Integer.parseInt(number)) {
                    toNextActivity(Integer.parseInt(number));
                }

                currentNum++;
                newQuestion(type, number, bits);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
            }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
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

    public void checkAnswers(){
        RadioGroup answers = (RadioGroup) this.findViewById(R.id.answers);


        int id= answers.getCheckedRadioButtonId();
        View radioButton = answers.findViewById(id);
        int radioId = answers.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) answers.getChildAt(radioId);
        String selection = (String) btn.getText();

        if(currentCorrect.equals(selection)){
            numCorrect++;
        }
    }

    public void toNextActivity(int num){
        Intent intent = new Intent(this, QuizDone.class);
        intent.putExtra("PERCENTAGE", "You got " + (numCorrect*1.0/num)*100 + "% correct!");
        startActivity(intent);
    }

    public void newQuestion(String type, String number, int bits){
        RadioGroup answers =  (RadioGroup) this.findViewById(R.id.answers);
        answers.clearCheck();

        TextView total = (TextView) this.findViewById(R.id.status);
        total.setText("Number " + currentNum + " of " + number);

        String qNum = "";

        if (type.equals("Decimal-to-Binary")) {
            DecimalToBinaryQuestion d = new DecimalToBinaryQuestion(bits);
            currentCorrect = d.getAnswer();
            TextView question = (TextView) this.findViewById(R.id.question);
            question.setText("Convert " + d.getNumber() + " from decimal to binary");

            int randomNum = 1 + (int) (Math.random() * 3);

            if (randomNum == 1) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionOne);
                answer.setText(d.getAnswer());
                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionTwo);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionThree);
                wrongTwo.setText(d.getWrongTwo());
            } else if (randomNum == 2) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionTwo);
                answer.setText(d.getAnswer());

                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionOne);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionThree);
                wrongTwo.setText(d.getWrongTwo());
            } else if (randomNum == 3) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionThree);
                answer.setText(d.getAnswer());

                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionOne);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionTwo);
                wrongTwo.setText(d.getWrongTwo());
            }
        }
        if (type.equals("Binary-to-Decimal")) {
            BinaryToDecimalQuestion b = new BinaryToDecimalQuestion(bits);
            currentCorrect = b.getAnswer() + "";
            TextView question = (TextView) this.findViewById(R.id.question);
            question.setText("Convert " + b.getNumber() + " from binary to decimal");

            int randomNum = 1 + (int) (Math.random() * 3);

            if (randomNum == 1) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionOne);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionTwo);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionThree);
                wrongTwo.setText(b.getWrongTwo());
            } else if (randomNum == 2) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionTwo);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionOne);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionThree);
                wrongTwo.setText(b.getWrongTwo());
            } else if (randomNum == 3) {
                RadioButton answer = (RadioButton) this.findViewById(R.id.optionThree);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.findViewById(R.id.optionOne);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.findViewById(R.id.optionTwo);
                wrongTwo.setText(b.getWrongTwo());
            }
        }
    }
}
