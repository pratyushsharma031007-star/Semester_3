package InheritanceandPolymorphism.Assignment_Problem;

import java.util.Scanner;

class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        PasswordChecker checker = new PasswordChecker(password);

        System.out.println("Password strength: " + checker.getStrength());
    }
}