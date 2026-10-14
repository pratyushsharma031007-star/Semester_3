package String.assignment_problem;

public class TrafficSignal {

    static void findLongestStreak(String signalLog) {

        char maxColor = signalLog.charAt(0);
        int maxLength = 1;

        char current = signalLog.charAt(0);
        int count = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == current) {
                count++;
            } else {
                if (count > maxLength) {
                    maxLength = count;
                    maxColor = current;
                }
                current = signalLog.charAt(i);
                count = 1;
            }
        }

        if (count > maxLength) {
            maxLength = count;
            maxColor = current;
        }

        System.out.println("Longest Streak: '" + maxColor +
                "' repeated " + maxLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}