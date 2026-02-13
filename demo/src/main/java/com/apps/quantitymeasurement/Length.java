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
    private static final double EPSILON = 0.0001;  // Tolerance for floating-point comparison

    // Constructor
    public Length(double value, LengthUnit unit)
    {
        if((Double.isNaN(value)) || (Double.isInfinite(value)))
        {
            throw new IllegalArgumentException("Invalid numeric value");
        }
        if(unit == null)
        {
            throw new IllegalArgumentException("Length unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    //convert to base unit inches
    //UC8: Delegated to LengthUnit for centralized conversion logic
    private double convertToBaseUnit()
    {
        return this.unit.convertToBaseUnit(this.value);
    }

    //round to 4 decimal places
    private static double round (double value)
    {
        return Math.round(value * 10000.0) / 10000.0;
    }

    //Method to convert Length to another unit
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


    //Equality comparison method

    public boolean compare(Length thatLength)
    {
        if(thatLength == null)
        {
            throw new IllegalArgumentException("Cannot compare with null Length");
        }
        return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < EPSILON;
    }

    //overriding equals method
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    }


    @Override
    public int hashCode()
    {
        return Double.hashCode(this.convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name());
    }

    public double getValue() {
        return value;
    }
    public LengthUnit getUnit() {
        return unit;
    }
    //UC6
    //METHOD TO ADD TWO LENGTHS and return result in specified unit of first length
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

    //UC7
    //METHOD TO ADD TWO LENGTHS and return result in specified target unit
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

    


    //standalone testing
    // public static void main(String[] args) {
    //     Length l1 = new Length(12.0, LengthUnit.INCHES);
    //     Length l2 = new Length(1.0, LengthUnit.FEET);
    //     System.out.println("Are lengths equal? " + l1.compare(l2));

    //     Length l3 = new Length(1.0, LengthUnit.YARDS);
    //     Length l4 = new Length(36.0, LengthUnit.INCHES);
    //     System.out.println("Are lengths equal? " + l3.compare(l4));

    //     Length l5 = new Length(1.0, LengthUnit.CENTIMETERS);
    //     Length l6 = new Length(0.393701, LengthUnit.INCHES);
    //     System.out.println("Are lengths equal? " + l5.compare(l6));


    //     Length l7 = new Length(1, LengthUnit.FEET);
    //     Length l8 = new Length(30.48, LengthUnit.CENTIMETERS);
    //     System.out.println("Are lengths equal? " + l7.compare(l8));


    //     Length l9 = new Length(1, LengthUnit.FEET);
    //     System.out.println("Converted: " + l9.convertTo(LengthUnit.CENTIMETERS));
    //     Length l10 = new Length(91.44, LengthUnit.CENTIMETERS);
    //     System.out.println("Are lengths equal? " + l9.compare(l10));

        
    // }
}   