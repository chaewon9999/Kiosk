/**
 * 장바구니 관리
 */
public class ShoppingCart {

    String name;
    double price;

    public ShoppingCart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ₩ " + price;
    }
}
