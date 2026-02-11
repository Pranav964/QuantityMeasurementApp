package com.apps.quantitymeasurement;

import java.util.Scanner;

import com.apps.quantitymeasurement.Length.LengthUnit;

/**
 * Hello world!
 *
 */
public class QuantityMeasurementApp {
    // Inner class to represent Feet measurement

    // Length equality demonstration
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }


    //Helper method to read Length from user input

    private static Length readLength(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String unitInput = scanner.next().toUpperCase();
        LengthUnit unit;
        try {
            unit = LengthUnit.valueOf(unitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        return new Length(value, unit);

    }

    public static void demonstrateLengthComparison(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);

        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
        System.out.println("\nOutput: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static Length demonstrateLengthConversion(Scanner scanner) {
        System.out.print("Enter length value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String fromUnitInput = scanner.next().toUpperCase();
        LengthUnit fromUnit;
        try {
            fromUnit = LengthUnit.valueOf(fromUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        System.out.print("Enter target length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
        String toUnitInput = scanner.next().toUpperCase();
        LengthUnit toUnit;
        try {
            toUnit = LengthUnit.valueOf(toUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid length unit");
        }

        Length tempLength = new Length(value, fromUnit);
        return tempLength.convertTo(toUnit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            //Demonstrate Length comparison

            // System.out.println("\nDemonstrating Length Comparison:");
            // demonstrateLengthComparison(scanner);

            //Demonstrate Length conversion
            System.out.println("\nDemonstrating Length Conversion:");
            Length convertedLength = demonstrateLengthConversion(scanner);
            System.out.println("Converted Length: " + convertedLength.getValue() + " " + convertedLength.getUnit().name().toLowerCase());
        } finally {
            scanner.close();
        }
    }
}