package com.apps.quantitymeasurement;

import java.util.Scanner;

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
    //demonstrate addition of two lengths
    public static Length demonstrateLengthAddition(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);

        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase());
        Length sumLength = length1.add(length2);
        System.out.println("Output: Sum (" + sumLength.getValue() + " " + sumLength.getUnit().name().toLowerCase() + ")");
        return sumLength;
    }

    // Method demonstratateLengthConversion with length Length.LengthUnit toUnit and return converted length
    //public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {

       // return length.convertTo(toUnit);

   // }

    //UC7 - Method to demonstrate addition with target unit specification
    public static Length demonstrateLengthAdditionWithTargetUnit(Scanner scanner) {
        Length length1 = readLength(scanner);
        Length length2 = readLength(scanner);
        
        System.out.print("Enter target unit for result (INCHES, FEET, YARDS, CENTIMETERS): ");
        String targetUnitInput = scanner.next().toUpperCase();
        LengthUnit targetUnit;
        try {
            targetUnit = LengthUnit.valueOf(targetUnitInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid target unit");
        }

        System.out.println("Input: Quantity 1: " + length1.getValue() + " " + length1.getUnit().name().toLowerCase() +
                ", Quantity 2: " + length2.getValue() + " " + length2.getUnit().name().toLowerCase() +
                ", Target Unit: " + targetUnit.name().toLowerCase());
        
        Length sumLength = length1.add(length2, targetUnit);
        System.out.println("Output: Sum (" + sumLength.getValue() + " " + sumLength.getUnit().name().toLowerCase() + ")");
        return sumLength;
    }


    /**
     * UC8 - Data-driven approach: Interface for executable examples
     */
    @FunctionalInterface
    interface Example {
        void execute();
    }

    /**
     * UC8 - Gets example configuration by number
     * Interactive approach - examples accept user input
     */
    private static Example getExample(int exampleNumber, String title, Scanner scanner) {
        switch (exampleNumber) {
            case 1: // Unit Conversion
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.print("Enter length value: ");
                    double value = scanner.nextDouble();
                    System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit fromUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter target unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit toUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length input = new Length(value, fromUnit);
                    Length result = input.convertTo(toUnit);
                    System.out.println("Input: Quantity(" + input.getValue() + ", " + input.getUnit() + ").convertTo(" + toUnit + ")");
                    System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")\n");
                };
            case 2: // Addition with Target Unit
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.println("Enter first length:");
                    System.out.print("  Value: ");
                    double v1 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.println("Enter second length:");
                    System.out.print("  Value: ");
                    double v2 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.print("Enter target unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit target = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length l1 = new Length(v1, u1);
                    Length l2 = new Length(v2, u2);
                    Length result = l1.add(l2, target);
                    System.out.println("Input: Quantity(" + l1.getValue() + ", " + l1.getUnit() + ").add(Quantity(" + l2.getValue() + ", " + l2.getUnit() + "), " + target + ")");
                    System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")\n");
                };
            case 3: // Equality Comparison Across Units
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.println("Enter first length:");
                    System.out.print("  Value: ");
                    double v1 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.println("Enter second length:");
                    System.out.print("  Value: ");
                    double v2 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length l1 = new Length(v1, u1);
                    Length l2 = new Length(v2, u2);
                    boolean result = l1.equals(l2);
                    System.out.println("Input: Quantity(" + l1.getValue() + ", " + l1.getUnit() + ").equals(Quantity(" + l2.getValue() + ", " + l2.getUnit() + "))");
                    System.out.println("Output: " + result + "\n");
                };
            case 4: // Yards and Feet Addition
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.println("Enter first length:");
                    System.out.print("  Value: ");
                    double v1 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.println("Enter second length:");
                    System.out.print("  Value: ");
                    double v2 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.print("Enter target unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit target = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length l1 = new Length(v1, u1);
                    Length l2 = new Length(v2, u2);
                    Length result = l1.add(l2, target);
                    System.out.println("Input: Quantity(" + l1.getValue() + ", " + l1.getUnit() + ").add(Quantity(" + l2.getValue() + ", " + l2.getUnit() + "), " + target + ")");
                    System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")\n");
                };
            case 5: // Metric to Imperial Conversion
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.print("Enter length value: ");
                    double value = scanner.nextDouble();
                    System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit fromUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter target unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit toUnit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length input = new Length(value, fromUnit);
                    Length result = input.convertTo(toUnit);
                    System.out.println("Input: Quantity(" + input.getValue() + ", " + input.getUnit() + ").convertTo(" + toUnit + ")");
                    System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")\n");
                };
            case 6: // Addition with Zero
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.println("Enter first length:");
                    System.out.print("  Value: ");
                    double v1 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u1 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.println("Enter second length:");
                    System.out.print("  Value: ");
                    double v2 = scanner.nextDouble();
                    System.out.print("  Unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit u2 = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    System.out.print("Enter target unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit target = LengthUnit.valueOf(scanner.next().toUpperCase());
                    
                    Length l1 = new Length(v1, u1);
                    Length l2 = new Length(v2, u2);
                    Length result = l1.add(l2, target);
                    System.out.println("Input: Quantity(" + l1.getValue() + ", " + l1.getUnit() + ").add(Quantity(" + l2.getValue() + ", " + l2.getUnit() + "), " + target + ")");
                    System.out.println("Output: Quantity(" + result.getValue() + ", " + result.getUnit() + ")\n");
                };
            case 7: // Unit-Level Conversion to Base Unit
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit unit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter value: ");
                    double value = scanner.nextDouble();
                    
                    double result = unit.convertToBaseUnit(value);
                    System.out.println("Input: LengthUnit." + unit + ".convertToBaseUnit(" + value + ")");
                    System.out.println("Output: " + result + " (" + value + " " + unit.name().toLowerCase() + " = " + result + " inches)\n");
                };
            case 8: // Base Unit Identity Conversion
                return () -> {
                    System.out.println("Example " + exampleNumber + ": " + title);
                    System.out.print("Enter length unit (INCHES, FEET, YARDS, CENTIMETERS): ");
                    LengthUnit unit = LengthUnit.valueOf(scanner.next().toUpperCase());
                    System.out.print("Enter value: ");
                    double value = scanner.nextDouble();
                    
                    double result = unit.convertToBaseUnit(value);
                    System.out.println("Input: LengthUnit." + unit + ".convertToBaseUnit(" + value + ")");
                    System.out.println("Output: " + result + " inches\n");
                };
            default:
                return () -> System.out.println("Invalid example number. Please choose 1-" + getExampleTitles().length + ".\n");
        }
    }

    /**
     * UC8 - Example titles configuration (data-driven)
     */
    private static String[] getExampleTitles() {
        return new String[]{
            "Unit Conversion",
            "Addition with Target Unit",
            "Equality Comparison Across Units",
            "Yards and Feet Addition",
            "Metric to Imperial Conversion",
            "Addition with Zero",
            "Unit-Level Conversion to Base Unit",
            "Base Unit Identity Conversion"
        };
    }

    /**
     * UC8 - Demonstrates specific example (interactive)
     */
    private static void demonstrateExample(int exampleNumber, Scanner scanner) {
        String[] titles = getExampleTitles();
        if (exampleNumber >= 1 && exampleNumber <= titles.length) {
            Example example = getExample(exampleNumber, titles[exampleNumber - 1], scanner);
            example.execute();
        } else {
            System.out.println("Invalid example number. Please choose 1-" + titles.length + ".\n");
        }
    }

    /**
     * UC8 - Runs all examples (interactive)
     */
    public static void demonstrateAllExamples(Scanner scanner) {
        System.out.println("=== Quantity Measurement Application - Example Outputs ===\n");
        
        String[] titles = getExampleTitles();
        for (int i = 1; i <= titles.length; i++) {
            System.out.println("\n--- Running Example " + i + " of " + titles.length + " ---");
            demonstrateExample(i, scanner);
        }
        
        System.out.println("=== All Examples Demonstrated Successfully ===");
    }

    /**
     * UC8 - Interactive menu (fully interactive)
     */
    public static void demonstrateExamplesInteractively(Scanner scanner) {
        String[] titles = getExampleTitles();
        
        while (true) {
            System.out.println("\n=== UC8 Example Menu ===");
            for (int i = 0; i < titles.length; i++) {
                System.out.println((i + 1) + ". " + titles[i]);
            }
            System.out.println((titles.length + 1) + ". Run All Examples");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting examples menu...");
                return;
            } else if (choice == titles.length + 1) {
                System.out.println();
                demonstrateAllExamples(scanner);
            } else if (choice >= 1 && choice <= titles.length) {
                System.out.println();
                demonstrateExample(choice, scanner);
            } else {
                System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            System.out.println("=== Quantity Measurement Application ===");
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Interactive Example Menu (UC8)");
            System.out.println("2. Length Addition Demo");
            System.out.println("3. Length Addition with Target Unit Demo");
            System.out.println("4. Run All Examples");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 0:
                    System.out.println("Exiting application...");
                    break;
                    
                case 1:
                    demonstrateExamplesInteractively(scanner);
                    break;
                    
                case 2:
                    System.out.println("\nDemonstrating Length Addition:");
                    demonstrateLengthAddition(scanner);
                    break;
                    
                case 3:
                    System.out.println("\nDemonstrating Length Addition with Target Unit Specification:");
                    demonstrateLengthAdditionWithTargetUnit(scanner);
                    break;
                    
                case 4:
                    System.out.println("\nRunning All Examples:");
                    demonstrateAllExamples(scanner);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Exiting...");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}