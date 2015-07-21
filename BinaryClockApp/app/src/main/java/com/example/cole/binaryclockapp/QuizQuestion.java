package com.example.cole.binaryclockapp;

import android.app.Activity;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by cole on 7/10/15.
 */
public class QuizQuestion {
    public Activity activity;
    int currentNum;
    public QuizQuestion(int currentNum, Activity activity){
        this.currentNum = currentNum;
    }

    public void setQuestion(String type, String number, int bits){
        RadioButton optOne = (RadioButton) this.activity.findViewById(R.id.optionOne);
        optOne.setChecked(false);
        RadioButton optTwo = (RadioButton) this.activity.findViewById(R.id.optionTwo);
        optTwo.setChecked(false);
        RadioButton optThree = (RadioButton) this.activity.findViewById(R.id.optionThree);
        optThree.setChecked(false);

        TextView total = (TextView) this.activity.findViewById(R.id.status);
        total.setText("Number " + currentNum + " of " + number);

        String qNum = "";

        if(type.equals("Decimal-to-Binary")){
            DecimalToBinaryQuestion d = new DecimalToBinaryQuestion(bits);
            TextView question = (TextView) this.activity.findViewById(R.id.question);
            question.setText("Convert " + d.getNumber() + " from decimal to binary");

            int randomNum = 1 + (int)(Math.random()*3);

            if(randomNum == 1){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionOne);
                answer.setText(d.getAnswer());
                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionThree);
                wrongTwo.setText(d.getWrongTwo());
            }
            else if(randomNum == 2){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                answer.setText(d.getAnswer());

                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionOne);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionThree);
                wrongTwo.setText(d.getWrongTwo());
            }
            else if(randomNum == 3){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionThree);
                answer.setText(d.getAnswer());

                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionOne);
                wrongOne.setText(d.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                wrongTwo.setText(d.getWrongTwo());
            }
        }
        if(type.equals("Binary-to-Decimal")){
            BinaryToDecimalQuestion b = new BinaryToDecimalQuestion(bits);
            TextView question = (TextView) this.activity.findViewById(R.id.question);
            question.setText("Convert " + b.getNumber() + " from binary to decimal");

            int randomNum = 1 + (int)(Math.random()*3);

            if(randomNum == 1){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionOne);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionThree);
                wrongTwo.setText(b.getWrongTwo());
            }
            else if(randomNum == 2){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionOne);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionThree);
                wrongTwo.setText(b.getWrongTwo());
            }
            else if(randomNum == 3){
                RadioButton answer = (RadioButton) this.activity.findViewById(R.id.optionThree);
                answer.setText(b.getAnswer());

                RadioButton wrongOne = (RadioButton) this.activity.findViewById(R.id.optionOne);
                wrongOne.setText(b.getWrongOne());

                RadioButton wrongTwo = (RadioButton) this.activity.findViewById(R.id.optionTwo);
                wrongTwo.setText(b.getWrongTwo());
            }
        }
    }


}
