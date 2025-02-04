public class Product {
    protected String name;
    protected int price;
    protected String color;
    protected int storage;  // GB 단위

    public Product(String name, int price, String color, int storage) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("제품명: " + name);
        System.out.println("가격: " + price + "원");
        System.out.println("색상: " + color);
        System.out.println("저장용량: " + storage + "GB");
    }
}