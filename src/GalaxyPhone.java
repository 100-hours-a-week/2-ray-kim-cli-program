// GalaxyPhone 클래스 (SamsungProduct를 상속)
class GalaxyPhone extends SamsungProduct {
    String color;

    public GalaxyPhone(String name, int price, String model, String color) {
        super(name, price, model);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("색상: " + color);
    }
}