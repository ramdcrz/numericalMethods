package numericalMethods;

import java.util.Scanner;
import java.text.DecimalFormat;

public class LagrangeInterpolation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.print("=== WELCOME TO LAGRANGE INTERPOLATION CALCULATOR! ===\n");
        
        // Input the number of data points
        System.out.print("\nEnter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n]; // Array to store x values
        double[] y = new double[n]; // Array to store y values

        // Input x and y values for each data point
        System.out.println("Enter the x and y values for each data point:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
            System.out.println();
        }

        // Input the x value for which to find the interpolated y value
        System.out.print("Enter the x value for interpolation: ");
        double xValue = scanner.nextDouble();

        // Calculate the interpolated y value
        double result = lagrangeInterpolation(x, y, xValue);
        System.out.println("\nInterpolated y value at x = " + xValue + " is " + df.format(result));

        scanner.close();
    }

    // Lagrange Interpolation method
    public static double lagrangeInterpolation(double[] x, double[] y, double xValue) {
        double result = 0;

        // Calculate the interpolated value using Lagrange's formula
        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (xValue - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }
}
