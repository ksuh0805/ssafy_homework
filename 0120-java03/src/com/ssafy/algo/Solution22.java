package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("src/com/ssafy/algo/input.txt"));
        Scanner sc = new Scanner(System.in);
        int[][] dxdy = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int tc = sc.nextInt();
        for(int n=1; n <= tc; n++){
            int N = sc.nextInt();
            int num = sc.nextInt();
            int count = num;
            int[][] bug = new int[num][3];
            boolean[][] loc = new boolean[N][N];

            for(int i = 0; i < num; i++) {
                for (int j = 0; j < 3; j++) {
                    bug[i][j] = sc.nextInt();
                }
            }
            outer:
            for(int i=0; i<num; i++) {
                int x = bug[i][0];
                int y = bug[i][1];
                int dir = bug[i][2];

                for(int j=3; j>0; j--) {
                    x += j * dxdy[dir - 1][0];
                    y += j * dxdy[dir - 1][1];

                    if (x >= N || x < 0 || y >= N || y < 0) {
                        count--;
                        continue outer;
                    }else if (loc[x][y] == true) {
                        count--;
                        continue outer;
                    }
                }
                loc[x][y] = true;
            }
            System.out.println("#" + n + " " + count);

        }
    }
}
