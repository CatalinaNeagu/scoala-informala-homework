package ro.siit.LocalStore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static ro.siit.LocalStore.Main.productList;
import static ro.siit.LocalStore.SoldItem.soldList;
import static ro.siit.LocalStore.StockItem.stockList;

public class Store {

    //Adding a product
    static int id = 4;
    public static void addProduct() {
        id++;
        System.out.println("What type is the product that you want to add? Type 1 for Animal, 2 for Vegetable");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        //Verifying if the input is 1 (for animal) or 2 (for vegetable)
        if (!(choice.equals("1") || choice.equals("2"))){
            System.out.println("This is not an option");
            System.exit(0);
        }

        System.out.println("Type the name of the product");
        String verif = sc.next();

        //Verifying if the input is one of the animal product that can be added in store
        switch (choice){
            case "1":
                if (verif.equals("cheese") || verif.equals("egg") || verif.equals("milk") || verif.equals("yogurt") || verif.equals("sour cream")){
                    String name = verif;
                }
                else {
                    System.out.println("This is not an animal product");
                    System.exit(0);
                }
                break;
            case "2":
                String name = verif;
                break;
        }

        System.out.println("Type the price of the product");
        Double price = Double.parseDouble(sc.next());

        System.out.println("Type the weight of the product");
        int weight = Integer.parseInt(sc.next());

        System.out.println("Type the quantity of the product");
        int quantity = Integer.parseInt(sc.next());

        switch (choice){
            case "1":
                System.out.println("Type the storage temperature");
                int storageTemp = Integer.parseInt(sc.next());

                //Defining the product and adding it in productList
                Product p5 = new Animal(id, verif , price, weight, storageTemp, quantity);
                productList.add(p5);
                break;
            case "2":
                System.out.println ("Type the list of vitamins the product contains");
                String vitamin =sc.next();

                //Defining the product and adding it in productList
                Product p6 = new Vegetable(id, verif , price, weight, vitamin, quantity);
                productList.add(p6);
                break;
        }
    }

    //Adding the products in stockList

    public static void addStock() {
        //Adding the products from productList to stockList
        for (int i = 0; i < productList.size(); i++) {
            String brand = productList.get(i).getProductName();
            int quant = productList.get(i).getQuantity();
            StockItem s = new StockItem(brand, quant);
            stockList.add(s);
        }

        //Merging the quantity for the same products
        for (int i = 0; i < stockList.size(); i++) {
            for (int j = i+1; j <= stockList.size()-1; j++) {
                if (stockList.get(i).getBrand().equals(stockList.get(j).getBrand())) {
                    int a = stockList.get(i).getQuant() + stockList.get(j).getQuant();
                    stockList.get(i).setQuant(a);
                    stockList.remove(j);
                }
            }
        }
    }

    //Selling the quantity and updating the stockList
    public static void sellProduct(){
        System.out.println("Type the name of the product that you want to buy");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for (int i = 0; i <= stockList.size()-1; i++){

            //Verifying if we have this product on stock
            if (name.equalsIgnoreCase(stockList.get(i).getBrand())) {
                System.out.println("Type the quantity you want to buy");
                Scanner s = new Scanner(System.in);
                int quantity = Integer.parseInt(s.next());

                //Verifying if we have this quantity on stock
                if (quantity <= stockList.get(i).getQuant()) {

                    //If we have this quantity in stock, we will sell and update the stock
                    int a = (stockList.get(i).getQuant() - quantity);
                    stockList.get(i).setQuant(a);

                    //Setting the date of sale
                    Date date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = dateFormat.format(date);

                    //Adding the sold item in soldList
                    SoldItem soldItem = new SoldItem(stockList.get(i).getBrand(), quantity, strDate);
                    soldList.add(soldItem);
                }
                else if (quantity > (stockList.get(i).getQuant())) {
                    System.out.println("We do not have this quantity on stock");
                    System.exit(0);
                }
                break;
            }
            else{
                continue;
            }
        }
    }

    //Report the sales
    public static void salesReport(){
        System.out.println("Please type the date");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        for (int i =0; i < soldList.size(); i++){
                        //If the date input from the user is the same with sold date, the code will display the report
                        if (date.equals(soldList.get(i).getDate())){
                            System.out.println("On this date " + soldList.get(i).getDate() + " we sold " + " " + soldList.get(i).getBrand() + " " + soldList.get(i).getQuant());
                            continue;
            }
            else{
                continue;
            }
        }
    }
}

