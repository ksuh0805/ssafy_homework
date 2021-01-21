package com.ssafy.clazz;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TV[] tvs = new TV[3];
        Refrigerator[] rfrgs = new Refrigerator[3];

        int pos_t = 0;
        int pos_r = 0;

        while(true) {
            System.out.println("------------------------------");
            System.out.println("1. 조회      2. 등록     0. 종료");
            System.out.print("입력 : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("조회하기");
                    System.out.println("1. TV  2. 냉장고");
                    System.out.print("입력 : ");
                    int ch1 = Integer.parseInt(sc.nextLine());
                    if (ch1 == 1) {
                        for (int i = 0; i < pos_t; i++) {
                            TV tv = tvs[i];
                            System.out.println(tv.info());
                        }
                        if(pos_t == 0) {
                            System.out.println("등록된 TV 정보가 없습니다.");
                        }
                        break;
                    } else {
                        for (int i = 0; i < pos_r; i++) {
                            Refrigerator rfrg = rfrgs[i];
                            System.out.println(rfrg.info());
                        }
                        if(pos_r == 0) {
                            System.out.println("등록된 냉장고 정보가 없습니다.");
                        }
                        break;
                    }

                case 2:
                    System.out.println("등록하기");
                    System.out.println("1. TV  2. 냉장고");
                    System.out.print("입력 : ");
                    int ch2 = Integer.parseInt(sc.nextLine());
                    if (ch2 == 1) {
                        System.out.println("TV 정보 등록");
                        System.out.print("제품 번호 : ");
                        int number = Integer.parseInt(sc.nextLine());
                        System.out.print("이름 : ");
                        String name = sc.nextLine();
                        System.out.print("가격 : ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.print("수량 : ");
                        int count = Integer.parseInt(sc.nextLine());
                        System.out.print("인치 : ");
                        int inch = Integer.parseInt(sc.nextLine());
                        System.out.print("디스플레이 타입 : ");
                        String type = sc.nextLine();

                        TV tv = new TV();
                        tv.setName(name);
                        tv.setCount(count);
                        tv.setDisplayType(type);
                        tv.setInch(inch);
                        tv.setPrice(price);
                        tv.setProductNum(number);
                        tvs[pos_t] = tv;
                        pos_t++;
                        System.out.println("TV가 등록되었습니다.");

                        break;
                    } else {
                        System.out.println("냉장고 정보 등록");
                        System.out.print("제품 번호 : ");
                        int number = Integer.parseInt(sc.nextLine());
                        System.out.print("이름 : ");
                        String name = sc.nextLine();
                        System.out.print("가격 : ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.print("수량 : ");
                        int count = Integer.parseInt(sc.nextLine());
                        System.out.print("용량 : ");
                        int vol = Integer.parseInt(sc.nextLine());

                        Refrigerator rfrg = new Refrigerator();
                        rfrg.setName(name);
                        rfrg.setCount(count);
                        rfrg.setVolume(vol);
                        rfrg.setPrice(price);
                        rfrg.setProductNum(number);
                        rfrgs[pos_r] = rfrg;
                        pos_r++;
                        System.out.println("냉장고가 등록되었습니다.");

                        break;
                    }
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }
        }
    }
}
