# 📚 COMPLETE PROJECT DOCUMENTATION - QUANTITY MEASUREMENT APP

## 🏗️ PROJECT OVERVIEW

This is a **Quantity Measurement Application** that demonstrates object-oriented design principles. It allows users to:
- Create length measurements in different units (FEET, INCHES, YARDS, CENTIMETERS)
- Compare lengths across different units
- Convert between units
- Add/combine measurements
- Perform all operations with precision handling

---

# 🔧 CLASS 1: `LengthUnit.java` (ENUM - Handles Unit Conversions)

## Purpose
Manages all unit-related information and conversions. This enum standardizes unit definitions and ensures all conversions happen in one place (centralized logic).

## Location
`src/main/java/com/apps/quantitymeasurement/LengthUnit.java`

---
/
## 📋 ENUM CONSTANTS

```java
public enum LengthUnit {
    FEET(12.0),                // 1 foot = 12 inches
    INCHES(1.0),               // 1 inch = base unit
    YARDS(36.0),               // 1 yard = 36 inches
    CENTIMETERS(0.393701);     // 1 cm = 0.393701 inches
```

### Explanation:
- **Each constant** represents one unit type
- **Constructor parameter** = conversion factor to base unit (INCHES)
- **Base Unit** = INCHES (all other units convert to/from inches)

### Why These Conversion Factors?
```
FEET → 1 foot = 12 inches → factor = 12.0
INCHES → base unit → factor = 1.0
YARDS → 1 yard = 3 feet = 36 inches → factor = 36.0
CENTIMETERS → 1 cm = 0.393701 inches → factor = 0.393701 (1 inch = 2.54 cm)
```

---

## 🔧 CLASS VARIABLE

```java
private final double conversionFactor;
```

- Stores the conversion factor for each unit
- `final` means it cannot be changed after initialization
- Different for each enum constant (FEET, INCHES, etc.)

---

## 📌 METHOD 1: Constructor

```java
LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
}
```

### Line-by-line Explanation:
```java
LengthUnit(double conversionFactor)  // Constructor for enum - sets conversion factor
    this.conversionFactor = conversionFactor;  // Stores the factor (e.g., 12.0 for FEET)
```

### Example:
```java
LengthUnit.FEET  // Calls constructor with 12.0
LengthUnit.INCHES  // Calls constructor with 1.0
```

---

## 📌 METHOD 2: getConversionFactor()

```java
public double getConversionFactor() {
    return conversionFactor;
}
```

### Purpose: Get the conversion factor for a unit

### Example:
```java
LengthUnit.FEET.getConversionFactor()     // Returns 12.0
LengthUnit.CENTIMETERS.getConversionFactor()  // Returns 0.393701
```

### Use Case:
```java
double factor = LengthUnit.FEET.getConversionFactor();
// factor = 12.0
```

---

## 📌 METHOD 3: convertToBaseUnit()

```java
public double convertToBaseUnit(double value) {
    return value * this.conversionFactor;
}
```

### Purpose: Convert any value from this unit to INCHES (base unit)

### Line-by-line:
```java
public double convertToBaseUnit(double value)  // Input: value in this unit
    return value * this.conversionFactor;      // Output: equivalent value in inches
```

### Examples:

**Example 1: Convert 1 FOOT to INCHES**
```java
double result = LengthUnit.FEET.convertToBaseUnit(1.0);
// Calculation: 1.0 * 12.0 = 12.0 inches
// Result: 12.0
```

**Example 2: Convert 3 YARDS to INCHES**
```java
double result = LengthUnit.YARDS.convertToBaseUnit(3.0);
// Calculation: 3.0 * 36.0 = 108.0 inches
// Result: 108.0
```

**Example 3: Convert 2.54 CENTIMETERS to INCHES**
```java
double result = LengthUnit.CENTIMETERS.convertToBaseUnit(2.54);
// Calculation: 2.54 * 0.393701 = 1.0 inches (approx)
// Result: 1.0
```

### Why Multiply?
The conversion factor IS the multiplier because it's defined as "how many inches equals 1 unit"
- 1 foot = 12 inches, so multiply feet by 12 to get inches
- 1 yard = 36 inches, so multiply yards by 36 to get inches

---

## 📌 METHOD 4: convertFromBaseUnit()

```java
public double convertFromBaseUnit(double baseValue) {
    return baseValue / this.conversionFactor;
}
```

