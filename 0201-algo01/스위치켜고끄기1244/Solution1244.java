package com.baekjoon.스위치켜고끄기1244;

import java.util.Scanner;

public class Solution1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] switches = new int[num + 1];
		for(int i = 1; i <= num; i++) {
			switches[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int s = sc.nextInt();
			int number = sc.nextInt();
			if(s == 1) {
				for(int j = 1; j <= num; j++) {
					if(j%number == 0) {
						if(switches[j] == 1) switches[j] = 0;
						else switches[j] = 1;
					}
				}
			}else {
				if(switches[number] == 1) switches[number] = 0;
				else switches[number] = 1;
				int before = number - 1;
				int after = number + 1;
				while(before > 0 && after <= num) {
					if(switches[before] == switches[after]) {
						if(switches[before] == 1) {
							switches[before] = 0;
							switches[after] = 0;
						}else {
							switches[before] = 1;
							switches[after] = 1;
						}
					}else break;
					before--;
					after++;
				}
			}
		}
		for(int i = 1; i < switches.length; i++) {
			System.out.print(switches[i]+ " ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
