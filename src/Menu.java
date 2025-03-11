import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 카테고리 이름 필드 추가
    private String name;

    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menu = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addMenu(MenuItem menuItem) {
        menu.add(menuItem);
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public List<MenuItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return name;
    }
}