### Purpose: Convert from INCHES (base unit) to this unit

### Line-by-line:
```java
public double convertFromBaseUnit(double baseValue)  // Input: value in inches
    return baseValue / this.conversionFactor;        // Output: equivalent in this unit
```

### Examples:

**Example 1: Convert 12 INCHES to FEET**
```java
double result = LengthUnit.FEET.convertFromBaseUnit(12.0);
// Calculation: 12.0 / 12.0 = 1.0 foot
// Result: 1.0
```

**Example 2: Convert 36 INCHES to YARDS**
```java
double result = LengthUnit.YARDS.convertFromBaseUnit(36.0);
// Calculation: 36.0 / 36.0 = 1.0 yard
// Result: 1.0
```

**Example 3: Convert 1 INCH to CENTIMETERS**
```java
double result = LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0);
// Calculation: 1.0 / 0.393701 = 2.54 cm
// Result: 2.54
```

### Why Divide?
We divide by the conversion factor because we're reversing the operation:
- If 12 inches = 1 foot, then X inches = X/12 feet
- If 36 inches = 1 yard, then X inches = X/36 yards

---

---

# 🔧 CLASS 2: `Length.java` (Main Class - Handles Measurements)

## Purpose
Represents a physical length with a value and unit. Handles equality comparisons, conversions, and arithmetic operations on lengths.

## Location
`src/main/java/com/apps/quantitymeasurement/Length.java`

---

## 📋 CLASS VARIABLES

```java
private final double value;           // The numeric value (e.g., 5.0)
private final LengthUnit unit;        // The unit (e.g., FEET)
private static final double EPSILON = 0.0001;  // Tolerance for comparisons
```

### Explanation:
- **value**: How much of the unit (e.g., 5.0 feet means 5 units of FEET)
- **unit**: What unit it is (FEET, INCHES, YARDS, CENTIMETERS)
- **EPSILON**: Error margin for floating-point comparisons (±0.0001)
- **final**: Variables cannot be changed after creation (immutable)
- **static**: EPSILON is shared by all Length objects

### Why EPSILON?
Floating-point numbers have precision issues:
```java
0.1 + 0.2 = 0.30000000000000004  // Not exactly 0.3!
// EPSILON allows us to treat close values as equal
```

---

## 📌 METHOD 1: Constructor - Length()

```java
public Length(double value, LengthUnit unit) {
    if((Double.isNaN(value)) || (Double.isInfinite(value))) {
        throw new IllegalArgumentException("Invalid numeric value");
    }
    if(unit == null) {
        throw new IllegalArgumentException("Length unit cannot be null");
    }
    this.value = value;
    this.unit = unit;
}
```

### Line-by-line Explanation:

```java
public Length(double value, LengthUnit unit)  // Create a new Length with value and unit
    if((Double.isNaN(value)) || (Double.isInfinite(value)))  // If value is NaN or Infinity
        throw new IllegalArgumentException("Invalid numeric value");  // Reject it!
    if(unit == null)  // If unit wasn't provided
        throw new IllegalArgumentException("Length unit cannot be null");  // Reject it!
    this.value = value;  // Store the value
    this.unit = unit;    // Store the unit
```

### Purpose: 
- Create a new Length object with validation
- Ensure value is a valid number (not NaN or Infinity)
- Ensure unit is provided (not null)

### Examples:

**Example 1: Create 5 feet**
```java
Length length = new Length(5.0, LengthUnit.FEET);
// Creates: Length with value=5.0, unit=FEET
```

**Example 2: Create 12 inches**
```java
Length length = new Length(12.0, LengthUnit.INCHES);
// Creates: Length with value=12.0, unit=INCHES
```

**Example 3: Create 100 centimeters**
```java
Length length = new Length(100.0, LengthUnit.CENTIMETERS);
// Creates: Length with value=100.0, unit=CENTIMETERS
```

**Example 4: Try invalid value (fails)**
```java
Length length = new Length(Double.NaN, LengthUnit.FEET);
// Throws: IllegalArgumentException: "Invalid numeric value"
```

---

## 📌 METHOD 2: convertToBaseUnit() (Private Helper)

```java
private double convertToBaseUnit() {
    return this.unit.convertToBaseUnit(this.value);
}
```

### Purpose: Convert this length's value to inches

### Line-by-line:
```java
private double convertToBaseUnit()  // Helper method (only for internal use)
    return this.unit.convertToBaseUnit(this.value);  // Delegate to unit's method
```

