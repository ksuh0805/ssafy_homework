package com.jungol.오류교정1037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1037_오류교정 {
	static int n, row, col;
	static int[][] bits;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		bits = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				bits[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		row = -1;
		col = -1;
		rowcheck();
		colcheck();
		if(row == -1 && col == -1) System.out.println("OK");
		else if(row != -1 && col != -1) System.out.println("Change bit ("+ (row + 1) +"," + (col + 1) + ")");
		else System.out.println("Corrupt");
	}
	private static void colcheck() {
		int ccnt = 0;
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				count += bits[j][i];
			}
			if(count % 2 != 0) {
				ccnt++;
				if(ccnt > 1) {
					System.out.println("Corrupt");
					System.exit(0);
				}
				col = i;
			}
		}
	}
	private static void rowcheck() {
		int rcnt = 0;
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				count += bits[i][j];
			}
			if(count % 2 != 0) {
				rcnt++;
				if(rcnt > 1) {
					System.out.println("Corrupt");
					System.exit(0);
				}
				row = i;
			}
		}
		
	}
	
}
