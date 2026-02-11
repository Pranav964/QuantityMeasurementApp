package com.apps.quantitymeasurement;
 
import java.util.Scanner;
 
import com.apps.quantitymeasurement.Length.LengthUnit;
 
/**
 * Quantity Measurement Application
 */
public class QuantityMeasurementapp {
    // Inner class to represent Feet measurement
    public static class Feet {
 
        private final double value;
 
        public Feet(double value) {
            this.value = value;
        }
 
        @Override
        public boolean equals(Object obj) {
 
            if (this == obj)
                return true;
 
            if (obj == null || getClass() != obj.getClass())
                return false;
 
            Feet other = (Feet) obj;
 
            return Double.compare(this.value, other.value) == 0;
        }
 
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
 
    public static class Inches {
        private final double value;
 
        public Inches(double value) {
            this.value = value;
        }
 
        @Override
        public boolean equals(Object obj) {
 
            if (this == obj)
                return true;
 
            if (obj == null || getClass() != obj.getClass())
                return false;
 
            Inches other = (Inches) obj;
 
            return Double.compare(this.value, other.value) == 0;
        }
 
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }
 
    // Length equality demonstration
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }
 
 
    //Helper method to read Length from user input
 
    private static Length readLength(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();
 
        System.out.print("Enter length unit (INCHES, FEET): ");
        String unitInput = scanner.next().toUpperCase();
        LengthUnit unit;
        try {
            unit = LengthUnit.valueOf(unitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }
 
        return new Length(value, unit);
 
    }
 
    //Feet equality demonstration
    public static void demonstrateFeetEquality(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);
 
        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
       
       
 
        System.out.println("\nOutput: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }
 
    public static void demonstrateInchEquality(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);
 
        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
       
       
 
        System.out.println("\nOutput: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
 
       
    }
 
    public static void demonstrateFeetinchesComparison(Scanner scanner) {
        Length lengthInFeet = readLength(scanner);
        Length lengthInInches = readLength(scanner);
 
        System.out.println("Input: Quantity 1: " + lengthInFeet.getValue() + " " + lengthInFeet.getUnit().name().toLowerCase() +
                ", Quantity 2: " + lengthInInches.getValue() + " " + lengthInInches.getUnit().name().toLowerCase());
 
        System.out.println("\nOutput: Equal (" + demonstrateLengthEquality(lengthInFeet, lengthInInches) + ")");
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            System.out.println("Demonstrating Feet Equality (Enter values in feet):");
            demonstrateFeetEquality(scanner);
 
            System.out.println("\nDemonstrating Inches Equality (Enter values in inches):");
            demonstrateInchEquality(scanner);
            System.out.println("\nDemonstrating Feet and Inches Comparison:");
            demonstrateFeetinchesComparison(scanner);
        } finally {
            scanner.close();
        }
    }
}