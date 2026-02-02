package com.apps.quantitymeasurement;
 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
 
import org.junit.Test;
 
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;;
 
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
    public void testFeetEquality_SameReferance() {
        Feet feet1 = new Feet(5.0);
        assertTrue(feet1.equals(feet1));
    }
}
 
 