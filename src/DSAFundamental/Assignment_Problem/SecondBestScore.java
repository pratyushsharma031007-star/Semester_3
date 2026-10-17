package DSAFundamental.Assignment_Problem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(" ");
        }

        String data = input.toString().trim();
        Matcher listMatcher = Pattern.compile("\\[([^\\]]*)\\]").matcher(data);
        String values;

        if (listMatcher.find()) {
            values = listMatcher.group(1);
        } else {
            values = data;
        }

        Matcher matcher = Pattern.compile("\\d+").matcher(values);
        int[] temp = new int[1005];
        int count = 0;

        while (matcher.find()) {
            temp[count++] = Integer.parseInt(matcher.group());
        }

        if (!data.contains("[")) {
            if (count > 1 && temp[0] == count - 1) {
                System.arraycopy(temp, 1, temp, 0, count - 1);
                count--;
            }
        }

        int[] scores = new int[count];
        System.arraycopy(temp, 0, scores, 0, count);

        System.out.println(secondHighest(scores));
    }
}
