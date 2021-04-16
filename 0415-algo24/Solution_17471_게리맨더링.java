package com.baekjoon.게리맨더링17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17471_게리맨더링 {
	static int N, sum, min;
	static int[] popul;
	static boolean[] isSelected;
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		popul = new int[N + 1];
		adjMatrix = new boolean[N + 1][N + 1];
		isSelected = new boolean[N + 1];
		min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
			sum += popul[i];
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[i][to] = true;
			}
		}
		subset(1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	private static void subset(int idx) {
		if(idx == N + 1) {
			check();
			return;
		}
		isSelected[idx] = true;
		subset(idx + 1);
		
		isSelected[idx] = false;
		subset(idx + 1);
	}
	private static void check() {
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) first.add(i);
			else second.add(i);
		}
		if(first.isEmpty() || second.isEmpty()) return;
		if(!connected(first)) return;
		if(!connected(second)) return;
		int sum1 = 0;
		for(int k : first) {
			sum1 += popul[k];
		}
		min = Math.min(min, Math.abs(sum1 - (sum - sum1)));
	}
	private static boolean connected(ArrayList<Integer> list) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(list.get(0));
		visited[list.get(0)] = true;
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[k][i] && !visited[i] && list.contains(i)) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		for(int i : list) {
			if(!visited[i]) return false;
		}
		return true;
	}
}
