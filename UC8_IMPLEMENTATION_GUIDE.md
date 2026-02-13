# UC8 Implementation Guide - Step-by-Step Process

## Overview
UC8 refactors the design from UC1–UC7 by extracting the `LengthUnit` enum from inside the `Length` class into a standalone, top-level class. This improves code cohesion, reduces coupling, and establishes a scalable pattern for additional measurement categories.

---

## Prerequisites
- Java 8 or higher
- Maven installed
- All UC1-UC7 test cases passing
- Project structure with:
  - `src/main/java/com/apps/quantitymeasurement/Length.java`
  - `src/test/java/com/apps/quantitymeasurement/QuantityMeasurementAppTest.java`

---

## Step-by-Step Process

### **STEP 1: Create Standalone LengthUnit.java File**

**Location:** `src/main/java/com/apps/quantitymeasurement/LengthUnit.java`

**What to do:**
1. Create a new file named `LengthUnit.java` in the package `com.apps.quantitymeasurement`
2. Move the entire `LengthUnit` enum from inside `Length` class to this new file
3. Add the package declaration and necessary imports

**File Content:**
```java
package com.apps.quantitymeasurement;

//UC8: Standalone LengthUnit Class - Extracted from nested enum in Length class
/**
 * LengthUnit enum - Standalone class responsible for unit conversions.
 * 
 * UC8 Refactoring: Extracted from Length class to follow Single Responsibility Principle.
 * This enum now owns all conversion logic between different length units.
 * 
 * Base Unit: INCHES (all conversions are relative to inches)
 */
public enum LengthUnit {
    FEET(12.0),           // 1 foot = 12 inches
    INCHES(1.0),          // 1 inch = 1 inch (base unit)
    YARDS(36.0),          // 1 yard = 36 inches
    CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

    private final double conversionFactor;

    /**
     * Constructor for LengthUnit enum.
     * 
     * @param conversionFactor The conversion factor from this unit to the base unit (inches)
     */
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Gets the conversion factor for this unit.
     * 
     * @return The conversion factor relative to inches (base unit)
     */
    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value in this unit to the base unit (inches).
     * 
     * UC8: New responsibility - Convert to base unit
     * 
     * @param value The value in this unit
     * @return The equivalent value in inches (base unit)
     */
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    /**
     * Converts a value from the base unit (inches) to this unit.
     * 
     * UC8: New responsibility - Convert from base unit
     * 
     * @param baseValue The value in inches (base unit)
     * @return The equivalent value in this unit
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}
```

**Key Points:**
- The enum contains all four units: `FEET`, `INCHES`, `YARDS`, `CENTIMETERS`
- Two new methods added: `convertToBaseUnit()` and `convertFromBaseUnit()`
- All conversion logic is now centralized in this class

---

### **STEP 2: Remove LengthUnit Enum from Length.java**

**File:** `src/main/java/com/apps/quantitymeasurement/Length.java`

**What to do:**
1. Remove the nested `LengthUnit` enum declaration from inside the `Length` class
2. Keep all other code in the `Length` class unchanged
3. Ensure the class imports are updated

**Changes Made:**
- Delete lines containing the entire enum definition (from `public enum LengthUnit {` to the closing `}`)

**Result:**
The `Length` class now imports `LengthUnit` from the standalone class instead of defining it internally.

---

### **STEP 3: Update Package and Import Statements**

**File:** `src/main/java/com/apps/quantitymeasurement/Length.java`

**What to do:**
Update the class header with UC8 comment:

```java
package com.apps.quantitymeasurement;

//UC8: LengthUnit extracted to standalone class (not nested anymore)
/**
 * Length class - Refactored in UC8 to simplify by delegating unit conversion logic.
 * 
 * UC8 Refactoring:
 * - LengthUnit enum extracted to standalone class (reduces coupling, improves cohesion)
 * - Length now focuses on value comparison and arithmetic operations
 * - Conversion logic delegated to LengthUnit class
 * 
 * Maintains backward compatibility: All public APIs unchanged
 */
public class Length {
    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;
```

**Key Points:**
- No explicit import statement is needed since both classes are in the same package
- Java will automatically resolve the `LengthUnit` reference to the enum class

---

### **STEP 4: Refactor Conversion Logic in Length.java**

