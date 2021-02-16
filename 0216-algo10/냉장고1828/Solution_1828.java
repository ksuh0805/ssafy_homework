package com.jungol.냉장고1828;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_1828 {
    public static class temperature implements Comparable<temperature>{
        int min, max;
 
        public temperature(int min, int max) {
            super();
            this.min = min;
            this.max = max;
        }
 
        @Override
        public int compareTo(temperature o) {
            int diff = this.max - o.max;
            return diff != 0 ? diff : this.min - o.min;
        }
         
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        temperature[] temps = new temperature[n];
        for(int i = 0; i < n; i++) {
            temps[i] = new temperature(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(temps);
        int count = 1;
        temperature t = temps[0];
        for(int i = 1 ; i < n; i++) {
            if(t.max < temps[i].min) {
                t = temps[i];
                count++;
            }
        }
        System.out.println(count);
    }
}