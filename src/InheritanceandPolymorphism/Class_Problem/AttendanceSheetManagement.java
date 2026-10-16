package InheritanceandPolymorphism.Class_Problem;

import java.util.Scanner;

class AttendanceSheet {
    private String[] students;
    private int count;

    AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceSheetManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int maxStudents = sc.nextInt();

        sc.nextLine();

        AttendanceSheet sheet = new AttendanceSheet(maxStudents);

        System.out.print("Enter number of students to mark present: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            sheet.markPresent(name);
        }

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.print("Enter name to check: ");
        String name = sc.nextLine();

        System.out.println("Is present: " + sheet.isPresent(name));
    }
}