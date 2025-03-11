import java.util.*;

public class Kiosk {

    List<Menu> category = new ArrayList<>();
    List<Cart> cart = new ArrayList<>();

    void start() {

        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문 시작
        while (true) {

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[MAIN MENU]");

            for (int i = 0; i < category.size(); i++) {
                System.out.println((i + 1) + ". " + category.get(i));
            }

            System.out.print("0. 종료\n입력: ");

            // 숫자 검증
            String inputCategory = scanner.nextLine();
            if (isNotNumber(inputCategory)){
                continue;
            }
            int categoryNumber = Integer.parseInt(inputCategory);

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
            if (categoryNumber == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Menu menu = category.get(categoryNumber - 1);

            try {
                for (int i = 0; i < menu.getMenu().size(); i++) {
                    System.out.println(menu.getMenu().get(i));
                }
                System.out.println("0. 돌아가기");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
                continue;
            }

            //입력받은 숫자가 정수가 아닐 때 예외처리
            String inputMenu = scanner.nextLine();
            if (isNotNumber(inputMenu)) {
                continue;
            }
            int choiceMenu = Integer.parseInt(inputMenu);

            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
            if (choiceMenu == 0) {
                System.out.println("이전 페이지로 돌아갑니다.");
                continue;
            }

            try {
                MenuItem menuItem = menu.getMenu().get(choiceMenu - 1);
                System.out.println("[" + menuItem.getProductName() + "]" + "을 장바구니에 담으시겠습니까?");
                System.out.println("1. 네 \n2. 아니오\n0. 돌아가기");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }



        }
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
}