**File:** `src/main/java/com/apps/quantitymeasurement/Length.java`

**What to do:**
Replace all direct conversion calculations with delegated method calls to `LengthUnit`.

#### **Change 4.1: convertToBaseUnit() method**

**Before (UC1-UC7):**
```java
private double convertToBaseUnit()
{
    return this.value * this.unit.getConversionFactor();
}
```

**After (UC8):**
```java
//UC8: Delegated to LengthUnit for centralized conversion logic
private double convertToBaseUnit()
{
    return this.unit.convertToBaseUnit(this.value);
}
```

#### **Change 4.2: convertTo() method**

**Before (UC1-UC7):**
```java
public Length convertTo(LengthUnit targetUnit)
{
    if(targetUnit == null)
    {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double valueInBaseUnit = this.convertToBaseUnit();
    double convertedValue = valueInBaseUnit / targetUnit.getConversionFactor();
    return new Length(round(convertedValue), targetUnit);
}
```

**After (UC8):**
```java
//UC8: Using delegated unit conversion methods for consistency
public Length convertTo(LengthUnit targetUnit)
{
    if(targetUnit == null)
    {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double valueInBaseUnit = this.convertToBaseUnit();
    double convertedValue = targetUnit.convertFromBaseUnit(valueInBaseUnit);
    return new Length(round(convertedValue), targetUnit);
}
```

#### **Change 4.3: add() method (UC6)**

**Before (UC1-UC7):**
```java
//UC6
public Length add(Length thatLength)
{
    if(thatLength == null)
    {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInThisUnit = sumInBaseUnit / this.unit.getConversionFactor();
    return new Length(round(sumInThisUnit), this.unit);
}
```

**After (UC8):**
```java
//UC6
//UC8: Using delegated unit conversion methods
public Length add(Length thatLength)
{
    if(thatLength == null)
    {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInThisUnit = this.unit.convertFromBaseUnit(sumInBaseUnit);
    return new Length(round(sumInThisUnit), this.unit);
}
```

#### **Change 4.4: add() method with target unit (UC7)**

**Before (UC1-UC7):**
```java
//UC7
public Length add(Length thatLength, LengthUnit targetUnit)
{
    if(thatLength == null)
    {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    if(targetUnit == null)
    {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInTargetUnit = sumInBaseUnit / targetUnit.getConversionFactor();
    return new Length(round(sumInTargetUnit), targetUnit);
}
```

**After (UC8):**
```java
//UC7
//UC8: Using delegated unit conversion methods
public Length add(Length thatLength, LengthUnit targetUnit)
{
    if(thatLength == null)
    {
        throw new IllegalArgumentException("Cannot add null Length");
    }
    if(targetUnit == null)
    {
        throw new IllegalArgumentException("Target unit cannot be null");
    }
    double sumInBaseUnit = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
    double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumInBaseUnit);
    return new Length(round(sumInTargetUnit), targetUnit);
}
```

---

### **STEP 5: Update Test File Imports**

**File:** `src/test/java/com/apps/quantitymeasurement/QuantityMeasurementAppTest.java`

**What to do:**
Update the import statement to remove the nested enum reference.

**Before (UC1-UC7):**
```java
package com.apps.quantitymeasurement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.apps.quantitymeasurement.Length.LengthUnit;

/**
 * Unit test for simple App.
 */
```

**After (UC8):**
```java
package com.apps.quantitymeasurement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for QuantityMeasurementApp
 * 
 * UC8 Update: Import LengthUnit from standalone class (no longer nested in Length)
 */
```

**Key Points:**
- No explicit import needed since `LengthUnit` is now in the same package
- Java will automatically resolve the reference
- All test cases using `LengthUnit.FEET`, `LengthUnit.INCHES`, etc. will still work

---

### **STEP 6: Compile and Verify All Tests Pass**

**What to do:**
1. Open terminal in the project root directory: `c:\Users\PR20552518\Desktop\QuanittyMeasurementApp\demo`

2. Clean and rebuild the project:
```powershell
mvn clean compile
```

