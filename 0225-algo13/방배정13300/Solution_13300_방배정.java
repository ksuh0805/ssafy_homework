package com.baekjoon.방배정13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] students = new int[6][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			students[h - 1][g]++;
		}
		int count = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				int t = students[i][j];
				count += t / k;
				if(t % k != 0) count++;
			}
		}
		System.out.println(count);
	}
}
