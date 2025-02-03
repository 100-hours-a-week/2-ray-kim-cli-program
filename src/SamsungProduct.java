public class SamsungProduct extends Product {
    protected String model;

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