package DSAFundamental.Assignment_Problem;
import java.util.*;
import java.util.regex.*;

public class BusiestBusRow {
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                bestRow = i;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(" ");
        }

        String data = input.toString().trim();
        Matcher rowMatcher = Pattern.compile("\\[([^\\[\\]]*)\\]").matcher(data);
        List<int[]> rows = new ArrayList<>();

        while (rowMatcher.find()) {
            Matcher numberMatcher = Pattern.compile("\\d+").matcher(rowMatcher.group(1));
            int[] temp = new int[10];
            int count = 0;

            while (numberMatcher.find()) {
                temp[count++] = Integer.parseInt(numberMatcher.group());
            }

            if (count > 0) {
                rows.add(Arrays.copyOf(temp, count));
            }
        }

        int[][] grid;

        if (!rows.isEmpty()) {
            grid = rows.toArray(new int[0][]);
        } else {
            Matcher numberMatcher = Pattern.compile("\\d+").matcher(data);
            List<Integer> numbers = new ArrayList<>();

            while (numberMatcher.find()) {
                numbers.add(Integer.parseInt(numberMatcher.group()));
            }

            int r = numbers.get(0);
            int c = numbers.get(1);
            grid = new int[r][c];
            int index = 2;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = numbers.get(index++);
                }
            }
        }

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
