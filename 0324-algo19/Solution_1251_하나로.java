package com.swexpert.하나로1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	static int[] parents;
	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;

		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] islands = new int[N][2];
			ArrayList<Edge> edges = new ArrayList<>();
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					islands[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			double E = Double.parseDouble(br.readLine());
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					double cost = (Math.pow(Math.abs(islands[i][0] - islands[j][0]), 2)
							+ Math.pow(Math.abs(islands[i][1] - islands[j][1]), 2)) * E;
					edges.add(new Edge(i, j, cost));
				}
			}
			parents = new int[N];
			Collections.sort(edges);
			double result = 0;
			int count = 0;
			make();
			for(Edge edge : edges) {
				if(union(edge.from, edge.to)) {
					result += edge.cost;
					if(++count == N - 1) break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(result));
		}
	}
	static void make() {
		for(int i = 0; i < parents.length; i++) {
			parents[i] = i;
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
