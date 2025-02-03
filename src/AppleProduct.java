public class AppleProduct extends Product {
    protected String model;

    public AppleProduct(String name, int price, String model) {
        super(name, price);
        this.model = model;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("모델: " + model);
    }
}