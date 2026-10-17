package InnerClassesandUMLDiagrams.Class_Problems;

import java.util.*;

abstract class TravelBooking {
    protected double distance;

    protected static final double BOOKING_FEE = 50.0;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {

    BusBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {

    TrainBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {

    FlightBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (distance * 4);
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                default:
                    booking = new FlightBooking(distance);
            }

            double total = booking.calculateTotal();

            System.out.printf(
                    "%s: %.2f%n",
                    booking.getMode(),
                    total
            );
        }

        sc.close();
    }
}
