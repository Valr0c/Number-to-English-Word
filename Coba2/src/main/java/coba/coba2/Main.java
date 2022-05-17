package coba.coba2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void pisah(ArrayList<Integer> angka, int x){
        if (x > 0) {
            int z = x%10;
            angka.add(z);
            pisah(angka, x/10);
        }
    }
    
    public static String cekPuluhan(int p, int s){
        String nama;
        if (p == 1 && s != 0) {
            switch(s){
                case 1: nama = "Eleven "; break;
                case 2: nama = "Twelve "; break;
                case 3: nama = "Thirteen "; break;
                case 4: nama = "Fourteen "; break;
                case 5: nama = "Fifteen "; break;
                case 6: nama = "Sixteen "; break;
                case 7: nama = "Seventeen "; break;
                case 8: nama = "Eighteen "; break;
                case 9: nama = "Nineteen "; break;
                default: nama = "";
            }
        }else{
            switch(p){
                case 1: nama = "Ten "; break;
                case 2: nama = "Twenty "; break;
                case 3: nama = "Thirty "; break;
                case 4: nama = "Forty "; break;
                case 5: nama = "Fifty "; break;
                case 6: nama = "Sixty "; break;
                case 7: nama = "Seventy "; break;
                case 8: nama = "Eighty "; break;
                case 9: nama = "Ninety "; break;
                default: nama = "";
            }
        }
        return nama;
    }
    
    public static String name(int s){
        String nama;
        switch(s){
            case 1: nama = "One "; break;
            case 2: nama = "Two "; break;
            case 3: nama = "Three "; break;
            case 4: nama = "Four "; break;
            case 5: nama = "Five "; break;
            case 6: nama = "Six "; break;
            case 7: nama = "Seven "; break;
            case 8: nama = "Eigth "; break;
            case 9: nama = "Nine "; break;
            default : nama = "";
        }
        return nama;
    }
    
    public static String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String output = "";
        ArrayList<Integer> angka = new ArrayList<>();
        pisah(angka,num);
        boolean t = false, m = false, b = false;
        for(int i = angka.size()-1; i >= 0; i--){
            if (i == 1 || i == 4 || i == 7 || i == 10) {
                output += cekPuluhan(angka.get(i), angka.get(i-1));
            }else if (i == 3) {
                if (i+1 < angka.size()) {
                    if (angka.get(i+1) != 1) {
                        output += name(angka.get(i));
                    }
                }else{
                    output += name(angka.get(i));
                }
                
                if (i+2 < angka.size() && !t) {
                    if (angka.get(i+2) != 0 && angka.get(i) == 0){
                        output += "Thousand ";
                        t = true;
                    }
                }
                if(i+1 < angka.size() && !t){
                    if (angka.get(i+1) != 0 || angka.get(i) != 0){
                        output += "Thousand ";
                        t = true;
                    }
                }else{
                    if (angka.get(i) != 0){
                        output += "Thousand ";
                        t = true;
                    }
                }
            }else if (i == 6) {
                if (i+1 < angka.size()) {
                    if (angka.get(i+1) != 1) {
                        output += name(angka.get(i));
                    }
                }else{
                    output += name(angka.get(i));
                }
                
                if (i+2 < angka.size() && !m) {
                    if (angka.get(i+2) != 0 && angka.get(i) == 0){
                        output += "Million ";
                        m = true;
                    }
                }
                if(i+1 < angka.size() && !m){
                    if (angka.get(i+1) != 0 || angka.get(i) != 0){
                        output += "Million ";
                        m = true;
                    }
                }else{
                    if (angka.get(i) != 0){
                        output += "Million ";
                        m = true;
                    }
                }
            }else if (i == 9) {
                if (i+1 < angka.size()) {
                    if (angka.get(i+1) != 1) {
                        output += name(angka.get(i));
                    }
                }else{
                    output += name(angka.get(i));
                }
                
                if(i+1 < angka.size() && !b){
                    if (angka.get(i+1) != 0 || angka.get(i) != 0){
                        output += "Billion ";
                        b = true;
                    }
                }else{
                    if (angka.get(i) != 0){
                        output += "Billion ";
                        b = true;
                    }
                }
            }else if (i == 2 || i == 5 || i == 8) {
                output += name(angka.get(i));
                if (angka.get(i) != 0){
                    output += "Hundred ";
                }
            }else{
                if (i+1 < angka.size()) {
                    if (angka.get(i+1) != 1) {
                        output += name(angka.get(i));
                    }
                }else{
                    output += name(angka.get(i));
                }
            }
        }
        
        return output.trim();
    }
    
    public static void main(String[] args) {
        System.out.println(numberToWords(0));
        System.out.println(numberToWords(1));
        System.out.println(numberToWords(10));
        System.out.println(numberToWords(100));
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(10000));
        System.out.println(numberToWords(100000));
        System.out.println(numberToWords(1000000));
        System.out.println(numberToWords(10000000));
        System.out.println(numberToWords(100000000));
        System.out.println(numberToWords(1000000000));
    }
}
