package InnerClassesandUMLDiagrams.Assignment_Problems;

import java.util.*;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {

    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class Television extends Appliance {

    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {

    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class ApplianceEnergyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();

                if (next.equals("SAVER")) {
                    saverRequested = true;
                }
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new Television(hours);
                    break;

                default:
                    appliance = new WashingMachine(hours);
            }

            if (saverRequested &&
                    !(appliance instanceof SaverMode)) {

                System.out.println(
                        appliance.getType()
                                + ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                units = ((SaverMode) appliance)
                        .applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(),
                    units,
                    cost
            );

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}