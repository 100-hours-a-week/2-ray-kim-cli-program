public class MacBook extends AppleProduct {
    private String storage;

    public MacBook(String name, int price, String model, String storage) {
        super(name, price, model);
        this.storage = storage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("저장 용량: " + storage);
    }
}
