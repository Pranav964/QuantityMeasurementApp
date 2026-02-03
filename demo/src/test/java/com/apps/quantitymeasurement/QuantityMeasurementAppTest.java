package com.apps.quantitymeasurement;
 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
 
import org.junit.Test;
 
import com.apps.quantitymeasurement.QuantityMeasurementapp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementapp.Inches;
 
/**
 * Unit test for Quantity Measurement
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
 
}