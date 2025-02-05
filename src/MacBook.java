public class MacBook extends Computer {
    protected String model;  // Air/Pro
    protected double weight;  // kg 단위
    protected String displayType;  // "나노텍스처 글래스" 또는 "일반"

    public MacBook(String name, int price, String color, int storage,
                   String cpu, int ram, String model, double weight, String displayType) {
        super(name, price, color, storage, cpu, ram);
        this.model = model;
        this.weight = weight;
        this.displayType = displayType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("모델: MacBook " + model);
        System.out.println("무게: " + weight + "kg");
        System.out.println("디스플레이: " + displayType);
    }
}