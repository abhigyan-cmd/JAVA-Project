import java.util.Scanner;

// Consumer Class
class Consumer {
    private int id;
    private String name;
    private int unitsConsumed;

    public Consumer(int id, String name, int unitsConsumed) {
        this.id = id;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}

// Tariff Calculator Class
class TariffCalculator {

    public double generateBill(Consumer consumer) {
        int units = consumer.getUnitsConsumed();
        double bill = 0;

        if (units <= 100) {
            bill = units * 1.5;
        } 
        else if (units <= 200) {
            bill = (100 * 1.5) + ((units - 100) * 2.5);
        } 
        else if (units <= 300) {
            bill = (100 * 1.5) + (100 * 2.5)
                    + ((units - 200) * 4.0);
        } 
        else {
            bill = (100 * 1.5) + (100 * 2.5)
                    + (100 * 4.0)
                    + ((units - 300) * 6.0);
        }

        double fixedCharge = 125;
        bill += fixedCharge;

        return bill;
    }
}

// Main Class
public class ElectricityBillApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Electricity Bill Calculation System ===");

        System.out.print("Enter Consumer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        Consumer consumer = new Consumer(id, name, units);
        TariffCalculator calculator = new TariffCalculator();

        double totalBill = calculator.generateBill(consumer);

        System.out.println("\n----- BILL DETAILS -----");
        System.out.println("Consumer ID : " + consumer.getId());
        System.out.println("Name        : " + consumer.getName());
        System.out.println("Units Used  : " + consumer.getUnitsConsumed());
        System.out.println("Total Bill  : Rs. " + totalBill);

        sc.close();
    }
}
