public class GalaxyBook extends SamsungProduct {
    private String storage;

    public GalaxyBook(String name, int price, String model, String storage) {
        super(name, price, model);
        this.storage = storage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("저장 용량: " + storage);
    }
}