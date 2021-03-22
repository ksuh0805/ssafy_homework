package com.baekjoon.찾기1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		
		ArrayList<Integer> list = KMP(T, P);
		System.out.println(list.size());
        
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + 1 + " ");
		}
	}
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for(int i = 1; i < pattern.length(); i++) { 
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	

	public static ArrayList<Integer> KMP(String text, String pattern) {
		
		ArrayList<Integer> list = new ArrayList<>();
		int [] pi = getPi(pattern);
		int textlen = text.length();
		int patternlen = pattern.length();
		int j = 0;
		
		for(int i = 0; i < textlen; i++) {
			while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}if(text.charAt(i)== pattern.charAt(j)) {
				if(j == patternlen - 1) {
					list.add(i - patternlen + 1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		return list;
	}
}
