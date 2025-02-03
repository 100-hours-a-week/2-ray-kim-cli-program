class Accessory {
    private String name;
    private int price;
    private String brand;

    public Accessory(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println(String.format("%s - %,d원", name, price));
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}