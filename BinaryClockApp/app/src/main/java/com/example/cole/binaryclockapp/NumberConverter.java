package com.example.cole.binaryclockapp;

import java.lang.Math; // header stuff MUST go above the first class


public class NumberConverter
{

    //**************FIELDS******************


    //**************CONSTRUCTOR******************

    public NumberConverter(){}

    //**************MUTATORS/ACCESSORS******************


    //**************METHODS******************

    public String DecimalToBinary(int num){
        return Integer.toString(num,2);
    }

    public String BinaryToDecimal(String num){
        return Integer.parseInt(num, 2) + "";
    }

    public String DecimalToHex(int num){
        return Integer.toHexString(num).toUpperCase();
    }

    public String HexToDecimal(String num){
        return Integer.parseInt(num, 16) + "";
    }

    public String BinaryToHex(String num){
        int decimal = Integer.parseInt(num,2);
        return Integer.toString(decimal,16).toUpperCase();
    }

    public String HexToBinary(String num){
        int decimal = Integer.parseInt(num, 16);
        return Integer.toString(decimal,2);
    }

    //*********MAIN*******************************************************
    public static void main(String[] args){
        NumberConverter n = new NumberConverter();

        System.out.println("10: " + n.DecimalToBinary(10));
        System.out.println("110: " + n.BinaryToDecimal("110"));
        System.out.println("10: " + n.DecimalToHex(10));
        System.out.println("A1: " + n.HexToDecimal("A1"));
        System.out.println("11010: " + n.BinaryToHex("11010"));
        System.out.println("A1: " + n.HexToBinary("A1"));

    }
}
