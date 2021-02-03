package com.swexpert.파리퇴치2001;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2001 {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("/Users/suhyun/SSAFY/workspace/Algorithm/src/com/swexpert/파리퇴치2001/input.txt")); // 파일 입출력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] fly = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			int count = 0;
			outer:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = i; k < i + M; k++) {
						for(int l = j; l < j + M; l++) {
							if(k >= N || l >= N) {
								count = 0;
								continue outer;
							}
							count += fly[k][l];
						}
					}
					if(count > max) max = count;
					count = 0;
				}
			}
			System.out.println("#"+ tc + " " + max);
		}
	}
}
