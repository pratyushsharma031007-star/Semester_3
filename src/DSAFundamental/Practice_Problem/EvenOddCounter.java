package DSAFundamental.Practice_Problem;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        input = input.replaceAll("[\\[\\]]", "").trim();

        int even = 0, odd = 0;

        if (!input.isEmpty()) {
            String[] numbers = input.split("[,\\s]+");

            for (String number : numbers) {
                int n = Integer.parseInt(number);

                if (n % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}