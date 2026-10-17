package InnerClassesandUMLDiagrams.Assignment_Problems;

import java.util.*;

abstract class Student {
    protected String name;

    protected static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateFee() {
        return calculateTuition();
    }
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return calculateTuition() + getTransportFee();
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateFee() {
        return calculateTuition() + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return calculateTuition() + getTransportFee();
    }
}

public class CollegeFeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                default:
                    student = new ScholarshipStudent(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            total += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n", total);

        sc.close();
    }
}
