// iPhone 클래스 (AppleProduct를 상속)
class iPhone extends AppleProduct {
    String color;

    public iPhone(String name, int price, String model, String color) {
        super(name, price, model);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("색상: " + color);
    }
}