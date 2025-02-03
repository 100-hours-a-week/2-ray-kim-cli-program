// MacBook 클래스 (AppleProduct를 상속)
class MacBook extends AppleProduct {
    String storage;

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