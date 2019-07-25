package ro.siit.LocalStore;

import java.util.ArrayList;

public class SoldItem extends StockItem {
    private String date;

    @Override
    public String toString() {
        return "SoldItem{" +
                "date='" + date + '\'' +
                ", brand='" + brand + '\'' +
                ", quant=" + quant +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SoldItem(String brand, int quant, String date) {
        super(brand, quant);
        this.date = date;
    }

    static ArrayList<SoldItem> soldList = new ArrayList<>();
}









