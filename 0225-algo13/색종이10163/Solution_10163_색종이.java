package com.baekjoon.색종이10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10163_색종이 {
	static int n;
	static int[][] map = new int[102][102];
	static int[][] loc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		loc = new int[n][4];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			loc[i] = new int[] {x, y, w, h};
			for(int j = 102 - y - h; j < 102 - y; j++) {
				for(int k = x; k < x + w; k++) {
					map[j][k] = i;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			int tx = loc[i][0];
			int ty = loc[i][1];
			int tw = loc[i][2];
			int th = loc[i][3];
			int count = 0;
			for(int j = 102 - ty - th; j < 102 - ty; j++) {
				for(int k = tx; k < tx + tw; k++) {
					if(map[j][k] == i) count++;
				}
			}
			System.out.println(count);
		}
	}
}
