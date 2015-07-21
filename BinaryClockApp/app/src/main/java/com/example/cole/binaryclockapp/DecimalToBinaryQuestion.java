package com.example.cole.binaryclockapp;

import java.lang.Math; // header stuff MUST go above the first class

public class DecimalToBinaryQuestion
{
    //**************FIELDS******************

    int number;
    String answer;
    int bits;
    int wrongOne;
    int wrongTwo;

    //**************CONSTRUCTOR******************

    public DecimalToBinaryQuestion(int bits){
        this.bits = bits;
        this.number = (int)(Math.random()* (Math.pow(2,bits)));
        this.answer = outputBinary(this.number, bits);
    }

    //**************MUTATORS/ACCESSORS******************

    public int getNumber(){
        return this.number;
    }
    public String getAnswer(){
        return this.answer;
    }
    public int getBits(){
        return bits;
    }
    //**************METHODS******************

    public String outputBinary(int x, int bits){
        int val = x;
        String temp = "";
        for (int i = bits; i >= 0 ; i-- ){
            if ((val - Math.pow(2,i)) >= 0){
                temp = temp + "1";
                val = val - (int)Math.pow(2, i);
            }
            else
                temp = temp + "0";
        }
        return temp.substring(1);
    }

    public String getWrongOne(){
        int wrongOne = (int)(Math.random()* (Math.pow(2,bits)));
        while(wrongOne == number)
            wrongOne = (int)(Math.random()* (Math.pow(2,bits)));

        return outputBinary(wrongOne, bits);
    }

    public String getWrongTwo(){
        int wrongTwo = (int)(Math.random()* (Math.pow(2,bits)));
        while(wrongTwo == number || wrongTwo == wrongOne)
            wrongOne = (int)(Math.random()* (Math.pow(2,bits)));

        return outputBinary(wrongTwo, bits);
    }

    //*********MAIN*******************************************************
    public static void main(String[] args){
        DecimalToBinaryQuestion b = new DecimalToBinaryQuestion(3);
        System.out.println(b.getNumber());
        System.out.println(b.getAnswer());
        System.out.println(b.getBits());
        System.out.println(b.getWrongOne());
        System.out.println(b.getWrongTwo());
    }

}


