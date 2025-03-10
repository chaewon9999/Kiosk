import java.util.*;

import static java.awt.SystemColor.menu;

public class Kiosk {

    List<Menu> category = new ArrayList<>();

    void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            showCategory();
            int categoryNum = isNum(scanner);

            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


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