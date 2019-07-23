package LocalStore;

public class Animal extends Product {
    public int storageTemp;

    public Animal(int id, String productName, double price, int weight, int storageTemp, int quantity) {
        super(id, productName, price, weight, quantity);
        this.storageTemp = storageTemp;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "storageTemp=" + storageTemp +
                ", id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }
}

