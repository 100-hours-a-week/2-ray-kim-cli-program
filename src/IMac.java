public class IMac extends Computer {
    protected double displaySize; // 인치
    protected String ethernet;    // "기가비트 이더넷" 또는 "없음"

    public IMac(String name, int price, String color, int storage,
                String cpu, int ram, double displaySize, String ethernet) {
        super(name, price, color, storage, cpu, ram);
        this.displaySize = displaySize;
        this.ethernet = ethernet;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("디스플레이: " + displaySize + "인치");
        System.out.println("이더넷: " + ethernet);
    }
}