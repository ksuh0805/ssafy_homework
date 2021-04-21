package com.baekjoon.키순서2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2458_키순서 {
	static int N, M, count;
	static int [][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 2;
		}
		for(int i = 1; i <= N; i++) {
			bfs(i);
		}
		System.out.println(count);
	}
	private static void bfs(int k) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(k);
		visited[k] = true;
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[a][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		q.offer(k);
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[a][i] == 2 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) return;
		}
		count++;
	}
}
