package Abstraction_Interface_ClassVsInterface.Class_Problems;

import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowDays();

    LocalDate getDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 3;
    }
}

public class LibraryDueDateApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;

                case "DVD":
                    item = new DVD(title);
                    break;

                default:
                    item = new Magazine(title);
            }

            System.out.println(
                    item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}