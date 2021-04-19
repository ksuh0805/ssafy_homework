package com.swexpert.조합5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long M = 1234567891;
			long[] fac = new long[N + 1];
			fac[0] = 1;
			fac[1] = 1;
			for(int i = 2; i < N + 1; i++) {
				fac[i] = (fac[i - 1] * i) % M;
			}
			long denominator = (fac[N - R] * fac[R]) % M;
			long idx = M - 2;
			long denominator2 = 1;
			while(idx > 0) {
				if(idx % 2 == 1) {
					denominator2 *= denominator;
					denominator2 %= M;
				}
				denominator = (denominator * denominator) % M;
				idx /= 2;
			}
			long answer = ((fac[N] % M) * (denominator2 % M)) % M;
			System.out.println("#" + tc + " " + answer);
		}
	}
}
