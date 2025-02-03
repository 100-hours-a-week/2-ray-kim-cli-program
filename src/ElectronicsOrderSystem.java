import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ElectronicsOrderSystem {
    private Scanner scanner;
    private ArrayList<Product> selectedProducts;
    private ArrayList<Accessory> selectedAccessories;
    private int totalPrice;
    private String selectedBrand;

    public ElectronicsOrderSystem() {
        this.scanner = new Scanner(System.in);
        this.selectedProducts = new ArrayList<>();
        this.selectedAccessories = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void start() {
        try {
            selectBrand();
            if (selectedBrand != null) {
                selectProduct();
                selectAccessories();
                showOrderSummary();
                processPayment();
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void selectBrand() {
        while (true) {
            try {
                System.out.println("애플 또는 삼성 제품을 주문하세요!");
                System.out.println("1. 애플 제품");
                System.out.println("2. 삼성 제품");
                System.out.print("원하는 브랜드 번호를 선택하세요: ");

                int choice = getValidIntInput();

                if (choice == 1) {
                    selectedBrand = "Apple";
                    break;
                } else if (choice == 2) {
                    selectedBrand = "Samsung";
                    break;
                } else {
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private void selectProduct() {
        if (selectedBrand.equals("Apple")) {
            selectAppleProduct();
        } else {
            selectSamsungProduct();
        }
    }

    private void selectAppleProduct() {
        System.out.println("1. iPhone");
        System.out.println("2. MacBook");
        System.out.print("원하는 제품 번호를 선택하세요: ");

        int choice = getValidIntInput();

        if (choice == 1) {
            iPhone phone = createIPhone();
            if (phone != null) {
                selectedProducts.add(phone);
                totalPrice += phone.getPrice();
            }
        } else if (choice == 2) {
            MacBook macbook = createMacBook();
            if (macbook != null) {
                selectedProducts.add(macbook);
                totalPrice += macbook.getPrice();
            }
        }
    }

    private iPhone createIPhone() {
        // 모델 선택
        System.out.println("\niPhone 모델을 선택하세요:");
        System.out.println("1. iPhone 16 (1,250,000원)");
        System.out.println("2. iPhone 16 Pro (1,450,000원)");
        System.out.println("3. iPhone 16 Pro Max (1,650,000원)");

        int modelChoice = getValidIntInput();

        String model;
        int basePrice;

        switch (modelChoice) {
            case 1:
                model = "iPhone 16";
                basePrice = 1250000;
                break;
            case 2:
                model = "iPhone 16 Pro";
                basePrice = 1450000;
                break;
            case 3:
                model = "iPhone 16 Pro Max";
                basePrice = 1650000;
                break;
            default:
                return null;
        }

        // 용량 선택
        String[] storageOptions = {"128GB", "256GB", "512GB", "1TB"};
        int[] storagePrices = {0, 150000, 350000, 550000};

        System.out.println("\n저장 용량을 선택하세요:");
        for (int i = 0; i < storageOptions.length; i++) {
            System.out.printf("%d. %s (%s)%n",
                    i + 1,
                    storageOptions[i],
                    i == 0 ? "기본 가격" : "+" + String.format("%,d원", storagePrices[i]));
        }

        int storageChoice = getValidIntInput();
        String storage = storageOptions[storageChoice - 1];
        basePrice += storagePrices[storageChoice - 1];

        // 색상 선택
        String[] colorOptions = {
                "화이트", "블랙", "블루", "핑크"
        };

        System.out.println("\n색상을 선택하세요:");
        for (int i = 0; i < colorOptions.length; i++) {
            System.out.println((i + 1) + ". " + colorOptions[i]);
        }

        int colorChoice = getValidIntInput();
        String color = colorOptions[colorChoice - 1];

        return new iPhone(model, basePrice, model, color, storage);
    }

    private MacBook createMacBook() {
        // MacBook 모델 선택
        System.out.println("\nMacBook 모델을 선택하세요:");
        System.out.println("1. MacBook Air M4 (1,390,000원)");
        System.out.println("2. MacBook Pro 14 M4 (2,390,000원)");
        System.out.println("3. MacBook Pro 16 M4 (3,390,000원)");

        int modelChoice = getValidIntInput();

        String model;
        int basePrice;

        switch (modelChoice) {
            case 1:
                model = "MacBook Air M3";
                basePrice = 1890000;
                break;
            case 2:
                model = "MacBook Pro 14 M3";
                basePrice = 2390000;
                break;
            case 3:
                model = "MacBook Pro 16 M3";
                basePrice = 3390000;
                break;
            default:
                return null;
        }

        // 용량 선택
        String[] storageOptions = {"256GB", "512GB", "1TB", "2TB"};
        int[] storagePrices = {0, 200000, 400000, 800000};

        System.out.println("\n저장 용량을 선택하세요:");
        for (int i = 0; i < storageOptions.length; i++) {
            System.out.printf("%d. %s (%s)%n",
                    i + 1,
                    storageOptions[i],
                    i == 0 ? "기본 가격" : "+" + String.format("%,d원", storagePrices[i]));
        }

        int storageChoice = getValidIntInput();
        String storage = storageOptions[storageChoice - 1];
        basePrice += storagePrices[storageChoice - 1];

        return new MacBook(model, basePrice, model, storage);
    }

    private void selectSamsungProduct() {
        System.out.println("1. Galaxy S25");
        System.out.println("2. Galaxy Book");
        System.out.print("원하는 제품 번호를 선택하세요: ");

        int choice = getValidIntInput();

        if (choice == 1) {
            GalaxyPhone phone = createGalaxyPhone();
            if (phone != null) {
                selectedProducts.add(phone);
                totalPrice += phone.getPrice();
            }
        } else if (choice == 2) {
            GalaxyBook book = createGalaxyBook();
            if (book != null) {
                selectedProducts.add(book);
                totalPrice += book.getPrice();
            }
        }
    }

    private GalaxyPhone createGalaxyPhone() {
        String model = "Galaxy S25";
        int basePrice = 1598500;

        // 용량 선택
        System.out.println("\n저장 용량을 선택하세요:");
        System.out.println("1. 256GB (기본 가격)");
        System.out.println("2. 512GB (+150,000원)");
        System.out.println("3. 1TB (+300,000원)");

        int storageChoice = getValidIntInput();
        String storage;

        switch (storageChoice) {
            case 2:
                storage = "512GB";
                basePrice += 150000;
                break;
            case 3:
                storage = "1TB";
                basePrice += 300000;
                break;
            default:
                storage = "256GB";
        }

        // 색상 선택
        System.out.println("\n색상을 선택하세요:");
        String[] colors = {"티타늄 그레이", "티타늄 블랙", "티타늄 바이올렛", "티타늄 옐로우"};
        for (int i = 0; i < colors.length; i++) {
            System.out.println((i + 1) + ". " + colors[i]);
        }

        int colorChoice = getValidIntInput();
        String color = colors[colorChoice - 1];

        return new GalaxyPhone(model, basePrice, model, color, storage);
    }

    private GalaxyBook createGalaxyBook() {
        // GalaxyBook 모델 선택
        System.out.println("\nGalaxy Book 모델을 선택하세요:");
        System.out.println("1. Galaxy Book4 (1,590,000원)");
        System.out.println("2. Galaxy Book4 Pro (2,190,000원)");
        System.out.println("3. Galaxy Book4 Ultra (3,290,000원)");

        int modelChoice = getValidIntInput();

        String model;
        int basePrice;

        switch (modelChoice) {
            case 1:
                model = "Galaxy Book4";
                basePrice = 1590000;
                break;
            case 2:
                model = "Galaxy Book4 Pro";
                basePrice = 2190000;
                break;
            case 3:
                model = "Galaxy Book4 Ultra";
                basePrice = 3290000;
                break;
            default:
                return null;
        }

        // 용량 선택
        String[] storageOptions = {"256GB", "512GB", "1TB"};
        int[] storagePrices = {0, 200000, 400000};

        System.out.println("\n저장 용량을 선택하세요:");
        for (int i = 0; i < storageOptions.length; i++) {
            System.out.printf("%d. %s (%s)%n",
                    i + 1,
                    storageOptions[i],
                    i == 0 ? "기본 가격" : "+" + String.format("%,d원", storagePrices[i]));
        }

        int storageChoice = getValidIntInput();
        String storage = storageOptions[storageChoice - 1];
        basePrice += storagePrices[storageChoice - 1];

        return new GalaxyBook(model, basePrice, model, storage);
    }

    private void selectAccessories() {
        ArrayList<Accessory> availableAccessories = new ArrayList<>();

        if (selectedBrand.equals("Apple")) {
            availableAccessories.add(new Accessory("AirPods Pro", 359000, "Apple"));
            availableAccessories.add(new Accessory("Apple Watch Series 9", 599000, "Apple"));
        } else {
            availableAccessories.add(new Accessory("Galaxy Buds2 Pro", 299000, "Samsung"));
            availableAccessories.add(new Accessory("Galaxy Watch6", 399000, "Samsung"));
        }

        System.out.println("\n악세서리를 선택하시겠습니까?");
        for (int i = 0; i < availableAccessories.size(); i++) {
            Accessory acc = availableAccessories.get(i);
            System.out.printf("%d. %s - %,d원%n", i + 1, acc.getName(), acc.getPrice());
        }
        System.out.println((availableAccessories.size() + 1) + ". 선택하지 않음");

        int choice = getValidIntInput();
        if (choice <= availableAccessories.size()) {
            Accessory selected = availableAccessories.get(choice - 1);
            selectedAccessories.add(selected);
            totalPrice += selected.getPrice();
        }
    }

    private void showOrderSummary() {
        System.out.println("\n======= 주문 요약 =======");
        System.out.println("선택하신 제품:");
        for (Product product : selectedProducts) {
            product.displayInfo();
            System.out.println("-------------------");
        }

        if (!selectedAccessories.isEmpty()) {
            System.out.println("\n선택하신 액세서리:");
            for (Accessory accessory : selectedAccessories) {
                accessory.displayInfo();
                System.out.println("-------------------");
            }
        }

        System.out.println("\n======= 결제 정보 =======");
        System.out.println("총 금액: " + String.format("%,d원", totalPrice));
    }

    private void processPayment() {
        System.out.print("\n결제하시겠습니까? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.println("\n주문이 완료되었습니다. 감사합니다!");
            System.out.println("주문하신 제품은 곧 배송될 예정입니다.");
        } else {
            System.out.println("\n주문이 취소되었습니다.");
        }
    }

    private int getValidIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                return input;
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 비우기
            }
        }
    }

    public static void main(String[] args) {
        ElectronicsOrderSystem system = new ElectronicsOrderSystem();
        system.start();
    }
}