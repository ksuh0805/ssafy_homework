package com.swexpert.달팽이숫자1954;

import java.util.Scanner;

public class Solution_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			int num = sc.nextInt();
			int[][] snail = new int[num][num];
			int count = 1;
			
			int x = 0;
			int y = -1;
			int k = 1;
			int l = num;
			while(count <= num*num) {
				for(int i = 0; i < l; i++) {
					y += k;
					snail[x][y] = count++;
				}
				l--;
				for(int i = 0; i < l; i++) {
					x += k;
					snail[x][y] = count++;
				}
				k *= -1;
			}
			
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
