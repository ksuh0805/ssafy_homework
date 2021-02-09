package com.baekjoon.색종이2563;

import java.util.Scanner;

public class Solution_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] paper = new boolean[100][100];
		for(int a = 0; a < n; a++) {
			int k = sc.nextInt();
			int l = sc.nextInt();
			for(int i = k; i < k + 10; i++) {
				for(int j = 100-l-10; j < 100-l; j++) {
					paper[i][j] = true;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j]) count++;
			}
		}
		System.out.println(count);
	}
}
