package Abstraction_Interface_ClassVsInterface.Class_Problems;

import java.util.*;
import java.util.regex.*;

abstract class ExamQuestion {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    ExamQuestion(String questionText, String correctAnswer,
                 String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQQuestion extends ExamQuestion {
    MCQQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TFQuestion extends ExamQuestion {
    TFQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");

        int count = 0;

        String studentText = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (studentText.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExamGraderApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            /*
             * Extract all quoted strings.
             */
            Pattern pattern = Pattern.compile("\"([^\"]*)\"");
            Matcher matcher = pattern.matcher(line);

            List<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group(1));
            }

            /*
             * Type is before the first quote.
             */
            String type = line.substring(0, line.indexOf("\"")).trim();

            /*
             * Points are after the last quote.
             */
            int lastQuote = line.lastIndexOf("\"");
            double points = Double.parseDouble(
                    line.substring(lastQuote + 1).trim()
            );

            String questionText = values.get(0);
            String correctAnswer = values.get(1);
            String studentAnswer = values.get(2);

            ExamQuestion question;

            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                case "TF":
                    question = new TFQuestion(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                default:
                    question = new EssayQuestion(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}