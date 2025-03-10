import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String name;
    private List<MenuItem> menu = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addMenu(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return name;
    }
}