3. Run all tests:
```powershell
mvn test
```

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] Tests run: XX, Failures: 0, Errors: 0
```

**Key Points:**
- All UC1-UC7 test cases should pass without modification
- Backward compatibility is fully maintained
- No changes needed to test logic or assertions

---

### **STEP 7: Verify No Circular Dependencies**

**What to do:**
Check that the project structure follows the Single Responsibility Principle:

1. **LengthUnit.java responsibilities:**
   - ✅ Store unit definitions (FEET, INCHES, YARDS, CENTIMETERS)
   - ✅ Handle conversion factors
   - ✅ Convert values to base unit
   - ✅ Convert values from base unit

2. **Length.java responsibilities:**
   - ✅ Store length value and unit
   - ✅ Compare lengths for equality
   - ✅ Perform arithmetic operations (addition)
   - ✅ Delegate conversion logic to LengthUnit

3. **QuantityMeasurementAppTest.java responsibilities:**
   - ✅ Test all methods in Length class
   - ✅ Verify conversion functionality
   - ✅ Validate arithmetic operations
   - ✅ Test edge cases and error handling

---

## Benefits of UC8 Refactoring

### ✅ **Single Responsibility Principle**
- `LengthUnit` handles all unit-related conversions
- `Length` handles comparison and arithmetic operations

### ✅ **Reduced Coupling**
- No nested enum prevents circular dependencies
- Each class is independently testable
- Changes to unit logic don't affect Length class interface

### ✅ **Improved Cohesion**
- All unit conversion logic is centralized
- Easy to add new units or modify conversion factors
- Clear separation of concerns

### ✅ **Scalability Pattern**
- Template established for future measurement categories:
  - `WeightUnit` enum
  - `VolumeUnit` enum
  - `TemperatureUnit` enum
  - `Weight`, `Volume`, `Temperature` classes

### ✅ **Backward Compatibility**
- All public APIs remain unchanged
- Existing test cases pass without modification
- Client code continues to work

---

## File Structure After UC8

```
src/
├── main/
│   └── java/
│       └── com/
│           └── apps/
│               └── quantitymeasurement/
│                   ├── Length.java              (Refactored - delegates to LengthUnit)
│                   ├── LengthUnit.java          (NEW - Extracted enum with conversion logic)
│                   └── QuantityMeasurementApp.java
└── test/
    └── java/
        └── com/
            └── apps/
                └── quantitymeasurement/
                    └── QuantityMeasurementAppTest.java (Updated imports)
```

---

## Summary of Changes

| Component | Change | Reason |
|-----------|--------|--------|
| LengthUnit.java | NEW FILE - Created as standalone enum | Centralize unit conversion logic |
| Length.java | Removed nested enum | Reduce coupling |
| Length.java | Updated convertToBaseUnit() | Delegate to LengthUnit |
| Length.java | Updated convertTo() | Use LengthUnit methods |
| Length.java | Updated add() methods | Use LengthUnit.convertFromBaseUnit() |
| QuantityMeasurementAppTest.java | Updated imports | Remove nested enum reference |

---

## Validation Checklist

- [ ] LengthUnit.java created with all enum constants
- [ ] convertToBaseUnit() method added to LengthUnit
- [ ] convertFromBaseUnit() method added to LengthUnit
- [ ] Nested enum removed from Length.java
- [ ] Length class updated to delegate conversions
- [ ] Test file imports updated
- [ ] Project compiles without errors
- [ ] All UC1-UC7 tests pass
- [ ] No new compilation warnings
- [ ] Code follows Single Responsibility Principle
- [ ] No circular dependencies exist

---

## Next Steps (Future Use Cases)

With UC8 pattern established, you can now:
1. Create `Weight` and `WeightUnit` classes
2. Create `Volume` and `VolumeUnit` classes
3. Create `Temperature` and `TemperatureUnit` classes
4. Each following the same refactored pattern

---

## Questions & Troubleshooting

**Q: Do I need to update client code?**  
A: No! All public APIs remain unchanged. The refactoring is internal.

**Q: Will my tests fail?**  
A: No! All tests should pass without modification due to backward compatibility.

**Q: Can I still use Length.LengthUnit?**  
A: No, but you don't need to. Use `LengthUnit` directly since it's now in the same package.

**Q: What if I have other classes using Length.LengthUnit?**  
A: Update their imports to use `LengthUnit` instead of `Length.LengthUnit`.

---

**UC8 Implementation Complete!** ✅
