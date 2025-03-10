import java.util.*;

public class Kiosk {

    List<Menu> category = new ArrayList<>();

    void start() {

        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문 시작
        while (true) {

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            showCategory();

            // 숫자 입력 받기
            int categoryNum = isNum(scanner);

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력

            // 숫자 입력 받기
            // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기

        }
    }

    void addCategory(Menu menu) {
        category.add(menu);
    }

    void showCategory() {
        System.out.println("[MAIN MENU]");

        for (int i = 0; i < category.size(); i++) {
            System.out.println((i + 1) + ". " + category.get(i));
        }

        System.out.print("0. 종료\n입력: ");
    }

    int isNum(Scanner scanner) {
        int number;
        while (true) {
            try {
                number = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("잘못된 입력입니다. 다시 입력해주세요: ");
            }
        }
        return number;
    }

}