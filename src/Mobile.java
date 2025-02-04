public class Mobile extends Product {
    protected String network;  // 5G/LTE/WiFi
    protected double screenSize;  // 인치

    public Mobile(String name, int price, String color, int storage,
                  String network, double screenSize) {
        super(name, price, color, storage);
        this.network = network;
        this.screenSize = screenSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("네트워크: " + network);
        System.out.println("화면 크기: " + screenSize + "인치");
    }
}