package InnerClassesandUMLDiagrams.Assignment_Problems;

import java.util.*;

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    double calculateFare() {
        return Math.max(100, km * getRate());
    }
}

interface NightService {
    double applyNightFare(double fare);
}

class MiniCab extends Cab {

    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;

                case "SEDAN":
                    cab = new SedanCab(km);
                    break;

                default:
                    cab = new SUVCab(km);
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {

                if (cab instanceof NightService) {
                    fare = ((NightService) cab)
                            .applyNightFare(fare);
                } else {
                    System.out.println(
                            cab.getType()
                                    + ": night service not available"
                    );
                    continue;
                }
            }

            System.out.printf("%s: %.2f%n",
                    cab.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}