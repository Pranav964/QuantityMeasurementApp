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
