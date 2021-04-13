package com.baekjoon.경비원2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[][] store = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			store[i] = new int[] {d, k};
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int count = 0;
		for(int i = 0; i < n; i++) {
			int a = store[i][0];
			int b = store[i][1];
			if(x == a) count += Math.abs(y - b);
			else if(x == 1) {
				if(a == 2) {
					count += h;
					count += Math.min(y + b, 2 * w - y - b);
				}else if(a == 3) {
					count += y + b;
				}else if(a == 4) {
					count += w - y + b;
				}
			}
			else if(x == 2) {
				if(a == 1) {
					count += h;
					count += Math.min(y + b, 2 * w - y - b);
				}else if(a == 3) {
					count += h - b + y;
				}else if(a == 4) {
					count += w - y + h - b;
				}
				
			}
			else if(x == 3) {
				if(a == 1) {
					count += y + b;
				}else if(a == 2) {
					count += h - y + b;
				}else if(a == 4) {
					count += w;
					count += Math.min(y + b, 2 * h - y - b);
				}
				
			}
			else if(x == 4) {
				if(a == 1) {
					count += y + w - b;
				}else if(a == 2) {
					count += h - y + w - b;
				}else if(a == 3) {
					count += w;
					count += Math.min(y + b, 2 * h - y - b);
				}
				
			}
			
		}
		System.out.println(count);
	}
}