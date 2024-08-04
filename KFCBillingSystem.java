import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KFCBillingSystem {
    private Map<String, Double> menu;
    private double total;
    private int tokenNumber;
    private static final int COUNTERS = 3;

    public KFCBillingSystem() {
        this.menu = new HashMap<>();
        this.menu.put("8pc. Chicken Meal",27.49);
        this.menu.put("2pc.Chicken Combo",7.49);
        this.menu.put("Chicken Bucket", 10.99);
        this.menu.put("Chicken Lolipop",5.00);
        this.menu.put("Famous Bowl Combo",6.29);
        this.menu.put("5pc.Nuggets",3.49);
        this.menu.put("Water Bottle",1.00);
        this.menu.put("Chicken 65",7.00);
        this.menu.put("Fries", 2.49);
        this.menu.put("Coke", 1.99);
        this.total = 0.0;
        this.tokenNumber = 1;
    }

    public void displayMenu() {
        System.out.println("KFC Menu:");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item name (or 'done' to finish):");
        while (true) {
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }
            if (menu.containsKey(itemName)) {
                total += menu.get(itemName);
                System.out.println("Added " + itemName + " to order.");
            } else {
                System.out.println("Invalid item. Please try again.");
            }
        }
    }

    public void processPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total: $" + total);
        System.out.println("Enter payment amount:");
        double payment = scanner.nextDouble();
        if (payment >= total) {
            System.out.println("Payment successful. Change: $" + (payment - total));
        } else {
            System.out.println("Insufficient payment. Please try again.");
            processPayment();
        }
    }

    public void generateBill() {
        System.out.println("Bill (Token Number: " + tokenNumber + ")");
        System.out.println("Total: $" + total);
        System.out.println("Please wait at counter " + (tokenNumber % COUNTERS + 1));
        tokenNumber++;
    }

    public static void main(String[] args) {
        KFCBillingSystem kfc = new KFCBillingSystem();
        kfc.displayMenu();
        kfc.takeOrder();
        kfc.processPayment();
        kfc.generateBill();
    }
}
