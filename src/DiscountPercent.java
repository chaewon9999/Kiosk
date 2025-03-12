public enum DiscountPercent {

    NATIONAL_MERIT(1,"국가유공자", 10),
    SOLDIER(2,"군인", 5),
    STUDENT(3,"학생",3),
    NORMAL(4,"일반",0);

    private final int id;
    private final String name;
    private final int discountPercent;

    DiscountPercent(int id, String name, int discountPercent) {
        this.id = id;
        this.name = name;
        this.discountPercent = discountPercent;
    }

    double getDiscountAmount(double totalAmount) {
        return totalAmount - (totalAmount * discountPercent / 100);
    }


    @Override
    public String toString() {
        return id + ". " + name + " " + discountPercent + "%";
    }
}