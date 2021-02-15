package com.baekjoon.백설공주와일곱난쟁이3040;

import java.util.Scanner;

public class Solution_3040 {
	static int[] arr, nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		nums = new int[7];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0,0);
	}
	public static void combination(int depth, int start) {
		if(depth == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += nums[i];
			}
			if(sum == 100)
				for(int val : nums) System.out.println(val);
			return;
		}
		for(int i = start; i < 9; i++) {
			nums[depth] = arr[i];
			combination(depth + 1, i + 1);
		}
	}
}
