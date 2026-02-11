package com.apps.quantitymeasurement;

public class Length {
    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;  // Tolerance for floating-point comparison

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);  // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

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

    //convet to base unit inches
    private double convertToBaseUnit()
    {
        return this.value * this.unit.getConversionFactor();
    }

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

    public double getValue() {
        return value;
    }
    public LengthUnit getUnit() {
        return unit;
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


    //     Length l9 = new Length(1, LengthUnit.YARDS);
    //     Length l10 = new Length(91.44, LengthUnit.CENTIMETERS);
    //     System.out.println("Are lengths equal? " + l9.compare(l10));

        
    // }
}