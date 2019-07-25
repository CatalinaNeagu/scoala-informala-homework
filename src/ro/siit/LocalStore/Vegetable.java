package ro.siit.LocalStore;

public class Vegetable extends Product {
    private String vitamin;

    public Vegetable(int id, String productName, double price, int weight, String vitamin, int quantity) {
        super(id, productName, price, weight, quantity);
        this.vitamin = vitamin;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "vitamin='" + vitamin + '\'' +
                ", id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }
}


