package com.example.cole.binaryclockapp;

/**
 * Created by cole on 6/20/15.
 */

import java.util.Date;

public class BinaryClock {

    public String hours;
    public String minutes;
    public String seconds;

    public String timeReg;

    //**********CONSTRUCTOR***********

    public BinaryClock(){
        this.getTimeBinary();
    }

    //+++++++++MUTATORS***************

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }

    public String getTimeReg() {
        return timeReg;
    }

    //**********METHODS***************

    public void getTimeBinary(){
        Date d = new Date();
        String s = d.toString();

        hours = this.outputBinary(Integer.parseInt(s.substring(11, 13)), 4);
        minutes = this.outputBinary(Integer.parseInt(s.substring(14, 16)), 5);
        seconds = this.outputBinary(Integer.parseInt(s.substring(17,19)), 5);

        timeReg = s.substring(11, 19);
    }

    public String outputBinary(int num, int bits){
        int val = num;
        String temp = "";
        for (int i = bits; i >= 0 ; i-- ){
            if ((val - Math.pow(2,i)) >= 0){
                temp = temp + "1";
                val = (int) (val - Math.pow(2, i));
            }
            else
                temp = temp + "0";
        }
        return temp;
    }

    @Override
    public String toString(){
        return hours + ":" + minutes + ":" + seconds;
    }


    public static void main(String args[]){
        BinaryClock b = new BinaryClock();
        System.out.println(b.toString());
    }
}
