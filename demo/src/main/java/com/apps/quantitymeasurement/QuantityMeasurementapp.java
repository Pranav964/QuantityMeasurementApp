package com.apps.quantitymeasurement;
 
import java.util.Scanner;
 
/**
 * Hello world!
 *
 */
public class QuantityMeasurementApp
{
    // Inner class to represent Feet measurement
    public static class Feet {
 
        private final double value;
 
        public Feet(double value) {
            this.value = value;
        }
 
        @Override
        public boolean equals(Object obj) {
 
            if (this == obj) return true;
 
            if (obj == null || getClass() != obj.getClass()) return false;
 
            Feet other = (Feet) obj;
 
            return Double.compare(this.value, other.value) == 0;
        }
 
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
 
        double value1 = 0;
        double value2 = 0;
 
        try {
            // Taking first input
            System.out.print("Enter first value in feet: ");
            if (scanner.hasNextDouble()) {
                value1 = scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                return;
            }
 
            // Taking second input
            System.out.print("Enter second value in feet: ");
            if (scanner.hasNextDouble()) {
                value2 = scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                return;
            }
 
            Feet feet1 = new Feet(value1);
            Feet feet2 = new Feet(value2);
 
            boolean result = feet1.equals(feet2);
 
            System.out.println("\nResult: Equal (" + result + ")");
 
        } finally {
            scanner.close();
        }
    }
}
 