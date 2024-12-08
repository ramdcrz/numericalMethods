package numericalMethods;

import java.util.Scanner;
import java.text.DecimalFormat;

public class NewtonForwardDifferenceInterpolation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
        
        System.out.print("=== WELCOME TO NEWTON'S FORWARD DIFFERENCE INTERPOLATION CALCULATOR! ===\n");
        
        // Input the number of data points and the data points itself
        System.out.print("\nEnter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Enter the data points:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] = ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "] = ");
            y[i] = scanner.nextDouble();
            System.out.println();
        }

        // Input the x value for interpolation
        System.out.print("Enter the value for interpolation: ");
        double xValue = scanner.nextDouble();

        // Calculate the difference table
        double[][] forwardDifference = new double[n][n];
        for (int i = 0; i < n; i++) {
            forwardDifference[i][0] = y[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                forwardDifference[j][i] = forwardDifference[j + 1][i - 1] - forwardDifference[j][i - 1];
            }
        }

        // Display the difference table
        System.out.println("\nDifference Table:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.2f", x[i]);
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%-10.2f", forwardDifference[i][j]);
            }
            System.out.println();
        }

        // Find the index i such that x[i] <= xValue < x[i+1]
        int i = 0;
        while (i < n - 1 && x[i + 1] <= xValue) {
            i++;
        }

        double h = x[1] - x[0];
        double p = (xValue - x[i]) / h;

        // Display the calculated values
        System.out.println("\nCalculating for x = " + xValue + ":");
        System.out.println("h = " + x[1] + " - " + x[0] + " = " + df.format(h));
        System.out.println("p = (" + xValue + " - " + x[i] + ") / " + df.format(h) + " = " + df.format(p));

        // Calculate the interpolated value
        double result = y[i];
        double term = 1;
        for (int j = 1; j < n - i; j++) {
            term *= (p - j + 1) / j;
            result += term * forwardDifference[i][j];
        }

        // Output the interpolated value
        System.out.println("\nInterpolated value at x = " + xValue + " is " + df.format(result));

        scanner.close();
    }
}
