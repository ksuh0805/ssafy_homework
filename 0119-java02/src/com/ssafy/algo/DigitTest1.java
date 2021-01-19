package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] decimal = new int[10];

        while(true){
            int num = sc.nextInt();
            if(num==0) break;

            switch (num/10) {
                case 0:
                    decimal[0]++;
                    break;
                case 1:
                    decimal[1]++;
                    break;
                case 2:
                    decimal[2]++;
                    break;
                case 3:
                    decimal[3]++;
                    break;
                case 4:
                    decimal[4]++;
                    break;
                case 5:
                    decimal[5]++;
                    break;
                case 6:
                    decimal[6]++;
                    break;
                case 7:
                    decimal[7]++;
                    break;
                case 8:
                    decimal[8]++;
                    break;
                case 9:
                    decimal[9]++;
            }
        }

        for(int i=0; i<10; i++){
            int number = decimal[i];
            if(number == 0){
                continue;
            }else{
                System.out.println(i+" : "+number+"개");
            }
        }
    }
}
