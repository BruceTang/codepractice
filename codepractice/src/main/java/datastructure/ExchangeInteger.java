package datastructure;

import java.util.Random;

public class ExchangeInteger{

    public static void main(String[] args){

        Integer A = new Integer(2000);
        Integer B = new Integer(3000);
        swap(A,B);
        System.out.println("A:" + A +"\nB:" + B);

    }
    public static void swap(Integer A,Integer B){
        Integer C = A;
        B = C;
        A = B;
    }
}