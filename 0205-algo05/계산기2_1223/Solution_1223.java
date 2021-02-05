package com.swexpert.계산기2_1223;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1223 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			int n = sc.nextInt();
			char[] inputs = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			ArrayList<Character> list = new ArrayList<>();
			Stack<Integer> stack_post = new Stack<>();
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				char c = inputs[i];
				if(c != '+' && c != '*') list.add(c);
				else if(c == '+') {
					while(!stack.isEmpty()) {
						list.add(stack.pop());
					}
					stack.push(c);
				}else stack.push(c);
			}
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
			for(int i = 0; i < n; i++) {
				char c = list.get(i);
				if(c != '+' && c != '*') stack_post.push(c - '0');
				else if(c == '+') {
					int num = stack_post.pop() + stack_post.pop();
					stack_post.push(num);
				}else {
					int num = stack_post.pop() * stack_post.pop();
					stack_post.push(num);
				}
			}
			System.out.println("#"+ T + " " + stack_post.pop());
		}
	}
}
