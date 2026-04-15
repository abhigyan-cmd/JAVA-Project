class Consumer {
    int id;
    String name;
    int units;

    Consumer(int i, String n, int u) {
        id = i;
        name = n;
        units = u;
    }
}
class TariffCalculator {

    double generateBill(Consumer c) {
        double bill = 0;

        if (c.units <= 100) {
            bill = c.units * 1.5;
        }
        else if (c.units <= 200) {
            bill = (100 * 1.5) + (c.units - 100) * 2.5;
        }
        else if (c.units <= 300) {
            bill = (100 * 1.5) + (100 * 2.5) + (c.units - 200) * 4.0;
        }
        else {
            bill = (100 * 1.5) + (100 * 2.5) + (100 * 4.0) + (c.units - 300) * 6.0;
        }

        return bill;
    }
}
class Main {
    public static void main(String[] args) {

        Consumer c1 = new Consumer(101, "Rahul", 250);

        TariffCalculator t = new TariffCalculator();

        double totalBill = t.generateBill(c1);

        System.out.println("Consumer ID: " + c1.id);
        System.out.println("Name: " + c1.name);
        System.out.println("Units Consumed: " + c1.units);
        System.out.println("Total Bill: " + totalBill);
    }
}