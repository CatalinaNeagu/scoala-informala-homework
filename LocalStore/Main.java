package LocalStore;

import java.util.ArrayList;
import java.util.Scanner;

import static LocalStore.StockItem.stockList;

/** Local Store Simulation
 * A farm sells animal and vegetable products at the local store.
 * All products have on their packaging the price, validity date and weight.
 * The animal products in the store are the following: milk, eggs and various other products made out of milk (such as cheese, yogurt, sour cream).
 * All animal products have on their packaging storage temperature.
 * All vegetal products have a name and describe on their packaging a list of vitamins they contain.
 * The store has a list of item in stock.
 * Each item refers to a product and has a stock number (could be 0 if it's out of stock).
 * A product is identified uniquely by an ID.
 *
 * This programm can:
 * - create a product and add it to stock
 * - sell a product and updating the stock
 * - generate selling report
 * @author Catalina Neagu
 */
public class Main {
    static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args){
        //Adding 4 objects in ArrayList
        Product p1 = new Animal(1, "Cheese", 24, 300, 6, 12);
        Product p2 = new Animal(2, "Cheese", 24, 300, 8, 15);
        Product p3 = new Vegetable(3, "Potatoes", 0.4, 20, "A2", 2);
        Product p4 = new Vegetable(4, "Carrot", 1, 10, "C", 4);
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);

        //Menu display
        input();
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose an option \n" + "1. Create product and add it to stock \n" + "2. Sell product \n" + "3. Display daily sales report \n" + "4. Exit \n" + "Choose an option:");
        String answer = sc.next();
        switch (answer) {

            case "1":
                Store.addProduct();
                System.out.println("After adding the product, the new list is: " + productList);

                //Asking the user if he wants to perform another action. If the user types "yes", the menu is display again.
                System.out.println("Do you want to do something else? Type yes or no");
                Scanner s = new Scanner(System.in);
                String answer2 = sc.next();
                switch (answer2) {
                    case "yes":
                        input();
                    case "no":
                        System.exit(0);
                    default:
                        System.out.println("This is not an option");
                }

            case "2":
                Store.addStock();
                Store.sellProduct();
                System.out.println("After selling the product, the new list is: " + stockList);

                //Asking the user if he wants to perform another action. If the user types "yes", the menu is display again.
                System.out.println("Do you want to do something else? Type yes or no");
                s = new Scanner(System.in);
                answer2 = sc.next();
                switch (answer2) {
                    case "yes":
                        input();
                    case "no":
                        System.exit(0);
                    default:
                        System.out.println("This is not an option");
                }

            case "3":
                Store.salesReport();

                //Asking the user if he wants to perform another action. If the user types "yes", the menu is display again.
                System.out.println("Do you want to do something else? Type yes or no");
                s = new Scanner(System.in);
                answer2 = sc.next();
                switch (answer2) {
                    case "yes":
                        input();
                    case "no":
                        System.exit(0);
                    default:
                        System.out.println("This is not an option");
                }

            case "4":
                System.exit(0);

            default:
                System.out.println("This is not an option");
                System.exit(0);
        }
    }
}