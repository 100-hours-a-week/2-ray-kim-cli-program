import java.util.Scanner;
import java.util.ArrayList;

public class ElectronicsOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;
        ArrayList<Product> selectedProducts = new ArrayList<>();
        ArrayList<Accessory> selectedAccessories = new ArrayList<>();

        // 메인 메뉴
        System.out.println("애플 또는 삼성 제품을 주문하세요!");
        System.out.println("1. 애플 제품");
        System.out.println("2. 삼성 제품");
        System.out.print("원하는 브랜드 번호를 선택하세요: ");
        int brandChoice = scanner.nextInt();
        scanner.nextLine();  // 개행 문자 처리

        Product selectedProduct = null;

        if (brandChoice == 1) {
            // 애플 제품 선택
            System.out.println("1. iPhone");
            System.out.println("2. MacBook");
            System.out.println("3. 선택하지 않음");
            System.out.print("원하는 애플 제품 번호를 선택하세요: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine();

            if (productChoice == 1) {
                // iPhone 모델 선택
                System.out.println("iPhone 모델을 선택하세요:");
                System.out.println("1. iPhone 16 (1,250,000원)");
                System.out.println("2. iPhone 16 Pro (1,450,000원)");
                System.out.println("3. iPhone 16 Pro Max (1,650,000원)");
                System.out.print("선택: ");
                int modelChoice = scanner.nextInt();
                scanner.nextLine();

                // 용량 선택
                System.out.println("\n저장 용량을 선택하세요:");
                System.out.println("1. 128GB (기본 가격)");
                System.out.println("2. 256GB (+150,000원)");
                System.out.println("3. 512GB (+350,000원)");
                System.out.println("4. 1TB (+550,000원)");
                System.out.print("선택: ");
                int storageChoice = scanner.nextInt();
                scanner.nextLine();

                // 색상 선택
                System.out.println("\n색상을 선택하세요:");
                System.out.println("1. 내추럴 티타늄");
                System.out.println("2. 블루 티타늄");
                System.out.println("3. 화이트 티타늄");
                System.out.println("4. 블랙 티타늄");
                System.out.print("선택: ");
                int colorChoice = scanner.nextInt();
                scanner.nextLine();

                // 가격 설정
                int basePrice = 1250000;
                String modelName = "iPhone 16";

                // 모델별 가격 조정
                switch (modelChoice) {
                    case 2:
                        basePrice = 1450000;
                        modelName = "iPhone 16 Pro";
                        break;
                    case 3:
                        basePrice = 1650000;
                        modelName = "iPhone 16 Pro Max";
                        break;
                }

                // 용량 추가
                String storage = "128GB";
                switch (storageChoice) {
                    case 2:
                        basePrice += 150000;
                        storage = "256GB";
                        break;
                    case 3:
                        basePrice += 350000;
                        storage = "512GB";
                        break;
                    case 4:
                        basePrice += 550000;
                        storage = "1TB";
                        break;
                }

                // 색상 설정
                String color = "내추럴 티타늄";
                switch (colorChoice) {
                    case 2:
                        color = "블루 티타늄";
                        break;
                    case 3:
                        color = "화이트 티타늄";
                        break;
                    case 4:
                        color = "블랙 티타늄";
                        break;
                }

                selectedProduct = new Product(modelName + " (" + storage + ", " + color + ")", basePrice);

            } else if (productChoice == 2) {
                selectedProduct = new Product("MacBook Pro", 2390000);
            } else if (productChoice == 3) {
                System.out.println("제품을 선택하지 않았습니다.");
                return;
            } else {
                System.out.println("잘못된 선택입니다.");
                return;
            }
        } else if (brandChoice == 2) {
            // 삼성 제품 선택
            System.out.println("1. GalaxyPhone");
            System.out.println("2. GalaxyBook");
            System.out.println("3. 선택하지 않음");
            System.out.print("원하는 삼성 제품 번호를 선택하세요: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine();

            if (productChoice == 1) {
                selectedProduct = new Product("Galaxy S23 Ultra", 1100000);
            } else if (productChoice == 2) {
                selectedProduct = new Product("Galaxy Book", 1800000);
            } else if (productChoice == 3) {
                System.out.println("제품을 선택하지 않았습니다.");
                return;
            } else {
                System.out.println("잘못된 선택입니다.");
                return;
            }
        } else {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        selectedProducts.add(selectedProduct);
        totalPrice += selectedProduct.price;

        // 사이드 메뉴 선택
        System.out.println("\n악세서리는 필요 없으신가요?");
        System.out.println("1. AirPods - 249,000원");
        System.out.println("2. Apple Watch - 389,000원");
        System.out.println("3. Galaxy Buds - 149,000원");
        System.out.println("4. Galaxy Watch - 299,000원");
        System.out.println("5. 선택하지 않음");
        System.out.print("구매하실 악세서리 번호를 선택하세요: ");
        int accessoryChoice = scanner.nextInt();
        scanner.nextLine();

        Accessory selectedAccessory = null;

        if (accessoryChoice == 1) {
            selectedAccessory = new Accessory("AirPods", 249000);
        } else if (accessoryChoice == 2) {
            selectedAccessory = new Accessory("Apple Watch", 389000);
        } else if (accessoryChoice == 3) {
            selectedAccessory = new Accessory("Galaxy Buds", 149000);
        } else if (accessoryChoice == 4) {
            selectedAccessory = new Accessory("Galaxy Watch", 299000);
        } else if (accessoryChoice == 5) {
            System.out.println("악세서리를 선택하지 않았습니다.");
        } else {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        if (selectedAccessory != null) {
            selectedAccessories.add(selectedAccessory);
            totalPrice += selectedAccessory.price;
        }

        // 주문 요약 출력
        System.out.println("\n======= 주문 요약 =======");
        System.out.println("선택하신 제품:");
        System.out.println("-------------------");
        for (Product product : selectedProducts) {
            product.displayInfo();
        }

        if (!selectedAccessories.isEmpty()) {
            System.out.println("\n선택하신 액세서리:");
            System.out.println("-------------------");
            for (Accessory accessory : selectedAccessories) {
                accessory.displayInfo();
            }
        }

        System.out.println("\n======= 결제 정보 =======");
        System.out.println("총 금액: " + String.format("%,d", totalPrice) + "원");

        // 결제 단계
        System.out.print("\n결제하시겠습니까? (yes/no): ");
        String paymentChoice = scanner.nextLine();

        if (paymentChoice.equalsIgnoreCase("yes")) {
            System.out.println("\n주문이 완료되었습니다. 감사합니다!");
            System.out.println("주문하신 제품은 곧 배송될 예정입니다.");
        } else {
            System.out.println("\n주문이 취소되었습니다.");
        }

        scanner.close();
    }
}