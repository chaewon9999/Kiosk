import java.util.List;

public class Cart {

    String name;
    double price;

    public Cart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ₩" + price;
    }
}
