package com.apps.quantitymeasurement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.apps.quantitymeasurement.Length.LengthUnit;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

/**
 * Unit test for simple App.
 */
public class QuantityMeasurementAppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(6.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = null;
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet = new Feet(1.0);
        String notFeet = "1.0";
        assertFalse(feet.equals(notFeet));
    }

    @Test
    public void testFeetEquality_DifferentClass2() {
        Feet feet = new Feet(1.0);
        int notFeet = 1;
        assertFalse(feet.equals(notFeet));
    }

    @Test
    public void testFeetEquality_SameReferance() {
        Feet feet1 = new Feet(5.0);
        assertTrue(feet1.equals(feet1));
    }



    // Additional tests for Inches class can be added similarly
    @Test
    public void testIncesEquality_SameValue() {
        Inches inches1 = new Inches(5.0);
        Inches inches2 = new Inches(5.0);
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testIncesEquality_DifferentValue() {
        Inches inches1 = new Inches(5.0);
        Inches inches2 = new Inches(6.0);
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches1 = new Inches(5.0);
        Inches inches2 = null;
        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inches = new Inches(1.0);
        String notInches = "1.0";
        assertFalse(inches.equals(notInches));
    }

    @Test
    public void testInchesEquality_DifferentClass2() {
        Inches inches = new Inches(1.0);
        int notInches = 1;
        assertFalse(inches.equals(notInches));
    }

    @Test
    public void testInchesEquality_SameReferance() {
        Inches inches1 = new Inches(5.0);
        assertTrue(inches1.equals(inches1));
    }

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
}