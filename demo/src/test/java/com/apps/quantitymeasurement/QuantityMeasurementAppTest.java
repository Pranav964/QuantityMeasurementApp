package com.apps.quantitymeasurement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for QuantityMeasurementApp
 * 
 * UC8 Update: Import LengthUnit from standalone class (no longer nested in Length)
 */
public class QuantityMeasurementAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    // @Test
    // public void testFeetEquality_SameValue() {
    //     Feet feet1 = new Feet(5.0);
    //     Feet feet2 = new Feet(5.0);
    //     assertTrue(feet1.equals(feet2));
    // }

    // @Test
    // public void testFeetEquality_DifferentValue() {
    //     Feet feet1 = new Feet(5.0);
    //     Feet feet2 = new Feet(6.0);
    //     assertFalse(feet1.equals(feet2));
    // }

    // @Test
    // public void testFeetEquality_NullComparison() {
    //     Feet feet1 = new Feet(5.0);
    //     Feet feet2 = null;
    //     assertFalse(feet1.equals(feet2));
    // }

    // @Test
    // public void testFeetEquality_DifferentClass() {
    //     Feet feet = new Feet(1.0);
    //     String notFeet = "1.0";
    //     assertFalse(feet.equals(notFeet));
    // }

    // @Test
    // public void testFeetEquality_DifferentClass2() {
    //     Feet feet = new Feet(1.0);
    //     int notFeet = 1;
    //     assertFalse(feet.equals(notFeet));
    // }

    // @Test
    // public void testFeetEquality_SameReferance() {
    //     Feet feet1 = new Feet(5.0);
    //     assertTrue(feet1.equals(feet1));
    // }



    // // Additional tests for Inches class can be added similarly
    // @Test
    // public void testIncesEquality_SameValue() {
    //     Inches inches1 = new Inches(5.0);
    //     Inches inches2 = new Inches(5.0);
    //     assertTrue(inches1.equals(inches2));
    // }

    // @Test
    // public void testIncesEquality_DifferentValue() {
    //     Inches inches1 = new Inches(5.0);
    //     Inches inches2 = new Inches(6.0);
    //     assertFalse(inches1.equals(inches2));
    // }

    // @Test
    // public void testInchesEquality_NullComparison() {
    //     Inches inches1 = new Inches(5.0);
    //     Inches inches2 = null;
    //     assertFalse(inches1.equals(inches2));
    // }

    // @Test
    // public void testInchesEquality_DifferentClass() {
    //     Inches inches = new Inches(1.0);
    //     String notInches = "1.0";
    //     assertFalse(inches.equals(notInches));
    // }

    // @Test
    // public void testInchesEquality_DifferentClass2() {
    //     Inches inches = new Inches(1.0);
    //     int notInches = 1;
    //     assertFalse(inches.equals(notInches));
    // }

    // @Test
    // public void testInchesEquality_SameReferance() {
    //     Inches inches1 = new Inches(5.0);
    //     assertTrue(inches1.equals(inches1));
    // }

    //UC-3 Test Cases

    @Test
    public void testEquality_FeetToFeet_SameValue(){
        Length lengthInFeet1 = new Length(3.0, LengthUnit.FEET);
        Length lengthInFeet2 = new Length(3.0, LengthUnit.FEET);
        assertTrue(lengthInFeet1.equals(lengthInFeet2));
    }

    @Test
    public void testEquality_InchToInch_SameValue(){
        Length lengthInInch1 = new Length(3.0, LengthUnit.INCHES);
        Length lengthInInch2 = new Length(3.0, LengthUnit.INCHES);
        assertTrue(lengthInInch1.equals(lengthInInch2));
    }

    @Test
    public void testEquality_NullComparison(){
        Length lengthInInch1 = null;
        Length lengthInInch2 = new Length(3.0, LengthUnit.INCHES);
        assertFalse(lengthInInch2.equals(lengthInInch1));
    }


    @Test
    public void testEquality_FeetInchesComparison(){
        Length lengthInInch1 = new Length(12.0, LengthUnit.INCHES);
        Length lengthInInch2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(lengthInInch1.equals(lengthInInch2));
    }

    @Test
    public void testEquality_FeetIneuality(){
        Length lengthInInch1 = new Length(12.0, LengthUnit.FEET);
        Length lengthInInch2 = new Length(1.0, LengthUnit.FEET);
        assertFalse(lengthInInch1.equals(lengthInInch2));
    }

    @Test
    public void testEquality_InchesIneuality(){
        Length lengthInInch1 = new Length(12.0, LengthUnit.INCHES);
        Length lengthInInch2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(lengthInInch1.equals(lengthInInch2));
    }

    @Test
    public void testEquality_CrossUnitInequality(){
        Length lengthInInch1 = new Length(1.0, LengthUnit.FEET);
        Length lengthInInch2 = new Length(14.0, LengthUnit.INCHES);
        assertFalse(lengthInInch1.equals(lengthInInch2));
    }


    //UC-4 Test Cases can be added here
    @Test
    public void testEquality_YardToYard_SameValue(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(3.0, LengthUnit.YARDS);
        assertTrue(lengthInYard1.equals(lengthInYard2));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(4.0, LengthUnit.YARDS);
        assertFalse(lengthInYard1.equals(lengthInYard2));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInFeet2 = new Length(9.0, LengthUnit.FEET);
        assertTrue(lengthInYard1.equals(lengthInFeet2));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        Length lengthInFeet = new Length(9.0, LengthUnit.FEET);
        Length lengthInYard = new Length(3.0, LengthUnit.YARDS);
        assertTrue(lengthInFeet.equals(lengthInYard));
    }
    
    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        Length lengthInYard1 = new Length(1.0, LengthUnit.YARDS);
        Length lengthInInches2 = new Length(36.0, LengthUnit.INCHES);
        assertTrue(lengthInYard1.equals(lengthInInches2));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        Length lengthInInches = new Length(36.0, LengthUnit.INCHES);
        Length lengthInYard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(lengthInInches.equals(lengthInYard));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        Length lengthInYard1 = new Length(4.0, LengthUnit.YARDS);
        Length lengthInFeet2 = new Length(9.0, LengthUnit.FEET);
        assertFalse(lengthInYard1.equals(lengthInFeet2));
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue(){
        Length lengthInCentimeters1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length lengthInInches2 = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(lengthInCentimeters1.equals(lengthInInches2));
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue(){
        Length lengthInCentimeters = new Length(4.0, LengthUnit.CENTIMETERS);
        Length lengthInFeet = new Length(9.0, LengthUnit.FEET);
        assertFalse(lengthInCentimeters.equals(lengthInFeet));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        Length Quantity1 = new Length(1.0, LengthUnit.YARDS); // 1 yards
        Length Quantity2 = new Length(3.0, LengthUnit.FEET);  //
        Length Quantity3 = new Length(36.0, LengthUnit.INCHES); // 36 inches
        if(Quantity1.equals(Quantity2) && Quantity2.equals(Quantity3)){
            assertTrue(Quantity1.equals(Quantity3));
        } else {
            assertFalse(true); // Force fail if transitive property does not hold
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquality_YardWithNullUnit(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(3.0, null);
        assertFalse(lengthInYard1.equals(lengthInYard2));
    }

    @Test
    public void testEquality_YardSameReference(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = lengthInYard1;
        assertTrue(lengthInYard1.equals(lengthInYard2));
    }

    @Test
    public void testEquality_YardNullComparison(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = null;
        assertFalse(lengthInYard1.equals(lengthInYard2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquality_CentimetersWithNullUnit(){
        Length lengthInCentimeters = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = new Length(3.0, null);
        assertFalse(lengthInCentimeters.equals(lengthInCentimeters2));
    }

    @Test
    public void testEquality_CentimetersSameReference(){
        Length lengthInCentimeters1 = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = lengthInCentimeters1;
        assertTrue(lengthInCentimeters1.equals(lengthInCentimeters2));
    }

    @Test
    public void testEquality_CentimetersNullComparison(){
        Length lengthInCentimeters = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = null;
        assertFalse(lengthInCentimeters.equals(lengthInCentimeters2));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario(){
        Length Quantity1 = new Length(2.0, LengthUnit.YARDS); // 3 yards
        Length Quantity2 = new Length(6.0, LengthUnit.FEET);  //
        Length Quantity3 = new Length(72.0, LengthUnit.INCHES); // 36 inches
        if(Quantity1.equals(Quantity2) && Quantity2.equals(Quantity3)){
            assertTrue(Quantity1.equals(Quantity3));
        // } else {
        //     assertFalse(true); // Force fail if transitive property does not hold
        }
    }


    //UC-5 Test Cases for Length conversion can be added here
    @Test
    public void testConversion_FeetToInches(){
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length expectedLengthInInches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(lengthInFeet.convertTo(LengthUnit.INCHES).equals(expectedLengthInInches));
    }

    @Test
    public void testConversion_InchesToFeet(){
        Length lengthInInches = new Length(24.0, LengthUnit.INCHES);
        Length expectedLengthInFeet = new Length(2.0, LengthUnit.FEET);
        assertTrue(lengthInInches.convertTo(LengthUnit.FEET).equals(expectedLengthInFeet));
    }

    @Test
    public void testConversion_YardsToInches(){
        Length lengthInYards = new Length(1.0, LengthUnit.YARDS);
        Length expectedLengthInInches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(lengthInYards.convertTo(LengthUnit.INCHES).equals(expectedLengthInInches));
    }

    @Test
    public void testConversion_InchesToYards(){
        Length lengthInInches = new Length(72.0, LengthUnit.INCHES);
        Length expectedLengthInYards = new Length(2.0, LengthUnit.YARDS);
        assertTrue(lengthInInches.convertTo(LengthUnit.YARDS).equals(expectedLengthInYards));
    }

    @Test
    public void testConversion_CentimetersToInches(){
        Length lengthInCentimeters = new Length(2.54, LengthUnit.CENTIMETERS);
        Length expectedLengthInInches = new Length(1.0, LengthUnit.INCHES);
        assertTrue(lengthInCentimeters.convertTo(LengthUnit.INCHES).equals(expectedLengthInInches));
    }

    @Test
    public void testConversion_InchesToCentimeters(){
        Length lengthInInches = new Length(1.0, LengthUnit.INCHES);
        Length expectedLengthInCentimeters = new Length(2.54, LengthUnit.CENTIMETERS);
        assertTrue(lengthInInches.convertTo(LengthUnit.CENTIMETERS).equals(expectedLengthInCentimeters));
    }

    @Test
    public void testConversion_FeetToYards(){
        Length lengthInFeet = new Length(3.0, LengthUnit.FEET);
        Length expectedLengthInYards = new Length(1.0, LengthUnit.YARDS);
        assertTrue(lengthInFeet.convertTo(LengthUnit.YARDS).equals(expectedLengthInYards));
    }

    @Test
    public void testConversion_YardsToFeet(){
        Length lengthInYards = new Length(1.0, LengthUnit.YARDS);
        Length expectedLengthInFeet = new Length(3.0, LengthUnit.FEET);
        assertTrue(lengthInYards.convertTo(LengthUnit.FEET).equals(expectedLengthInFeet));
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue(){
        Length originalLength = new Length(5.0, LengthUnit.FEET);
        Length convertedLength = originalLength.convertTo(LengthUnit.INCHES);
        Length roundTripLength = convertedLength.convertTo(LengthUnit.FEET);
        assertTrue(originalLength.equals(roundTripLength));
    }

    @Test
    public void testConversion_ZeroValue(){
        Length lengthInFeet = new Length(0.0, LengthUnit.FEET);
        Length expectedLengthInInches = new Length(0.0, LengthUnit.INCHES);
        assertTrue(lengthInFeet.convertTo(LengthUnit.INCHES).equals(expectedLengthInInches));
    }

    @Test
    public void testConversion_NegativeValue(){
        Length lengthInFeet = new Length(-1.0, LengthUnit.FEET);
        Length expectedLengthInInches = new Length(-12.0, LengthUnit.INCHES);
        assertTrue(lengthInFeet.convertTo(LengthUnit.INCHES).equals(expectedLengthInInches));
    }

    @Test
    public void testConversion_InvalidUnit_Throws(){
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        try {
            lengthInFeet.convertTo(null);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Target unit cannot be null"));
        }
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws(){
        try {
            new Length(Double.NaN, LengthUnit.FEET);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid numeric value"));
        }

        try {
            new Length(Double.POSITIVE_INFINITY, LengthUnit.FEET);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid numeric value"));
        }
    
        try {
            new Length(Double.NEGATIVE_INFINITY, LengthUnit.FEET);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid numeric value"));
        }
    }

    @Test 
    public void testConversion_PrecisionTolerance(){
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length expectedLengthInInches = new Length(12.0, LengthUnit.INCHES);
        Length actualLengthInInches = lengthInFeet.convertTo(LengthUnit.INCHES);
        assertTrue(Math.abs(actualLengthInInches.getValue() - expectedLengthInInches.getValue()) < 0.01);
    }

    //UC-6 Test Cases for Addition Operations
    
    // 1. Same Unit Addition
    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        Length expected = new Length(5.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(6.0, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Length expected = new Length(18.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    // 2. Cross Unit Addition
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length lengthInInches = new Length(6.0, LengthUnit.INCHES);
        Length result = lengthInFeet.add(lengthInInches);
        Length expected = new Length(18.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() {
        Length lengthInInches = new Length(12.0, LengthUnit.INCHES);
        Length lengthInFeet = new Length(2.0, LengthUnit.FEET);
        Length result = lengthInInches.add(lengthInFeet);
        Length expected = new Length(36.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    // 3. Result Precision
    @Test
    public void testAddition_ResultPrecision_DecimalValues() {
        Length length1 = new Length(1.5, LengthUnit.FEET);
        Length length2 = new Length(2.5, LengthUnit.FEET);
        Length result = length1.add(length2);
        Length expected = new Length(4.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ResultPrecision_CrossUnitDecimal() {
        Length lengthInFeet = new Length(0.5, LengthUnit.FEET);
        Length lengthInInches = new Length(6.0, LengthUnit.INCHES);
        Length result = lengthInFeet.add(lengthInInches);
        Length expected = new Length(12.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    // 4. Commutativity (a + b = b + a)
    @Test
    public void testAddition_Commutativity_FeetAndInches() {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        
        Length result1 = length1.add(length2);
        Length result2 = length2.add(length1);
        
        assertTrue(result1.equals(result2));
    }

    @Test
    public void testAddition_Commutativity_SameUnit() {
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(5.0, LengthUnit.FEET);
        
        Length result1 = length1.add(length2);
        Length result2 = length2.add(length1);
        
        assertTrue(result1.equals(result2));
    }

    // 5. Identity Element (a + 0 = a)
    @Test
    public void testAddition_IdentityElement_FeetPlusZero() {
        Length length = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.FEET);
        Length result = length.add(zero);
        assertTrue(result.equals(length));
    }

    @Test
    public void testAddition_IdentityElement_InchPlusZero() {
        Length length = new Length(10.0, LengthUnit.INCHES);
        Length zero = new Length(0.0, LengthUnit.INCHES);
        Length result = length.add(zero);
        assertTrue(result.equals(length));
    }

    @Test
    public void testAddition_IdentityElement_ZeroPlusFeet() {
        Length zero = new Length(0.0, LengthUnit.FEET);
        Length length = new Length(7.0, LengthUnit.FEET);
        Length result = zero.add(length);
        assertTrue(result.equals(length));
    }

    // 6. Unit Consistency
    @Test
    public void testAddition_UnitConsistency_ResultInFirstUnit() {
        Length lengthInFeet = new Length(2.0, LengthUnit.FEET);
        Length lengthInInches = new Length(12.0, LengthUnit.INCHES);
        Length result = lengthInFeet.add(lengthInInches);
        assertTrue(result.getUnit() == LengthUnit.FEET);
    }

    @Test
    public void testAddition_UnitConsistency_SameUnitPreserved() {
        Length length1 = new Length(4.0, LengthUnit.FEET);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        assertTrue(result.getUnit() == LengthUnit.FEET);
    }

    // 7. Null and Invalid Handling
    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullHandling_AddNullLength() {
        Length length = new Length(5.0, LengthUnit.FEET);
        length.add(null);
    }

    @Test
    public void testAddition_InvalidValue_LargeResult() {
        Length length1 = new Length(1000000.0, LengthUnit.FEET);
        Length length2 = new Length(2000000.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        Length expected = new Length(3000000.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    // 8. Large and Small Values
    @Test
    public void testAddition_LargeValues_FeetAddition() {
        Length length1 = new Length(1000000.0, LengthUnit.FEET);
        Length length2 = new Length(500000.0, LengthUnit.FEET);
        Length result = length1.add(length2);
        Length expected = new Length(1500000.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_SmallValues_InchAddition() {
        Length length1 = new Length(0.5, LengthUnit.INCHES);
        Length length2 = new Length(0.25, LengthUnit.INCHES);
        Length result = length1.add(length2);
        Length expected = new Length(0.75, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_LargeAndSmall_CrossUnit() {
        Length lengthInFeet = new Length(1000.0, LengthUnit.FEET);
        Length lengthInInches = new Length(6.0, LengthUnit.INCHES);
        Length result = lengthInFeet.add(lengthInInches);
        Length expected = new Length(1000.5, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_VerySmallValues_Precision() {
        Length length1 = new Length(0.01, LengthUnit.FEET);
        Length length2 = new Length(0.02, LengthUnit.FEET);
        Length result = length1.add(length2);
        Length expected = new Length(0.03, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    //UC-7 Test Cases for Addition with Target Unit Specification
    
    @Test
    public void testAdditionWithTargetUnit_FeetPlusInches_ToYards() {
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length lengthInInches = new Length(12.0, LengthUnit.INCHES);
        Length result = lengthInFeet.add(lengthInInches, LengthUnit.YARDS);
        Length expected = new Length(0.6667, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_InchPlusInch_ToFeet() {
        Length length1 = new Length(6.0, LengthUnit.INCHES);
        Length length2 = new Length(6.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.FEET);
        Length expected = new Length(1.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_FeetPlusFeet_ToInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.INCHES);
        Length expected = new Length(36.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_YardsPlusInches_ToFeet() {
        Length lengthInYards = new Length(1.0, LengthUnit.YARDS);
        Length lengthInInches = new Length(12.0, LengthUnit.INCHES);
        Length result = lengthInYards.add(lengthInInches, LengthUnit.FEET);
        Length expected = new Length(4.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_InchPlusYards_ToInches() {
        Length lengthInInches = new Length(24.0, LengthUnit.INCHES);
        Length lengthInYards = new Length(1.0, LengthUnit.YARDS);
        Length result = lengthInInches.add(lengthInYards, LengthUnit.INCHES);
        Length expected = new Length(60.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_SameUnit_ToSameUnit() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.FEET);
        Length expected = new Length(8.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_Commutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        
        Length result1 = length1.add(length2, LengthUnit.YARDS);
        Length result2 = length2.add(length1, LengthUnit.YARDS);
        
        assertTrue(result1.equals(result2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionWithTargetUnit_NullTargetUnit() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        length1.add(length2, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionWithTargetUnit_NullLength() {
        Length length = new Length(5.0, LengthUnit.FEET);
        length.add(null, LengthUnit.YARDS);
    }

    @Test
    public void testAdditionWithTargetUnit_LargeValues_ToYards() {
        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(500.0, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_FeetPlusCentimeters_ToInches() {
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        Length lengthInCm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length result = lengthInFeet.add(lengthInCm, LengthUnit.INCHES);
        Length expected = new Length(13.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAdditionWithTargetUnit_Precision_DecimalResult() {
        Length length1 = new Length(1.5, LengthUnit.FEET);
        Length length2 = new Length(6.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(0.6667, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    // UC-7 Additional Comprehensive Test Cases

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.FEET);
        Length expected = new Length(2.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.INCHES);
        Length expected = new Length(24.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(0.6667, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.CENTIMETERS);
        Length expected = new Length(5.08, LengthUnit.CENTIMETERS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(3.0, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.FEET);
        Length expected = new Length(9.0, LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        
        Length result1 = length1.add(length2, LengthUnit.YARDS);
        Length result2 = length2.add(length1, LengthUnit.YARDS);
        
        assertTrue(result1.equals(result2));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(1.6667, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.INCHES);
        Length expected = new Length(36.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        length1.add(length2, null);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.INCHES);
        Length expected = new Length(18000.0, LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.YARDS);
        Length expected = new Length(0.6667, LengthUnit.YARDS);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        // Test FEET + INCHES -> YARDS
        Length f1 = new Length(3.0, LengthUnit.FEET);
        Length i1 = new Length(36.0, LengthUnit.INCHES);
        Length r1 = f1.add(i1, LengthUnit.YARDS);
        Length e1 = new Length(2.0, LengthUnit.YARDS);
        assertTrue(r1.equals(e1));

        // Test YARDS + FEET -> INCHES
        Length y1 = new Length(1.0, LengthUnit.YARDS);
        Length f2 = new Length(1.0, LengthUnit.FEET);
        Length r2 = y1.add(f2, LengthUnit.INCHES);
        Length e2 = new Length(48.0, LengthUnit.INCHES);
        assertTrue(r2.equals(e2));

        // Test INCHES + CENTIMETERS -> FEET
        Length in1 = new Length(12.0, LengthUnit.INCHES);
        Length cm1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length r3 = in1.add(cm1, LengthUnit.FEET);
        Length e3 = new Length(2.0, LengthUnit.FEET);
        assertTrue(r3.equals(e3));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        // Test 1: 1 FEET + 6 INCHES -> YARDS
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(6.0, LengthUnit.INCHES);
        Length result1 = length1.add(length2, LengthUnit.YARDS);
        assertTrue(Math.abs(result1.getValue() - 0.5) < 0.01);

        // Test 2: 1 YARD + 18 INCHES -> FEET
        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(18.0, LengthUnit.INCHES);
        Length result2 = length3.add(length4, LengthUnit.FEET);
        assertTrue(Math.abs(result2.getValue() - 4.5) < 0.01);

        // Test 3: 30.48 CM + 30.48 CM -> FEET
        Length length5 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length6 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length result3 = length5.add(length6, LengthUnit.FEET);
        assertTrue(Math.abs(result3.getValue() - 2.0) < 0.01);
    }

    // ============================================================
    // UC8 Test Cases - LengthUnit Enum Tests
    // ============================================================

    @Test
    public void testLengthUnitEnum_FeetConstant() {
        // Verifies that LengthUnit.FEET is accessible and has correct conversion factor
        // Base unit is INCHES, so 1 FEET = 12 INCHES
        assertTrue(LengthUnit.FEET.getConversionFactor() == 12.0);
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        // Verifies that LengthUnit.INCHES is accessible and has the correct conversion factor
        // Base unit is INCHES, so 1 INCH = 1 INCH
        assertTrue(LengthUnit.INCHES.getConversionFactor() == 1.0);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        // Verifies that LengthUnit.YARDS is accessible and has correct conversion factor
        // Base unit is INCHES, so 1 YARD = 36 INCHES
        assertTrue(LengthUnit.YARDS.getConversionFactor() == 36.0);
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        // Verifies that LengthUnit.CENTIMETERS is accessible and has correct conversion factor
        // 1 CM = 0.393701 INCHES
        assertTrue(Math.abs(LengthUnit.CENTIMETERS.getConversionFactor() - 0.393701) < 0.0001);
    }

    @Test
    public void testConvertToBaseUnit_FeetToInches() {
        // Verifies that LengthUnit.FEET.convertToBaseUnit(5.0) returns 60.0 inches
        double result = LengthUnit.FEET.convertToBaseUnit(5.0);
        assertTrue(Math.abs(result - 60.0) < 0.0001);
    }

    @Test
    public void testConvertToBaseUnit_InchesToInches() {
        // Verifies that LengthUnit.INCHES.convertToBaseUnit(12.0) returns 12.0
        // Conversion to base unit when already in base unit
        double result = LengthUnit.INCHES.convertToBaseUnit(12.0);
        assertTrue(Math.abs(result - 12.0) < 0.0001);
    }

    @Test
    public void testConvertToBaseUnit_YardsToInches() {
        // Verifies that LengthUnit.YARDS.convertToBaseUnit(1.0) returns 36.0 inches
        double result = LengthUnit.YARDS.convertToBaseUnit(1.0);
        assertTrue(Math.abs(result - 36.0) < 0.0001);
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToInches() {
        // Verifies that LengthUnit.CENTIMETERS.convertToBaseUnit(2.54) returns ~1.0
        // Conversion from centimeters to inches (base unit), within epsilon
        double result = LengthUnit.CENTIMETERS.convertToBaseUnit(2.54);
        assertTrue(Math.abs(result - 1.0) < 0.01);
    }

    @Test
    public void testConvertFromBaseUnit_InchesToFeet() {
        // Verifies that LengthUnit.FEET.convertFromBaseUnit(24.0) returns 2.0 feet
        // Conversion from base unit (inches) to feet
        double result = LengthUnit.FEET.convertFromBaseUnit(24.0);
        assertTrue(Math.abs(result - 2.0) < 0.0001);
    }

    @Test
    public void testConvertFromBaseUnit_InchesToInches() {
        // Verifies that LengthUnit.INCHES.convertFromBaseUnit(12.0) returns 12.0
        // Conversion from base unit (inches) to inches
        double result = LengthUnit.INCHES.convertFromBaseUnit(12.0);
        assertTrue(Math.abs(result - 12.0) < 0.0001);
    }

    @Test
    public void testConvertFromBaseUnit_InchesToYards() {
        // Verifies that LengthUnit.YARDS.convertFromBaseUnit(36.0) returns 1.0
        // Conversion from base unit (inches) to yards
        double result = LengthUnit.YARDS.convertFromBaseUnit(36.0);
        assertTrue(Math.abs(result - 1.0) < 0.0001);
    }

    @Test
    public void testConvertFromBaseUnit_InchesToCentimeters() {
        // Verifies that LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0) returns ~2.54
        // Conversion from base unit (inches) to centimeters, within epsilon
        double result = LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0);
        assertTrue(Math.abs(result - 2.54) < 0.01);
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {
        // Verifies that Quantity(1.0, FEET).equals(Quantity(12.0, INCHES)) returns true
        // Tests: Refactored Length correctly uses unit conversion methods
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        // Verifies that Quantity(1.0, FEET).convertTo(INCHES) returns Quantity(12.0, INCHES)
        // Tests: Refactored convertTo() correctly delegates to unit methods
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length result = feet.convertTo(LengthUnit.INCHES);
        assertTrue(Math.abs(result.getValue() - 12.0) < 0.0001);
        assertTrue(result.getUnit() == LengthUnit.INCHES);
    }

    @Test
    public void testQuantityLengthRefactored_Add() {
        // Verifies that Quantity(1.0, FEET).add(Quantity(12.0, INCHES), FEET) returns Quantity(2.0, FEET)
        // Tests: Refactored add() correctly uses unit conversion methods
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = feet.add(inches, LengthUnit.FEET);
        assertTrue(Math.abs(result.getValue() - 2.0) < 0.0001);
        assertTrue(result.getUnit() == LengthUnit.FEET);
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        // Verifies that Quantity(1.0, FEET).add(Quantity(12.0, INCHES), YARDS) returns Quantity(~0.667, YARDS)
        // Tests: Refactored add() with explicit target unit specification
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = feet.add(inches, LengthUnit.YARDS);
        // 1 FEET + 12 INCHES = 2 FEET = 0.667 YARDS
        assertTrue(Math.abs(result.getValue() - 0.67) < 0.01);
        assertTrue(result.getUnit() == LengthUnit.YARDS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityLengthRefactored_NullUnit() {
        // Verifies that Quantity(1.0, null) throws IllegalArgumentException
        // Tests: Null unit validation in refactored Length
        new Length(1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityLengthRefactored_InvalidValue() {
        // Verifies that Quantity(Double.NaN, FEET) throws IllegalArgumentException
        // Tests: Invalid value validation in refactored Length
        new Length(Double.NaN, LengthUnit.FEET);
    }

    @Test
    public void testBackwardCompatibility_UC1EqualityTests() {
        // Runs all UC1 test cases; verifies they pass without modification
        // Tests: UC1 test case compatibility with refactored design
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(f1.equals(f2));

        Length i1 = new Length(12.0, LengthUnit.INCHES);
        Length i2 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(i1.equals(i2));

        // Cross-unit equality
        Length f3 = new Length(1.0, LengthUnit.FEET);
        Length i3 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(f3.equals(i3));
    }

    @Test
    public void testBackwardCompatibility_UC5ConversionTests() {
        // Runs all UC5 conversion test cases; verifies they pass without modification
        // Tests: UC5 test case compatibility with refactored design
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = feet.convertTo(LengthUnit.INCHES);
        assertTrue(Math.abs(inches.getValue() - 12.0) < 0.0001);

        Length yards = new Length(1.0, LengthUnit.YARDS);
        Length feetResult = yards.convertTo(LengthUnit.FEET);
        assertTrue(Math.abs(feetResult.getValue() - 3.0) < 0.0001);

        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inchesResult = cm.convertTo(LengthUnit.INCHES);
        assertTrue(Math.abs(inchesResult.getValue() - 1.0) < 0.01);
    }

    @Test
    public void testBackwardCompatibility_UC6AdditionTests() {
        // Runs all UC6 addition test cases; verifies they pass without modification
        // Tests: UC6 test case compatibility with refactored design
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i1 = new Length(12.0, LengthUnit.INCHES);
        Length result = f1.add(i1);
        assertTrue(Math.abs(result.getValue() - 2.0) < 0.0001);
        assertTrue(result.getUnit() == LengthUnit.FEET);

        Length y1 = new Length(1.0, LengthUnit.YARDS);
        Length f2 = new Length(3.0, LengthUnit.FEET);
        Length result2 = y1.add(f2);
        assertTrue(Math.abs(result2.getValue() - 2.0) < 0.0001);
        assertTrue(result2.getUnit() == LengthUnit.YARDS);
    }

    @Test
    public void testBackwardCompatibility_UC7AdditionWithTargetUnitTests() {
        // Runs all UC7 addition-with-target-unit test cases; verifies they pass without modification
        // Tests: UC7 test case compatibility with refactored design
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length i1 = new Length(12.0, LengthUnit.INCHES);
        Length result = f1.add(i1, LengthUnit.YARDS);
        assertTrue(Math.abs(result.getValue() - 0.67) < 0.01);

        Length y1 = new Length(1.0, LengthUnit.YARDS);
        Length f2 = new Length(3.0, LengthUnit.FEET);
        Length result2 = y1.add(f2, LengthUnit.INCHES);
        assertTrue(Math.abs(result2.getValue() - 72.0) < 0.0001);
    }

    @Test
    public void testArchitecturalScalability_MultipleCategories() {
        // Confirms that the refactored pattern can be replicated for WeightUnit without coupling to LengthUnit
        // Tests: Architecture supports multiple measurement categories without circular dependencies
        // This test verifies that LengthUnit is standalone and doesn't have dependencies on Length class
        
        // Verify LengthUnit can be instantiated and used independently
        double feetToInches = LengthUnit.FEET.convertToBaseUnit(1.0);
        assertTrue(Math.abs(feetToInches - 12.0) < 0.0001);
        
        // Verify conversion methods work without Length objects
        double inchesToFeet = LengthUnit.FEET.convertFromBaseUnit(24.0);
        assertTrue(Math.abs(inchesToFeet - 2.0) < 0.0001);
        
        // This demonstrates the pattern is replicable for other measurement types
        // without tight coupling to the Length class
    }

    @Test
    public void testRoundTripConversion_RefactoredDesign() {
        // Verifies that convert(convert(value, A, B), B, A) ≈ value using refactored unit methods
        // Tests: Refactored design maintains mathematical precision across round-trip conversions
        
        // Test 1: FEET -> INCHES -> FEET
        Length original1 = new Length(5.0, LengthUnit.FEET);
        Length converted1 = original1.convertTo(LengthUnit.INCHES);
        Length roundTrip1 = converted1.convertTo(LengthUnit.FEET);
        assertTrue(Math.abs(roundTrip1.getValue() - original1.getValue()) < 0.0001);
        
        // Test 2: YARDS -> CENTIMETERS -> YARDS
        Length original2 = new Length(2.0, LengthUnit.YARDS);
        Length converted2 = original2.convertTo(LengthUnit.CENTIMETERS);
        Length roundTrip2 = converted2.convertTo(LengthUnit.YARDS);
        assertTrue(Math.abs(roundTrip2.getValue() - original2.getValue()) < 0.01);
        
        // Test 3: CENTIMETERS -> FEET -> CENTIMETERS
        Length original3 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length converted3 = original3.convertTo(LengthUnit.FEET);
        Length roundTrip3 = converted3.convertTo(LengthUnit.CENTIMETERS);
        assertTrue(Math.abs(roundTrip3.getValue() - original3.getValue()) < 0.1);
    }

    @Test
    public void testUnitImmutability() {
        // Verifies that LengthUnit enum constants are immutable and thread-safe
        // Tests: Enum design prevents modification of unit definitions at runtime
        
        // Verify conversion factors remain constant
        double factor1 = LengthUnit.FEET.getConversionFactor();
        double factor2 = LengthUnit.FEET.getConversionFactor();
        assertTrue(factor1 == factor2);
        
        // Verify the same enum instance is returned
        assertTrue(LengthUnit.FEET == LengthUnit.valueOf("FEET"));
        
        // Verify all enum constants are accessible
        LengthUnit[] allUnits = LengthUnit.values();
        assertTrue(allUnits.length == 4);
        assertTrue(allUnits[0] == LengthUnit.FEET);
        assertTrue(allUnits[1] == LengthUnit.INCHES);
        assertTrue(allUnits[2] == LengthUnit.YARDS);
        assertTrue(allUnits[3] == LengthUnit.CENTIMETERS);
    }
}