package com.baekjoon.알파벳1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1987 {
	static int R, C;
	static int max = Integer.MIN_VALUE;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] board;
	static ArrayList<Character> alpha = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int x, int y) {
		alpha.add(board[x][y]);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			else if(alpha.contains(board[nx][ny])) continue;
			dfs(nx, ny);
			alpha.remove(alpha.size() - 1);
		}
		max = Math.max(max, alpha.size());
		return;
	}
}