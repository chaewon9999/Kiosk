import java.util.*;

import static java.awt.SystemColor.menu;

public class Kiosk {

    private String categoryName;
    Map<String, Menu> category = new HashMap<>();

    void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            showCategory();
            int categoryNum = isNum(scanner);

            if (categoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            showMenu(categoryNum);


        }
    }

    void addCategory(String categoryName, Menu menu) {
        this.categoryName = categoryName;
        category.put(categoryName, menu);
    }

    void showCategory() {
        System.out.println("[MAIN MENU]");

        List<String> keys = new ArrayList<>(category.keySet());
        for (int i = 0; i < keys.size(); i++) {
            System.out.println((i + 1) + ". " + keys.get(i));
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

    void showMenu(int index) {
        List<String> keys = new ArrayList<>(category.keySet());

        System.out.println("[" + keys.get(index - 1) + " MENU]");

        System.out.println("0. 뒤로가기");
    }
}