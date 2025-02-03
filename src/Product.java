public class Product {
    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(formatProductInfo(name, price));
    }

    public int getPrice() {
        return price;
    }

    protected String formatPrice(int price) {
        return String.format("%,d원", price);
    }

    protected String formatProductInfo(String name, int price) {
        return String.format("%s - %s", name, formatPrice(price));
    }
}