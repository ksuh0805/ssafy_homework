package com.baekjoon.맥주마시면서걸어가기9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] locations = new int[N + 2][2];
			int[][] adjMatrix = new int[N + 2][N + 2];
			for(int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					locations[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N + 1; i++) {
				for(int j = i + 1; j < N + 2; j++) {
					int dist =  Math.abs(locations[i][0] - locations[j][0]) + Math.abs(locations[i][1] - locations[j][1]);
					if(dist <= 1000) adjMatrix[i][j] = adjMatrix[j][i] = 1;
					else adjMatrix[i][j] = adjMatrix[j][i] = Integer.MAX_VALUE;
				}
			}
			for(int k = 0; k < N + 2; k++) {
				for(int i = 0; i < N + 2; i++) {
					if(i == k) continue;
					for(int j = 0; j < N + 2; j++) {
						if(i == j || k == j) continue;						
						if(adjMatrix[i][k] > 1000 || adjMatrix[k][j] > 1000) continue;
						if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = 1;
						}
					}
				}
			}
			
			System.out.println(adjMatrix[0][N + 1] == 1 ? "happy" : "sad");
		}
	}
}
