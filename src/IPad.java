public class IPad extends Mobile {
    protected String pencilSupport;  // "1세대", "2세대", "미지원"
    protected String keyboardSupport;  // "Magic Keyboard", "Smart Keyboard", "미지원"

    public IPad(String name, int price, String color, int storage,
                String network, double screenSize, String pencilSupport,
                String keyboardSupport) {
        super(name, price, color, storage, network, screenSize);
        this.pencilSupport = pencilSupport;
        this.keyboardSupport = keyboardSupport;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Apple Pencil 지원: " + pencilSupport);
        System.out.println("키보드 지원: " + keyboardSupport);
    }
}