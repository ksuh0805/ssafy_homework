package com.swexpert.파핑파핑지뢰찾기1868;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N, len0, len, min, cnt;
	static char[][] map;
	static ArrayList<int[]> list0, list;
	static int[][] result;
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1, 1}, {1, -1}, {1,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			result = new int[N][N];
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			min = Integer.MAX_VALUE;
			list0 = new ArrayList<>();
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				outer:
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '*') continue;
					int x = i;
					int y = j;
					for(int d = 0; d < 8; d++) {
						int nx = x + dir[d][0];
						int ny = y + dir[d][1];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(map[nx][ny] == '*') {
							list.add(new int[] {x, y});
							continue outer;
						}
					}
					list0.add(new int[] {x, y});
				}
			}
			len0 = list0.size();
			len = list.size();
			bomb();
			System.out.println("#" + tc + " " + min);
		}
	}
	private static void bomb() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) result[i][j] = -1;
		}
		cnt = 0;
		for(int i = 0; i < len0; i++) {
			int[] loc = list0.get(i);
			int x = loc[0];
			int y = loc[1];
			bfs(x, y);
		}
		remains();
		return;
	}
	private static void remains() {
		for(int i = 0; i < len; i++) {
			int[] loc = list.get(i);
			int x = loc[0];
			int y = loc[1];
			if(result[x][y] != -1) continue;
			cnt++;
			int count = 0;
			for(int d = 0; d < 8; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] == '*') count++;
			}
			result[x][y] = count;
		}
		min = Math.min(min, cnt);
		return;
	}
	// 팔방 지뢰없는 부분 먼저
	private static void bfs(int a, int b) {
		if(result[a][b] == 0) return; // 이미 탐색했으면 스킵
		cnt++; // 클릭
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {a, b});
		result[a][b] = 0; // 방문 표시
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			for(int d = 0; d < 8; d++) { // 팔방 연쇄 검사
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] == '*') continue; // 지뢰면 스킵
				if(result[nx][ny] != -1) continue;
				int count = 0;
				for(int i = 0; i < 8; i++) {
					int mx = nx + dir[i][0];
					int my = ny + dir[i][1];
					if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
					if(map[mx][my] == '*') count++;
				}
				if(count == 0) {
					queue.offer(new int[] {nx, ny});
					result[nx][ny] = 0;
				}
				else result[nx][ny] = count;
			}
		}
	}
}
