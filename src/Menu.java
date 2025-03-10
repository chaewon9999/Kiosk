import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menu = new ArrayList<>();

    public void addMenu(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}


