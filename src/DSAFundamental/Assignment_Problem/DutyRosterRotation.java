package DSAFundamental.Assignment_Problem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k %= n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(" ");
        }

        String data = input.toString().trim();

        Matcher km = Pattern.compile("(?i)k\\s*=\\s*(\\d+)").matcher(data);
        int k;

        if (km.find()) {
            k = Integer.parseInt(km.group(1));
        } else {
            Matcher numbers = Pattern.compile("\\d+").matcher(data);
            int last = -1;
            while (numbers.find()) {
                last = numbers.start();
                k = Integer.parseInt(numbers.group());
            }
            if (last == -1) {
                return;
            }
            Matcher lastNumber = Pattern.compile("\\d+").matcher(data);
            String value = "";
            while (lastNumber.find()) {
                value = lastNumber.group();
            }
            k = Integer.parseInt(value);
        }

        Matcher list = Pattern.compile("\\[([^\\]]*)\\]").matcher(data);
        String namesPart;

        if (list.find()) {
            namesPart = list.group(1);
        } else {
            namesPart = data.replaceAll("(?i)k\\s*=\\s*\\d+", "")
                    .replaceAll("\\d+\\s*$", "")
                    .replaceFirst("(?i)^names\\s*=\\s*", "");
        }

        String[] names = namesPart.trim().split("[,\\s]+");
        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}