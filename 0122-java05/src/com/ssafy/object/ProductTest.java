package com.ssafy.object;

import java.util.Scanner;

public class ProductTest {
    ProductMgr productMgr = ProductMgr.getInstance();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        new ProductTest().execute();
    }

    private void execute() {
        while(true){
            switch (menu()){
                case 1: list(); break;
                case 2: register(); break;
                case 3: search(); break;
                case 4: remove(); break;
                case 5: under(); break;
                case 0: finish();
                default:
                    System.out.println("해당 메뉴는 존재하지 않습니다");
            }
        }
    }

    private void remove() {
        System.out.print("삭제할 제품 번호 : ");
        productMgr.remove(Integer.parseInt(sc.nextLine()));
    }

    private void register() {
        productMgr.add(new Product(getInt("제품 번호 : " ),
                getString("제품 이름 : "),
                getInt("제품 가격 : "),
                getInt("수량 : "))
        );
    }

    private String getString(String s) {
        System.out.print(s);
        return sc.nextLine();
    }

    private int getInt(String s) {
        System.out.print(s);
        return Integer.parseInt(sc.nextLine());
    }

    private void search() {
        System.out.print("검색할 제품 번호 : ");
        Product p = productMgr.list(Integer.parseInt(sc.nextLine()));
        if(p != null) {
            System.out.println(p);
        }
    }

    private void list() {
        for(Product p : productMgr.list()){
            System.out.println(p);
        }
    }

    private void under() {
        System.out.print("얼마 이하 제품을 겁색하시겠습니까? ");
        for(Product p : productMgr.priceList(Integer.parseInt(sc.nextLine()))){
            System.out.println(p);
        }
    }

    private int menu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("메뉴 선택");
        System.out.println("1. 조회  2. 등록  3. 검색  4. 삭제  5. 특정 가격 이하 검색  0. 종료");
        System.out.print("입력 : ");
        return Integer.parseInt(sc.nextLine());
    }

    private void finish() {
        System.out.println("프로그램이 종료되었습니다");
        System.exit(0);
    }
}
