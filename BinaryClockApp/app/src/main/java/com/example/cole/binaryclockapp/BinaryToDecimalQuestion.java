package com.example.cole.binaryclockapp;

import java.lang.Math; // header stuff MUST go above the first class


public class BinaryToDecimalQuestion
{

    //**************FIELDS******************

    String number;
    int answer;
    int bits;
    int wrongOne;
    int wrongTwo;

    //**************CONSTRUCTOR******************

    public BinaryToDecimalQuestion(int bits){
        this.bits = bits;
        this.number = outputBinary((int)(Math.random()* (Math.pow(2,bits))),bits);
        this.answer = Integer.parseInt(number,2);
    }

    //**************MUTATORS/ACCESSORS******************

    public String getNumber(){
        return this.number;
    }
    public int getAnswer(){
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

    public int getWrongOne(){
        int wrongOne = (int)(Math.random()* (Math.pow(2,bits)));
        while(wrongOne == answer)
            wrongOne = (int)(Math.random()* (Math.pow(2,bits)));

        return wrongOne;
    }

    public int getWrongTwo(){
        int wrongTwo = (int)(Math.random()* (Math.pow(2,bits)));
        while(wrongTwo == answer || wrongTwo == wrongOne)
            wrongOne = (int)(Math.random()* (Math.pow(2,bits)));

        return wrongTwo;
    }

    //*********MAIN*******************************************************
    public static void main(String[] args){
        BinaryToDecimalQuestion b = new BinaryToDecimalQuestion(3);
        System.out.println(b.getNumber());
        System.out.println(b.getAnswer());
        System.out.println(b.getBits());
        System.out.println(b.getWrongOne());
        System.out.println(b.getWrongTwo());
    }

}
