package InnerClassesandUMLDiagrams.Assignment_Problems;

import java.util.*;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    abstract String getType();
}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(
                            weight, declaredValue);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(
                            weight, declaredValue);
                    break;

                default:
                    parcel = new FragileParcel(
                            weight, declaredValue);
            }

            double charge = parcel.calculateCharge();

            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(),
                    charge,
                    insurance,
                    total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}