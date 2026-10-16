package ProgrammingFundamental.ClassProblem;

import java.util.*;

class BestStock {

    public static int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minimum;

            if (profit > maximumProfit) {
                maximumProfit = profit;
            }

            if (prices[i] < minimum) {
                minimum = prices[i];
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum profit: " + result);
    }
}