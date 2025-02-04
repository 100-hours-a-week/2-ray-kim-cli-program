// AppleStore.java
import java.util.ArrayList;
import java.util.List;

public class AppleStore {
    private List<Product> inventory;

    public AppleStore() {
        inventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // iMac
        inventory.add(new IMac("iMac 24", 1890000, "블루", 256,
                "M1", 8, 24.0, "기가비트 이더넷"));
        inventory.add(new IMac("iMac 24", 2290000, "실버", 512,
                "M1", 16, 24.0, "없음"));

        // MacBook
        inventory.add(new MacBook("MacBook Pro 14", 2890000, "스페이스 그레이", 512,
                "M4 Pro", 16, "Pro", 1.6, "나노텍스처 글래스"));
        inventory.add(new MacBook("MacBook Air", 1890000, "미드나이트", 256,
                "M4", 8, "Air", 1.24, "일반"));

        // iPad
        inventory.add(new IPad("iPad Pro 12.9\"", 1729000, "실버", 256,
                "WiFi+5G", 12.9, "4세대", "Magic Keyboard"));
        inventory.add(new IPad("iPad Air", 929000, "스페이스 그레이", 64,
                "WiFi", 10.9, "4세대", "Magic Keyboard"));

        // iPhone
        inventory.add(new IPhone("iPhone 16 Pro", 1550000, "네추럴 티타늄", 256,
                "5G", 6.1, "A18 Pro", "16 Pro"));
        inventory.add(new IPhone("iPhone 16", 1250000, "화이트", 128,
                "5G", 6.1, "A18", "16"));
    }

    public void displayComputers() {
        System.out.println("\n=== 컴퓨터 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof Computer) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public void displayMobiles() {
        System.out.println("\n=== 모바일 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof Mobile) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public void displayIMacs() {
        System.out.println("\n=== iMac 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof IMac) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public void displayMacBooks() {
        System.out.println("\n=== MacBook 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof MacBook) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public void displayIPhones() {
        System.out.println("\n=== iPhone 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof IPhone) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public void displayIPads() {
        System.out.println("\n=== iPad 제품 목록 ===");
        int index = 1;
        for (Product product : inventory) {
            if (product instanceof IPad) {
                System.out.println("\n" + index + "번 제품:");
                product.displayInfo();
                System.out.println("---------------");
                index++;
            }
        }
    }

    public Product getComputerByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof Computer) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public Product getMobileByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof Mobile) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public Product getIMacByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof IMac) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public Product getMacBookByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof MacBook) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public Product getIPhoneByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof IPhone) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public Product getIPadByIndex(int index) {
        int currentIndex = 1;
        for (Product product : inventory) {
            if (product instanceof IPad) {
                if (currentIndex == index) {
                    return product;
                }
                currentIndex++;
            }
        }
        return null;
    }

    public void purchaseProduct(Product product) {
        if (product != null) {
            System.out.println("\n=== 구매가 완료되었습니다 ===");
            System.out.println("구매하신 제품 정보:");
            product.displayInfo();
        } else {
            System.out.println("잘못된 제품 번호입니다.");
        }
    }
}