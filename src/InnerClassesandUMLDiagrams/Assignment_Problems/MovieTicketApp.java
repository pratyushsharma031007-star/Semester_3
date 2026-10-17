package InnerClassesandUMLDiagrams.Assignment_Problems;

import java.util.*;

abstract class Ticket {
    protected int count;


    protected static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }

    abstract String getType();
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getType() {
        return "RECLINER";
    }
}

public class MovieTicketApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (type) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;

                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;

                default:
                    ticket = new ReclinerTicket(count);
            }

            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    ticket.getType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