### Example:
If this Length object is `5 FEET`:
```java
double resultInInches = convertToBaseUnit();
// Calls: LengthUnit.FEET.convertToBaseUnit(5.0)
// Returns: 5.0 * 12.0 = 60.0 (inches)
```

---

## 📌 METHOD 3: round() (Private Helper)

```java
private static double round(double value) {
    return Math.round(value * 10000.0) / 10000.0;
}
```

### Purpose: Round a number to 4 decimal places

### Line-by-line:
```java
private static double round(double value)         // Takes any double number
    return Math.round(value * 10000.0) / 10000.0; // Rounds to 4 decimal places
```

### How It Works:
```
Step 1: value * 10000.0    (multiply by 10000)
Step 2: Math.round()       (round to nearest integer)
Step 3: / 10000.0          (divide by 10000)

Example: round(1.23456)
  1.23456 * 10000 = 12345.6
  Math.round(12345.6) = 12346
  12346 / 10000.0 = 1.2346 (rounded to 4 decimals)
```

### Why Round?
Conversions can produce long decimals:
```java
24 / 36 = 0.666666666...  // Too many decimals!
round(0.666666666) = 0.6667  // Clean 4 decimals
```

---

## 📌 METHOD 4: convertTo()

```java
public Length convertTo(LengthUnit targetUnit) {
    if(targetUnit == null) {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double valueInBaseUnit = this.convertToBaseUnit();
    double convertedValue = targetUnit.convertFromBaseUnit(valueInBaseUnit);
    return new Length(round(convertedValue), targetUnit);
}
```

### Purpose: Convert this length to a different unit

### Line-by-line Explanation:

```java
public Length convertTo(LengthUnit targetUnit)         // Input: desired target unit
    if(targetUnit == null)                             // Validate target unit
        throw new IllegalArgumentException(...)        // Reject if null
    double valueInBaseUnit = this.convertToBaseUnit(); // Convert this to base unit (inches)
    double convertedValue = targetUnit.convertFromBaseUnit(valueInBaseUnit);  // Convert inches to target
    return new Length(round(convertedValue), targetUnit);  // Return new Length in target unit
```

### Conversion Process:
```
Original: 1 FOOT
    ↓ (convertToBaseUnit)
In Inches: 12.0 INCHES
    ↓ (convertFromBaseUnit with YARDS)
Target: 0.3333 YARDS
```

### Examples:

**Example 1: Convert 1 FOOT to INCHES**
```java
Length length = new Length(1.0, LengthUnit.FEET);
Length result = length.convertTo(LengthUnit.INCHES);

// Step 1: convertToBaseUnit()
//   1.0 * 12.0 = 12.0 inches
// Step 2: convertFromBaseUnit(12.0)
//   12.0 / 1.0 = 12.0 inches
// Result: Length(12.0, INCHES)
```

**Example 2: Convert 36 INCHES to YARDS**
```java
Length length = new Length(36.0, LengthUnit.INCHES);
Length result = length.convertTo(LengthUnit.YARDS);

// Step 1: convertToBaseUnit()
//   36.0 * 1.0 = 36.0 inches
// Step 2: convertFromBaseUnit(36.0)
//   36.0 / 36.0 = 1.0 yard
// Result: Length(1.0, YARDS)
```

**Example 3: Convert 100 CENTIMETERS to YARDS**
```java
Length length = new Length(100.0, LengthUnit.CENTIMETERS);
Length result = length.convertTo(LengthUnit.YARDS);

// Step 1: convertToBaseUnit()
//   100.0 * 0.393701 = 39.3701 inches
// Step 2: convertFromBaseUnit(39.3701)
//   39.3701 / 36.0 = 1.0937 yards
// Result: Length(1.0937, YARDS)
```

---

## 📌 METHOD 5: compare()

```java
public boolean compare(Length thatLength) {
    if(thatLength == null) {
        throw new IllegalArgumentException("Cannot compare with null Length");
    }
    return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < EPSILON;
}
```

### Purpose: Compare if two lengths are equal (within tolerance)

### Line-by-line:
```java
public boolean compare(Length thatLength)  // Input: another length to compare
    if(thatLength == null)                 // If null, throw error
        throw new IllegalArgumentException(...)
    return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < EPSILON;
    // Convert both to base unit, find difference, check if < EPSILON
```

