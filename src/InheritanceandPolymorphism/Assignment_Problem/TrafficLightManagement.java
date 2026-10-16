package InheritanceandPolymorphism.Assignment_Problem;

import java.util.Scanner;

class TrafficLight {
    private String color;
    private final String id;

    TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    String getColor() {
        return color;
    }
}

public class TrafficLightManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic light ID: ");
        String id = sc.nextLine();

        TrafficLight light = new TrafficLight(id);

        System.out.println("Current color: " + light.getColor());

        System.out.print("Enter number of times to change: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            light.next();
            System.out.println("Current color: " + light.getColor());
        }
    }
}