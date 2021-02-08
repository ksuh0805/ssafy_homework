package com.swexpert.한빈이와SpotMart9229;

import java.util.Scanner;

public class Solution_9229 {
	static int n, m, max;
	static int[] weights;
	static int[] arr = new int[2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			weights = new int[n];
			for(int i = 0; i < n; i++) {
				weights[i] = sc.nextInt();
			}
			max = -1;
			snack(0,0);
			System.out.println("#"+ tc + " " + max);
		}
	}
	public static void snack(int depth, int start) {
		if(depth == 2) {
			int weight = 0;
			for(int i = 0; i < 2; i++) {
				weight += arr[i];
			}
			if(weight <= m) {
				if(weight > max) max = weight;				
			}
			return;
		}
		for(int i = start; i < n; i++) {
			arr[depth] = weights[i];
			snack(depth + 1, i + 1);
		}
	}
}