### How It Works:
```
Step 1: Convert this length to inches
Step 2: Convert other length to inches
Step 3: Find absolute difference
Step 4: If difference < 0.0001, they're equal
```

### Examples:

**Example 1: Compare 1 FOOT and 12 INCHES**
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(12.0, LengthUnit.INCHES);
boolean equal = length1.compare(length2);

// length1: 1.0 * 12.0 = 12.0 inches
// length2: 12.0 * 1.0 = 12.0 inches
// Difference: |12.0 - 12.0| = 0 < 0.0001
// Result: true ✅
```

**Example 2: Compare 1 YARD and 36 INCHES**
```java
Length length1 = new Length(1.0, LengthUnit.YARDS);
Length length2 = new Length(36.0, LengthUnit.INCHES);
boolean equal = length1.compare(length2);

// length1: 1.0 * 36.0 = 36.0 inches
// length2: 36.0 * 1.0 = 36.0 inches
// Difference: |36.0 - 36.0| = 0 < 0.0001
// Result: true ✅
```

**Example 3: Compare 5 FEET and 60 INCHES**
```java
Length length1 = new Length(5.0, LengthUnit.FEET);
Length length2 = new Length(60.0, LengthUnit.INCHES);
boolean equal = length1.compare(length2);

// length1: 5.0 * 12.0 = 60.0 inches
// length2: 60.0 * 1.0 = 60.0 inches
// Difference: |60.0 - 60.0| = 0 < 0.0001
// Result: true ✅
```

**Example 4: Compare 1 FOOT and 11 INCHES (not equal)**
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(11.0, LengthUnit.INCHES);
boolean equal = length1.compare(length2);

// length1: 1.0 * 12.0 = 12.0 inches
// length2: 11.0 * 1.0 = 11.0 inches
// Difference: |12.0 - 11.0| = 1.0 (NOT < 0.0001)
// Result: false ❌
```

---

## 📌 METHOD 6: equals() (Override)

```java
@Override
public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    
    Length other = (Length) obj;
    return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
}
```

### Purpose: Check if two Length objects are equal (Java standard method)

### Line-by-line:
```java
@Override  // Overriding Java's equals method
public boolean equals(Object obj)  // Takes any Object for comparison

    if(this == obj) return true;   // Same object? Yes = equal
    
    if(obj == null || getClass() != obj.getClass()) return false;
    // If obj is null OR obj is not a Length? No = not equal
    
    Length other = (Length) obj;   // Convert to Length
    return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    // Compare values in base unit with tolerance
```

### Example:
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(12.0, LengthUnit.INCHES);

if(length1.equals(length2)) {  // ✅ true
    System.out.println("They are equal!");
}
```

---

## 📌 METHOD 7: hashCode() (Override)

```java
@Override
public int hashCode() {
    return Double.hashCode(this.convertToBaseUnit());
}
```

### Purpose: Generate a unique number for this object (for HashMaps/HashSets)

### Example:
```java
Length length1 = new Length(1.0, LengthUnit.FEET);    // 12.0 inches
Length length2 = new Length(12.0, LengthUnit.INCHES); // 12.0 inches

// Both have same hashCode because same value in base unit
int hash1 = length1.hashCode();  // Some number
int hash2 = length2.hashCode();  // Same number!
```

---

## 📌 METHOD 8: toString()

```java
@Override
public String toString() {
    return String.format("%.2f %s", value, unit.name());
}
```

### Purpose: Convert Length to human-readable string

### Line-by-line:
```java
@Override
public String toString()  // Java standard method for string representation
    return String.format("%.2f %s", value, unit.name());
    // Format: "value unit" e.g., "5.00 FEET"
    // %.2f = 2 decimal places
    // %s = unit name (FEET, INCHES, etc)
```

### Examples:
```java
Length length1 = new Length(5.0, LengthUnit.FEET);
System.out.println(length1);  // Output: 5.00 FEET

Length length2 = new Length(12.5, LengthUnit.INCHES);
System.out.println(length2);  // Output: 12.50 INCHES

