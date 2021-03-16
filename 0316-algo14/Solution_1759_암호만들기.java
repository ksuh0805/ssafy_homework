package com.baekjoon.암호만들기1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1759_암호만들기 {
	static int L, C;
	static char[] alpha, pwd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		pwd = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		
		combination(0, 0);
	}
	private static void combination(int depth, int start) {
		if(depth == L) {
			int vcnt = 0;
			int ccnt = 0;
			for(int i = 0; i < L; i++) {
				int c = pwd[i];
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vcnt++;
				else ccnt++;
			}
			if(vcnt < 1 || ccnt < 2) return;
			else {
				for(int i = 0; i < L; i++) {
					System.out.print(pwd[i]);
				}
				System.out.println();
				return;
			}
		}
		for(int i = start; i < C; i++) {
			pwd[depth] = alpha[i];
			combination(depth + 1, i + 1);
		}
	}
}
