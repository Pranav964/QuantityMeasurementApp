package com.apps.quantitymeasurement;
 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
 
import org.junit.Test;
 
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;
import com.apps.quantitymeasurement.Length.LengthUnit;
 
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
 
 
 
 
   
 
 
 
}
 
 