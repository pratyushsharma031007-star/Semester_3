package Abstraction_Interface_ClassVsInterface.Assignement_Problems;

import java.util.*;
import java.time.LocalDate;

abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            StreamingPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;

                default:
                    plan = new PremiumPlan(name, startDate);
            }

            System.out.printf("%s: %s%n",
                    plan.name,
                    plan.getRenewalDate());
        }

        sc.close();
    }
}