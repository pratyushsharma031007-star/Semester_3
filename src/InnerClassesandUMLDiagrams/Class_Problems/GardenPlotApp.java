package InnerClassesandUMLDiagrams.Class_Problems;

import java.util.*;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new CirclePlot(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new RectanglePlot(owner, length, width);
                    break;

                default:
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new TrianglePlot(owner, base, height);
            }

            double area = plot.calculateArea();

            System.out.printf(
                    "%s (%s): %.2f%n",
                    plot.owner,
                    plot.getShape(),
                    area
            );

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}