package InnerClassesandUMLDiagrams.Class_Problems;

import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookItem extends LibraryItem {

    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVDItem extends LibraryItem {

    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class MagazineItem extends LibraryItem {

    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryFineApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, daysLate);
                    break;

                case "DVD":
                    item = new DVDItem(title, daysLate);
                    break;

                default:
                    item = new MagazineItem(title, daysLate);
            }

            double fine = item.calculateFine();

            System.out.printf(
                    "%s: %.2f%n",
                    item.title,
                    fine
            );

            totalFines += fine;
        }

        System.out.printf(
                "Total Fines: %.2f%n",
                totalFines
        );

        sc.close();
    }
}