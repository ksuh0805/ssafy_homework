package com.swexpert.창용마을무리의개수7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	static int N, M;
	static int[] parents;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new HashSet<>();
			parents = new int[N];
			for(int i = 0; i < N; i++) {
				parents[i] = i;
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) {
					int b = Integer.parseInt(st.nextToken());
					union(a - 1, b - 1);
				}
			}
			for(int i = 0; i < N; i++) {
				set.add(findSet(i));
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
