package com.java.first;

import java.util.Scanner;

public class Compute {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int multiple = num1*num2;
        int quotient = num1/num2;

        System.out.println("곱 = "+multiple);
        System.out.println("몫 = "+quotient);
    }
}
