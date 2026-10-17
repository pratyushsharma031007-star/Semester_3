package DSAFundamental.Assignment_Problem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamScoreBandCounter {
    public static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int upperBound(int[] scores, int target) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(" ");
        }

        String data = input.toString().trim();
        Matcher listMatcher = Pattern.compile("\\[([^\\]]*)\\]").matcher(data);

        int[] scores;
        int low, high;

        if (listMatcher.find()) {
            Matcher numberMatcher = Pattern.compile("-?\\d+").matcher(listMatcher.group(1));
            int[] temp = new int[listMatcher.group(1).split("[,\\s]+").length];
            int count = 0;

            while (numberMatcher.find()) {
                temp[count++] = Integer.parseInt(numberMatcher.group());
            }

            scores = new int[count];
            System.arraycopy(temp, 0, scores, 0, count);

            Matcher lowMatcher = Pattern.compile("(?i)low\\s*=\\s*(\\d+)").matcher(data);
            Matcher highMatcher = Pattern.compile("(?i)high\\s*=\\s*(\\d+)").matcher(data);

            if (lowMatcher.find() && highMatcher.find()) {
                low = Integer.parseInt(lowMatcher.group(1));
                high = Integer.parseInt(highMatcher.group(1));
            } else {
                return;
            }
        } else {
            Matcher numberMatcher = Pattern.compile("-?\\d+").matcher(data);
            int[] numbers = new int[1000005];
            int count = 0;

            while (numberMatcher.find()) {
                numbers[count++] = Integer.parseInt(numberMatcher.group());
            }

            int n = numbers[0];
            scores = new int[n];

            for (int i = 0; i < n; i++) {
                scores[i] = numbers[i + 1];
            }

            low = numbers[n + 1];
            high = numbers[n + 2];
        }

        System.out.println(countInBand(scores, low, high));
    }
}
