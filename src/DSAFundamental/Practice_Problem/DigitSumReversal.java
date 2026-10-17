package DSAFundamental.Practice_Problem;

import java.util.Scanner;

public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long temp = n;
        long sum = 0;
        long reverse = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}