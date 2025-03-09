public class MenuItem {

    private int id;
    private String productName;
    private double price;
    private String description;

    public MenuItem(int id, String productName, double price, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ". | " + productName + " | ₩ | " + price + " | " + description;
    }
}
