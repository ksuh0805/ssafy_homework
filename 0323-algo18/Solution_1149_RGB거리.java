package com.baekjoon.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] rgb = new int[N][3];
		int[][] d = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		d[0][0] = rgb[0][0];
		d[0][1] = rgb[0][1];
		d[0][2] = rgb[0][2];
		for(int i = 1; i < N; i++) {
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + rgb[i][0];
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + rgb[i][1];
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + rgb[i][2];
		}
		
		int answer = Math.min(d[N - 1][0], d[N - 1][1]);
		answer = Math.min(answer, d[N - 1][2]);
		System.out.println(answer);
	}
}
