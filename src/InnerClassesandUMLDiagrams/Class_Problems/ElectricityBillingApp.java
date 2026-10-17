package InnerClassesandUMLDiagrams.Class_Problems;

import java.util.*;

abstract class ElectricityConnection {
    protected double units;

    ElectricityConnection(double units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class HomeConnection extends ElectricityConnection {

    HomeConnection(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {

    ShopConnection(double units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {

    FactoryConnection(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityBillingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            ElectricityConnection connection;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;

                case "SHOP":
                    connection = new ShopConnection(units);
                    break;

                default:
                    connection = new FactoryConnection(units);
            }

            double bill = connection.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    connection.getType(),
                    bill
            );

            total += bill;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
