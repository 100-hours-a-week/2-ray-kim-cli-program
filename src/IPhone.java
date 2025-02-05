public class IPhone extends Mobile {
    protected String chip;
    protected String generation;

    public IPhone(String name, int price, String color, int storage,
                  String network, double screenSize, String chip, String generation) {
        super(name, price, color, storage, network, screenSize);
        this.chip = chip;
        this.generation = generation;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("칩셋: " + chip);
        System.out.println("제품 세대: " + generation);
    }
}