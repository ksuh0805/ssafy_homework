package com.baekjoon.쿼드트리1992;

import java.util.Scanner;

public class Solution_1992 {
	static int n;
	static int[][] video;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		video = new int[n][n];
		sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			for(int j = 0; j < n; j++) {
				video[i][j] = s.charAt(j) - '0';
			}
		}
		compress(n, 0, 0);
		System.out.println(sb.toString());
	}
	public static void compress(int num, int r, int c) {
		if(check(num, r, c)) sb.append(video[r][c]);
		else {
			sb.append("(");
			compress(num / 2, r, c);
			compress(num / 2, r, c + (num / 2));
			compress(num / 2, r + (num / 2), c);
			compress(num / 2, r + (num / 2), c + (num / 2));
			sb.append(")");
		}
	}
	public static boolean check(int num, int r, int c) {
		int k = video[r][c];
		for(int i = r; i < r + num; i++) {
			for(int j = c; j < c + num; j++) {
				if(k != video[i][j]) return false;
			}
		}
		return true;
	}
}
