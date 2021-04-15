package com.swexpert.벽돌깨기5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int[][] map;
	static int N, W, H, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + tc + " " + min);
		}
	}
	// 중복순열
	private static void go(int cnt, int[][] map) {
		if(cnt == N) {
			int result = getRemain(map);
			min = Math.min(min, result);
			return;
		}
		int[][] newMap = new int[H][W];
		for(int c = 0; c < W; c++) {
			int r = 0;
			while(r < H && map[r][c] == 0) ++r;
			if(r == H) { // 벽돌 없음
				go(cnt + 1, map);
			}else {
				// 기존 cnt - 1 구슬까지 상태로 초기화
				newMap = copy(map);
				// 벽돌 깨뜨리기
				boom(newMap, r, c);
				// 벽돌 내리기
				downmap(newMap);
				// 다음 구슬 던지기
				go(cnt + 1, newMap);
			}
		}
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) ++count;
			}
		}
		return count;
	}
	private static void downmap(int[][] map) {
		for(int c = 0; c < W; c++) {
			int r = H - 1;
			while(r >= 0 && map[r][c] == 0) --r;
			if(r < 0) continue; // 다음 열
			
			r = H - 1;
			while(r > 0) { // 자신의 위치에 내리기
				if(map[r][c] == 0) {
					// 직전부터 위쪽 탐색하며 가장 가까운 벽돌 찾기
					int nr = r -1;
					while(nr > 0 && map[nr][c] == 0) --nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}
	}
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		if(map[r][c] > 1) {
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; // 제거
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for(int k = 1; k < p.cnt; k++) {
					nr += dir[d][0];
					nc += dir[d][1];
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	private static int[][] copy(int[][] arr) {
		int[][] temp = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
}
