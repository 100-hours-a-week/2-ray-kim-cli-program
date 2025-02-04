import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppleStore store = new AppleStore();

        while (true) {
            System.out.println("\n=== 애플 스토어에 오신 걸 환영합니다! ===");
            System.out.println("1. 컴퓨터");
            System.out.println("2. 모바일");
            System.out.println("3. 프로그램 종료");
            System.out.print("원하시는 카테고리를 선택하세요: ");

            int category = scanner.nextInt();

            if (category == 3) {
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                scanner.close();
                return;
            }

            if (category == 1) {
                System.out.println("\n=== 컴퓨터 카테고리 ===");
                System.out.println("1. iMac");
                System.out.println("2. MacBook");
                System.out.println("3. 이전 메뉴로");
                System.out.print("원하시는 제품군을 선택하세요: ");

                int computerType = scanner.nextInt();
                if (computerType == 3) continue;

                if (computerType == 1) {
                    store.displayIMacs();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIMacByIndex(productIndex));
                } else if (computerType == 2) {
                    store.displayMacBooks();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getMacBookByIndex(productIndex));
                }

            } else if (category == 2) {
                System.out.println("\n=== 모바일 카테고리 ===");
                System.out.println("1. iPhone");
                System.out.println("2. iPad");
                System.out.println("3. 이전 메뉴로");
                System.out.print("원하시는 제품군을 선택하세요: ");

                int mobileType = scanner.nextInt();
                if (mobileType == 3) continue;

                if (mobileType == 1) {
                    store.displayIPhones();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIPhoneByIndex(productIndex));
                } else if (mobileType == 2) {
                    store.displayIPads();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIPadByIndex(productIndex));
                }
            }
        }
    }
}