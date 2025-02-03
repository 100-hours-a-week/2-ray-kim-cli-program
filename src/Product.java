import java.util.Scanner;

// 기본 제품 클래스
class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(name + " - " + price + "원");
    }
}