Length length3 = new Length(1.3333, LengthUnit.YARDS);
System.out.println(length3);  // Output: 1.33 YARDS
```

---

## 📌 METHOD 9: getValue()

```java
public double getValue() {
    return value;
}
```

### Purpose: Get the numeric value of this length

### Example:
```java
Length length = new Length(5.0, LengthUnit.FEET);
double val = length.getValue();  // Returns 5.0
```

---

## 📌 METHOD 10: getUnit()

```java
public LengthUnit getUnit() {
    return unit;
}
```

### Purpose: Get the unit of this length

### Example:
```java
Length length = new Length(5.0, LengthUnit.FEET);
LengthUnit unit = length.getUnit();  // Returns LengthUnit.FEET
```

---

## 📌 METHOD 11: add() - Add two lengths

```java
public Length add(Length thatLength) {
    if(thatLength == null) {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInThisUnit = this.unit.convertFromBaseUnit(sumInBaseUnit);
    return new Length(round(sumInThisUnit), this.unit);
}
```

### Purpose: Add two lengths, result in first length's unit

### Line-by-line:
```java
public Length add(Length thatLength)  // Input: another length to add
    if(thatLength == null)            // Validate input
        throw new IllegalArgumentException(...)
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    // Convert both to inches and add them
    double sumInThisUnit = this.unit.convertFromBaseUnit(sumInBaseUnit);
    // Convert result back to this unit
    return new Length(round(sumInThisUnit), this.unit);
    // Return new Length in this unit
```

### Addition Process:
```
Length1: 1 FOOT    →  12.0 INCHES
Length2: 12 INCHES →  12.0 INCHES
Sum in base: 12.0 + 12.0 = 24.0 INCHES
Back to FEET: 24.0 / 12.0 = 2.0 FEET
Result: Length(2.0, FEET)
```

### Examples:

**Example 1: Add 1 FOOT + 1 FOOT**
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(1.0, LengthUnit.FEET);
Length result = length1.add(length2);

// 1 FOOT = 12 inches
// 1 FOOT = 12 inches
// Sum = 24 inches = 2 FEET
// Result: Length(2.0, FEET)
```

**Example 2: Add 1 FOOT + 12 INCHES**
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(12.0, LengthUnit.INCHES);
Length result = length1.add(length2);

// 1 FOOT = 12 inches
// 12 INCHES = 12 inches
// Sum = 24 inches = 2 FEET
// Result: Length(2.0, FEET)
```

**Example 3: Add 1 YARD + 3 FEET**
```java
Length length1 = new Length(1.0, LengthUnit.YARDS);
Length length2 = new Length(3.0, LengthUnit.FEET);
Length result = length1.add(length2);

// 1 YARD = 36 inches
// 3 FEET = 36 inches
// Sum = 72 inches = 2 YARDS
// Result: Length(2.0, YARDS)
```

---

## 📌 METHOD 12: add() - Add with target unit

```java
public Length add(Length thatLength, LengthUnit targetUnit) {
    if(thatLength == null) {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    if(targetUnit == null) {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumInBaseUnit);
    return new Length(round(sumInTargetUnit), targetUnit);
}
```

### Purpose: Add two lengths, result in specified target unit

### Line-by-line:
```java
public Length add(Length thatLength, LengthUnit targetUnit)
    // Same as before, but result in targetUnit instead of this.unit
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumInBaseUnit);
    return new Length(round(sumInTargetUnit), targetUnit);
```

### Examples:

**Example 1: Add 1 FOOT + 12 INCHES, result in YARDS**
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
Length length2 = new Length(12.0, LengthUnit.INCHES);
Length result = length1.add(length2, LengthUnit.YARDS);

// 1 FOOT = 12 inches
// 12 INCHES = 12 inches
// Sum = 24 inches
// Convert to YARDS: 24 / 36 = 0.6667 YARDS
// Result: Length(0.6667, YARDS)
```

**Example 2: Add 6 INCHES + 6 INCHES, result in FEET**
```java
Length length1 = new Length(6.0, LengthUnit.INCHES);
Length length2 = new Length(6.0, LengthUnit.INCHES);
Length result = length1.add(length2, LengthUnit.FEET);

// 6 INCHES = 6 inches
// 6 INCHES = 6 inches
// Sum = 12 inches
// Convert to FEET: 12 / 12 = 1.0 FEET
// Result: Length(1.0, FEET)
```

---

---

# 🔧 CLASS 3: `QuantityMeasurementApp.java` (Main Application)

## Purpose
Provides interactive menu and demonstrates all Length/LengthUnit operations through user input.

## Location
`src/main/java/com/apps/quantitymeasurement/QuantityMeasurementApp.java`

---

## 📌 HELPER METHOD: readLength()

```java
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
```

### Purpose: Ask user for a length value and unit, create Length object

### Line-by-line:
```java
private static Length readLength(Scanner scanner)  // Scanner reads user input
    System.out.print("Enter length value: ");      // Ask for number
    double value = scanner.nextDouble();           // Read number
    System.out.print("Enter length unit...");      // Ask for unit
    String unitInput = scanner.next().toUpperCase();  // Read as uppercase
    LengthUnit unit;                               // Declare unit variable
    try {
        unit = LengthUnit.valueOf(unitInput);      // Convert string to enum
    } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(...)    // Invalid unit? Throw error
    }
    return new Length(value, unit);                // Create and return Length
```

### Example Usage:
```
User Input:
  Enter length value: 5.0
  Enter length unit: FEET

Result: Length object with value=5.0, unit=FEET
```

---

## 📌 METHOD: demonstrateLengthAddition()

```java
public static Length demonstrateLengthAddition(Scanner scanner) {
    Length length1 = readLength(scanner);
    Length length2 = readLength(scanner);

    System.out.println("Input: Quantity 1: " + length1.getValue() + " " + 
                       length1.getUnit().name().toLowerCase() +
                       ", Quantity 2: " + length2.getValue() + " " + 
                       length2.getUnit().name().toLowerCase());
    Length sumLength = length1.add(length2);
    System.out.println("Output: Sum (" + sumLength.getValue() + " " + 
                       sumLength.getUnit().name().toLowerCase() + ")");
    return sumLength;
}
```

### Purpose: Interactively add two lengths

### Example Execution:
```
Input:
  Length 1: 5.0 FEET
  Length 2: 12 INCHES

Output:
  Input: Quantity 1: 5.0 feet, Quantity 2: 12.0 inches
  Output: Sum (5.5 feet)
```

---

## 📌 METHOD: demonstrateLengthConversion()

```java
public static Length demonstrateLengthConversion(Scanner scanner) {
    System.out.print("Enter length value: ");
    double value = scanner.nextDouble();

    System.out.print("Enter length unit: ");
    String fromUnitInput = scanner.next().toUpperCase();
    LengthUnit fromUnit = LengthUnit.valueOf(fromUnitInput);

    System.out.print("Enter target length unit: ");
    String toUnitInput = scanner.next().toUpperCase();
    LengthUnit toUnit = LengthUnit.valueOf(toUnitInput);

    Length tempLength = new Length(value, fromUnit);
    return tempLength.convertTo(toUnit);
}
```

### Purpose: Convert one unit to another

### Example:
```
Input: 1.0 FEET converted to INCHES

Output: Length(12.0, INCHES)
```

---

## 📌 METHOD: demonstrateLengthAdditionWithTargetUnit()

```java
public static Length demonstrateLengthAdditionWithTargetUnit(Scanner scanner) {
    Length length1 = readLength(scanner);
    Length length2 = readLength(scanner);
    
    System.out.print("Enter target unit for result: ");
    String targetUnitInput = scanner.next().toUpperCase();
    LengthUnit targetUnit = LengthUnit.valueOf(targetUnitInput);

    System.out.println("Input: Quantity 1: " + length1.getValue() + " " + 
                       length1.getUnit().name().toLowerCase() +
                       ", Quantity 2: " + length2.getValue() + " " + 
                       length2.getUnit().name().toLowerCase() +
                       ", Target Unit: " + targetUnit.name().toLowerCase());
    
    Length sumLength = length1.add(length2, targetUnit);
    System.out.println("Output: Sum (" + sumLength.getValue() + " " + 
                       sumLength.getUnit().name().toLowerCase() + ")");
    return sumLength;
}
```

### Purpose: Add two lengths with custom result unit

### Example:
```
Input:
  Length 1: 1.0 FOOT
  Length 2: 12.0 INCHES
  Target Unit: YARDS

Output:
  Input: Quantity 1: 1.0 feet, Quantity 2: 12.0 inches, Target Unit: yards
  Output: Sum (0.6667 yards)
```

---

## 📌 MAIN METHOD: main()

```java
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
                System.out.println("\nDemonstrating Length Addition with Target Unit:");
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
    }
}
```

### Purpose: Entry point of application

### Line-by-line:
```java
public static void main(String[] args)        // Entry point
    Scanner scanner = new Scanner(System.in);  // Create scanner for user input
    try (scanner) {                            // Auto-close scanner
        // Display menu
        // Read user choice
        // Execute corresponding operation
    } catch (Exception e) {                    // Handle any errors
        System.err.println("Error: " + e.getMessage());
    }
```

---

---

# 🧪 CLASS 4: `QuantityMeasurementAppTest.java` (Unit Tests)

## Purpose
Tests all functionality of Length and LengthUnit classes to ensure they work correctly.

## Location
`src/test/java/com/apps/quantitymeasurement/QuantityMeasurementAppTest.java`

## Total Tests: 109

### Test Categories:

1. **UC3: Equality Tests** (15 tests)
   - Same unit equality
   - Cross-unit equality
   - Null handling

2. **UC4: Yard Tests** (15 tests)
   - Yard to yard comparison
   - Yard to other units
   - Non-equivalence cases

3. **UC5: Conversion Tests** (15 tests)
   - Conversions between all units
   - Zero value handling
   - Negative value handling
   - Precision tests

4. **UC6: Addition Tests** (20 tests)
   - Same unit addition
   - Cross-unit addition
   - Result precision
   - Large/small values

5. **UC7: Addition with Target Unit** (44+ tests)
   - Addition with explicit target unit
   - Commutativity
   - All unit combinations
   - Precision handling

---

---

# 📊 PROJECT ARCHITECTURE

## Class Relationships

```
LengthUnit (Enum)
    ├── Defines: FEET, INCHES, YARDS, CENTIMETERS
    ├── Methods: convertToBaseUnit(), convertFromBaseUnit()
    └── Used by: Length class

Length (Main Class)
    ├── Uses: LengthUnit (composition)
    ├── Methods: convertTo(), add(), equals(), compare()
    └── Used by: QuantityMeasurementApp

QuantityMeasurementApp (Application)
    ├── Uses: Length class (creates instances)
    ├── Uses: LengthUnit enum (specifies units)
    └── Methods: demonstrateLengthAddition(), demonstrateLengthConversion()

QuantityMeasurementAppTest (Tests)
    ├── Tests: Length class functionality
    ├── Tests: LengthUnit conversions
    └── Validates: All UC1-UC7 requirements
```

---

---

# 🎯 COMPLETE WORKFLOW EXAMPLE

## Scenario: Add 1 FOOT + 12 INCHES, result in FEET

### Step 1: Create first length
```java
Length length1 = new Length(1.0, LengthUnit.FEET);
// Creates Length object with value=1.0, unit=FEET
```

### Step 2: Create second length
```java
Length length2 = new Length(12.0, LengthUnit.INCHES);
// Creates Length object with value=12.0, unit=INCHES
```

### Step 3: Add with target unit
```java
Length result = length1.add(length2, LengthUnit.FEET);
```

### Step 4: Execution Inside add() Method
```
Step A: Validate inputs
  ✓ length2 is not null
  ✓ LengthUnit.FEET is not null

Step B: Convert to base unit
  length1 in base: 1.0 * 12.0 = 12.0 inches
  length2 in base: 12.0 * 1.0 = 12.0 inches
  sumInBaseUnit = 12.0 + 12.0 = 24.0 inches

Step C: Convert to target unit
  sumInTargetUnit = LengthUnit.FEET.convertFromBaseUnit(24.0)
                  = 24.0 / 12.0 = 2.0 feet

Step D: Round result
  rounded = round(2.0) = 2.0 (already round)

Step E: Create and return new Length
  return new Length(2.0, LengthUnit.FEET);
```

### Step 5: Result
```java
System.out.println(result);  // Output: 2.00 FEET
System.out.println(result.getValue());  // Output: 2.0
System.out.println(result.getUnit());  // Output: FEET
```

---

---

# 🔐 KEY DESIGN PRINCIPLES

## 1. **Single Responsibility Principle**
- `LengthUnit`: Only handles unit conversions
- `Length`: Only handles length values and comparisons
- `QuantityMeasurementApp`: Only handles user interaction

## 2. **Immutability**
- `value` is `final` - cannot change after creation
- `unit` is `final` - cannot change after creation
- All operations return NEW Length objects

## 3. **Encapsulation**
- `private` fields cannot be accessed directly
- Only public methods allow interaction
- Internal logic hidden from users

## 4. **Precision Handling**
- EPSILON tolerance for floating-point comparisons
- 4-decimal-place rounding for conversions
- Avoids floating-point errors

## 5. **Validation**
- Constructor validates inputs
- Methods check for null values
- Detailed error messages

---

This completes the full project documentation! 🎉

**Every class, method, and functionality has been explained with examples!**
