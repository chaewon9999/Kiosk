import java.util.*;

public class Kiosk {

    List<Menu> category = new ArrayList<>();
    List<Cart> cart = new ArrayList<>();

    void start() {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문 시작
        while (true) {

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력, cart가 null이 아니라면 orderMenu 출력
            showMainMenu();

            if (cartIsNotNull(cart)) {
                showOrderMenu();
            }
            System.out.print("입력: ");

            // 숫자 검증 (정수가 아니면 continue)
            String categoryChoice = scanner.nextLine();
            if (isNotNumber(categoryChoice)){
                continue;
            }
            int chosenCategory = Integer.parseInt(categoryChoice);

            //입력받은 카테고리 세부 메뉴 호출
            if (chosenCategory == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //입력받은 숫자가 menu의 size볻 클 때 예외처리
            Menu menu = null;
            try {
                menu = category.get(chosenCategory - 1);
                for (int i = 0; i < menu.getMenu().size(); i++) {
                    System.out.println(menu.getMenu().get(i));
                }
                System.out.print("0. 돌아가기\n입력: ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
                continue;
            }

            // 숫자 검증 (정수가 아니면 continue)
            String menuChoice = scanner.nextLine();
            if (isNotNumber(menuChoice)) {
                continue;
            }
            int chosenMenu = Integer.parseInt(menuChoice);

            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
            if (chosenMenu == 0) {
                System.out.println("이전 페이지로 돌아갑니다.");
                continue;
            }

            //입력받은 숫자가 menuItem의 size보다 클 때 예외처리
            MenuItem menuItem = null;
            try {
                menuItem = menu.getMenu().get(chosenMenu - 1);
                System.out.println("[" + menuItem.getProductName() + "]" + "을 장바구니에 담으시겠습니까?");
                System.out.print("1. 네 \n2. 아니오\n0. 돌아가기\n입력: ");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

            // 숫자 검증 (정수가 아니면 continue)
            String userChoice = scanner.nextLine();
            if (isNotNumber(userChoice)) {
                continue;
            }
            int addToCart = Integer.parseInt(userChoice);

            //입력받은 값에 따라 장바구니에 선택한 메뉴 추가
            if (addToCart == 1) {
                cart.add(new Cart(menuItem.getProductName(), menuItem.getPrice()));
                System.out.println("장바구니에 " + menuItem.getProductName() + "을 추가했습니다.");
            } else if (addToCart == 2 || addToCart == 0) {
                continue;
            } else{
                System.out.println("잘못된 입력입니다.");
                continue;
            }


        }
    }

    private void showMainMenu() {
        System.out.println("[MAIN MENU]");
        for (int i = 0; i < category.size(); i++) {
            System.out.println((i + 1) + ". " + category.get(i));
        }
        System.out.println("0. 종료");
    }

    void showOrderMenu() {
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
    }

    void addCategory(Menu menu) {
        category.add(menu);
    }

    /**정수인지 확인**/
    boolean isNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return false; //가독성을 위해 숫자가 맞다면 false를 반환해줬습니다.
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return true;
    }

    boolean cartIsNotNull(List<Cart> cart) {
        if (cart.isEmpty()) {
            return false;
        }
        return true;
    }
}