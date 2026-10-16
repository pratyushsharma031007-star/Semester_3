package OOPFundamental.Practice_Problem;

import java.util.*;

class ScoreCurve {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));
    }
}