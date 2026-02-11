package com.apps.quantitymeasurement;
 
public class Length {
    private final double value;
    private final LengthUnit unit;
 
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);
 
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
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
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
 
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
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
 
    // standalone testing
    // public static void main(String[] args) {
    //     Length l1 = new Length(12.0, LengthUnit.INCHES);
    //     Length l2 = new Length(1.0, LengthUnit.FEET);
    //     System.out.println("Are lengths equal? " + l1.compare(l2));
    // }
}
 
 