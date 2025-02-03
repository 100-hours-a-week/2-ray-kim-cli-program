// 삼성 제품 클래스 (Product를 상속)
class SamsungProduct extends Product {
    String model;

    public SamsungProduct(String name, int price, String model) {
        super(name, price);
        this.model = model;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("모델: " + model);
    }
}
