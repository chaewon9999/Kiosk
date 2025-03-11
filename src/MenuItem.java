public class MenuItem {

    // 이름, 가격, 설명 필드 선언하여 관리
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
        return id + ". | " + productName + " | ₩ " + price + " | " + description;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
