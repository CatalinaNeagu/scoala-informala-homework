package ro.siit.LocalStore;

import java.util.ArrayList;

public class StockItem {
    public String brand;
    public int quant;

    public StockItem(String brand, int quant) {
        this.brand = brand;
        this.quant = quant;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public int getQuant() {

        return quant;
    }

    public void setQuant(int quant) {

        this.quant = quant;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "brand='" + brand + '\'' +
                ", quant=" + quant +
                '}';
    }

    static ArrayList<StockItem> stockList = new ArrayList();
}






