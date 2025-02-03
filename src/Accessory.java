// 액세서리 클래스
class Accessory {
    String name;
    int price;

    public Accessory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(name + " - " + price + "원");
    }
}