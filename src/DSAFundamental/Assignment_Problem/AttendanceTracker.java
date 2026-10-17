package DSAFundamental.Assignment_Problem;

import java.util.Scanner;

public class AttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                longest = Math.max(longest, streak);
            } else {
                streak = 0;
            }
        }

        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();
        String[] values = input.split("\\s+");
        int[] days = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            days[i] = Integer.parseInt(values[i]);
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }
}