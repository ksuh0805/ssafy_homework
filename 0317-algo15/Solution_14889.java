package com.baekjoon.스타트와링크14889;

import java.util.Scanner;

public class Solution_14889 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] team;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n];
		team = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				team[i][j] = sc.nextInt();
			}
		}
		combination(0, 0);
		System.out.println(min);
	}
	public static void combination(int depth, int idx) {
		if(depth == n/2) {
			int start = 0;
			int link = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					if(visited[i] == true && visited[j] == true) {
						start += team[i][j];
						start += team[j][i];
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					if(visited[i] == false && visited[j] == false) {
						link += team[i][j];
						link += team[j][i];
					}
				}
			}
			min = Math.min(Math.abs(start - link), min);
			return;
		}
		for(int i = idx; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
