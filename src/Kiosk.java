import java.util.*;
import java.util.stream.IntStream;

public class Kiosk {

    private List<Menu> category = new ArrayList<>();
    private List<ShoppingCart> cart = new ArrayList<>();

    void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 카테고리 출력
            showMainMenu();

            //카트가 null이 아니라면 orderMenu 출력
            if (IsNotNull(cart)) {
                showOrderMenu();
            }

            System.out.print("입력: ");

            // 입력받은 값이 숫자인지 검증
            String input = scanner.nextLine();
            if (isNotNumber(input)){
                continue;
            }
            int category = Integer.parseInt(input);

            //입력받은 카테고리 숫자에 따라 세부 메뉴 호출
            if (category == 1 || category == 2 || category == 3) {

                Menu menu = showMenu(category);

                //숫자인지 검증
                input = scanner.nextLine();
                if (isNotNumber(input)) {
                    continue;
                }
                int menuChoice = Integer.parseInt(input);

                if (menuChoice == 0) {
                    System.out.println("이전 페이지로 돌아갑니다.");
                    continue;
                }

                //입력받은 숫자가 menuItem의 size보다 클 때 예외처리
                MenuItem menuItem = chosenMenu(menu, menuChoice);

                // 입력받은 값이 숫자인지 검증
                input = scanner.nextLine();
                if (isNotNumber(input)) {
                    continue;
                }
                int cartChoice = Integer.parseInt(input);

                //입력받은 값에 따라 장바구니에 선택한 메뉴 추가
                if (cartChoice == 1) {
                    addToCart(menuItem);
                } else if (cartChoice == 2 || cartChoice == 0) {
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    continue;
                } else {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }

            }

            //카트에 들어있는 품목 보여준 후 주문할지 물어보기
            if (category == 4) {
                double totalAmount = showOrder();

                // 입력받은 값이 숫자인지 검증
                input = scanner.nextLine();
                if (isNotNumber(input)) {
                    continue;
                }
                int orderDecision = Integer.parseInt(input);

                //1번 선택 시 계산 로직 실행
                if (orderDecision == 1) {
                    System.out.println("할인 정보를 입력해주세요");
                    for (DiscountPercent value : DiscountPercent.values()) { //enum을 통해 할인율 보여주기
                        System.out.println(value.toString());
                    }
                    System.out.print("입력: ");

                    // 입력받은 값이 숫자인지 검증
                    input = scanner.nextLine();
                    if (isNotNumber(input)) {
                        continue;
                    }
                    int discountOption = Integer.parseInt(input);

                    //최종 결제금액 출력
                    String discountAmount = DiscountPercent.values()[discountOption - 1].getDiscountAmount(totalAmount);
                    System.out.println("주문이 완료되었습니다. 금액은 ₩" + discountAmount + " 입니다.");
                    break;

                    //2번이나 다른 번호 입력시 다시 메뉴 화면으로 되돌아가기
                } else if (orderDecision == 2) {
                    System.out.println("메뉴 화면으로 돌아갑니다");
                    continue;
                } else {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
            }

            //5를 입력받으면 장바구니 비우기
            if (category == 5) {
                cart.clear();
                System.out.println("장바구니를 비웠습니다.");
                continue;
            }

            //0을 입력받으면 프로그램 종료
            if (category == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    void addCategory(Menu menu) {
        category.add(menu);
    }

    void showMainMenu() { //카테고리 보여주기
        System.out.println("[MAIN MENU]");
        IntStream.range(0, category.size())
                .mapToObj(i -> (i + 1) + ". " + category.get(i))
                .forEach(System.out::println);
        System.out.println("0. 종료");
    }

    void showOrderMenu() { //cart가 null 값이 아닐 때 OrderMenu 보여주기
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 장바구니를 비웁니다.");
    }

    boolean IsNotNull(List<ShoppingCart> cart) { //카트가 비어있는지 확인
        if (cart.isEmpty()) {
            return false;
        }
        return true;
    }

    boolean isNotNumber(String input) { //입력받은 숫자가 정수인지 확인
        try {
            int number = Integer.parseInt(input);
            return false; //가독성을 위해 숫자가 맞다면 false를 반환해줬습니다.
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return true;
    }

    Menu showMenu(int chosenCategory) {
        Menu menu = category.get(chosenCategory - 1);
        for (int i = 0; i < menu.getMenu().size(); i++) {
            System.out.println(menu.getMenu().get(i));
        }
        System.out.print("0. 돌아가기\n입력: ");
        return menu;
    }

     MenuItem chosenMenu(Menu menu, int chosenMenu) {
        MenuItem menuItem = null;
        try {
            menuItem = menu.getMenu().get(chosenMenu - 1);
            System.out.println("[" + menuItem.getProductName() + "]" + "을 장바구니에 담으시겠습니까?");
            System.out.print("1. 네 \n2. 아니오\n0. 돌아가기\n입력: ");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return menuItem;
    }

    void addToCart(MenuItem menuItem) {
        cart.add(new ShoppingCart(menuItem.getProductName(), menuItem.getPrice()));
        System.out.println("장바구니에 " + menuItem.getProductName() + "을 추가했습니다.");
    }

    double showOrder() {
        double totalAmount = 0;
        System.out.println("아래와 같이 주문하겠습니까?");
        System.out.println("[Order]");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
            totalAmount += cart.get(i).getPrice();
        }
        System.out.println("[Total]\n₩ " + String.format("%.2f", totalAmount));
        System.out.print("1. 주문하기 2. 돌아가기\n입력: ");
        return totalAmount;
    }
}