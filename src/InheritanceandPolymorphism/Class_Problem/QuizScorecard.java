package InheritanceandPolymorphism.Class_Problem;

import java.util.Scanner;

class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    void recordAnswer(boolean result) {
        if (count < results.length) {
            results[count] = result;
            count++;
        } else {
            System.out.println("No more answers can be recorded");
        }
    }

    int getScore() {
        int score = 0;

        for (boolean result : results) {
            if (result) {
                score++;
            }
        }

        return score;
    }
}

public class QuizScorecard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        Scorecard scorecard = new Scorecard(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter result for question " + (i + 1) + " (true/false): ");
            boolean result = sc.nextBoolean();
            scorecard.recordAnswer(result);
        }

        System.out.println("Final score: " + scorecard.getScore());
    }
}
