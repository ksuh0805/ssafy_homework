package com.baekjoon.배열돌리기3_16935;

import java.util.Scanner;

public class Solution_16935 {
	static int n,m;
	static int[][] array;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int r = sc.nextInt();
		int[] operators = new int[r];
		array = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++){
				array[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < r; i++) {
			operators[i] = sc.nextInt();		
		}
		for(int i = 0; i < r; i++) {
			int operator = operators[i];
			switch(operator) {
			case 1 : updown();
					break;
			case 2 : leftright();
					break;
			case 3 : clockwise();
					break;
			case 4 : counterclockwise();
					break;
			case 5 : blockclock();
					break;
			case 6 : blockcounter();
					break;
			}
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}System.out.println();
		}
	}
	
	static void updown() {
		for(int i = 0; i < array.length / 2; i++) {
			int[] temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}
	
	static void leftright() {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length / 2; j++) {
				int temp = array[i][j];
				array[i][j] = array[i][array[0].length - j - 1];
				array[i][array[0].length - j - 1] = temp;
			}
		}
	}
	
	static void clockwise() {
		int[][] newArr = new int[array[0].length][array.length];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				newArr[j][array.length - 1 - i] = array[i][j];
			}
		}
		array = newArr;
	}
	static void counterclockwise() {
		int[][] newArr = new int[array[0].length][array.length];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				newArr[array[0].length - j - 1][i] = array[i][j];
			}
		}
		array = newArr;
	}
	static void blockclock() {
		int[][] newArr = new int[array.length][array[0].length];
		
		int row = array.length;
		int col = array[0].length;
		
		
		for(int i = 0; i < row / 2; i++) {
			for(int j = 0; j < col / 2; j++) {
				newArr[i][j + col / 2] = array[i][j];
			}
		}
		for(int i = 0; i < row / 2; i++) {
			for(int j = col / 2; j < col; j++) {
				newArr[i + row / 2][j] = array[i][j];
			}
		}
		for(int i = row / 2; i < row; i++) {
			for(int j = col / 2; j < col; j++) {
				newArr[i][j - col / 2] = array[i][j];
			}
		}
		for(int i = row / 2; i < row; i++) {
			for(int j = 0; j < col / 2; j++) {
				newArr[i - row / 2][j] = array[i][j];
			}
		}
		
		array = newArr;
	}
	static void blockcounter() {
		int[][] newArr = new int[array.length][array[0].length];
		
		int row = array.length;
		int col = array[0].length;
		
		
		for(int i = 0; i < row / 2; i++) {
			for(int j = 0 ; j < col / 2 ; j++) {
				newArr[i + row / 2][j] = array[i][j];
			}
		}
		for(int i = row / 2; i < row; i++) {
			for(int j = 0 ; j < col / 2 ; j++) {
				newArr[i][j + col / 2] = array[i][j];
			}
		}
		for(int i = row / 2; i < row; i++) {
			for(int j = col / 2 ; j < col ; j++) {
				newArr[i - row / 2][j] = array[i][j];
			}
		}
		for(int i = 0; i < row / 2; i++) {
			for(int j = col / 2 ; j < col ; j++) {
				newArr[i][j - col / 2] = array[i][j];
			}
		}
		
		array = newArr;
	}
	
}
