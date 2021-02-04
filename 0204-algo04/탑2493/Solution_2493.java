package com.baekjoon.탑2493;

import java.util.Scanner;

public class Solution_2493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] towers = new int[cnt];
		for(int i = 0; i < cnt; i++) {
			towers[i] = sc.nextInt();
		}

		for(int i = 0; i < cnt; i++) {
			int ans = 0;
			for(int j = i - 1; j >= 0;  j--) {
				if(towers[j] >= towers[i]) {
					ans = j + 1;
					break;
				}
			}
			System.out.print(ans + " ");
		}
	}
}