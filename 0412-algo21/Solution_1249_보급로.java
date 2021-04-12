package com.swexpert.보급로1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로 {
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int N;
	static int[][] map, d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			d = new int[N][N];
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs();
			System.out.println("#" + tc + " " + d[N - 1][N - 1]);
		}
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 0});
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();
			int x = loc[0];
			int y = loc[1];

			for(int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				int sum = loc[2] + map[nx][ny];
				if(d[nx][ny] <= sum) continue;
				d[nx][ny] = sum;
				queue.offer(new int[] {nx, ny, sum});
			}
		}
		
	}
}
