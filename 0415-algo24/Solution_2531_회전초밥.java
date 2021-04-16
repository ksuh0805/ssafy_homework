package com.baekjoon.회전초밥2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2531_회전초밥 {
	static int N, d, k, c, max;
	static int[] sushi, choice;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		choice = new int[k];
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		outer:
		for(int i = 0; i < N + k - 1; i++) {
			for(int j = i, l = 0; j < i + k; j++, l++) {
				int idx = j;
				if(idx >= N) idx -= N;
				choice[l] = sushi[idx];
			}
			Set<Integer> set = new HashSet<>();
			for(int v : choice) {
				set.add(v);
			}
			if(max <= set.size()) {
				max = set.size();
				for(int j = 0; j < k; j++) {
					if(choice[j] == c) continue outer;
				}
				max = set.size() + 1;
			}
		}
		System.out.println(max);
	}
}
