import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantity_Measurement_AppTest {

    private static final double EPS = 0.001;

    @Test
    void testConvertToBaseUnit() {
        double result = Quantity_Measurement_App.LengthUnit.INCHES.convertToBaseUnit(12);
        assertEquals(1.0, result, EPS);
    }

    @Test
    void testConvertFromBaseUnit() {
        double result = Quantity_Measurement_App.LengthUnit.INCHES.convertFromBaseUnit(1);
        assertEquals(12.0, result, EPS);
    }

    @Test
    void testConversionFeetToInches() {
        var q = new Quantity_Measurement_App.QuantityLength(1, Quantity_Measurement_App.LengthUnit.FEET);
        var result = q.convertTo(Quantity_Measurement_App.LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPS);
    }

    @Test
    void testEquality() {
        var a = new Quantity_Measurement_App.QuantityLength(1, Quantity_Measurement_App.LengthUnit.FEET);
        var b = new Quantity_Measurement_App.QuantityLength(12, Quantity_Measurement_App.LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    void testAddition_Feet() {
        var a = new Quantity_Measurement_App.QuantityLength(1, Quantity_Measurement_App.LengthUnit.FEET);
        var b = new Quantity_Measurement_App.QuantityLength(12, Quantity_Measurement_App.LengthUnit.INCHES);

        var result = a.add(b, Quantity_Measurement_App.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_Inches() {
        var a = new Quantity_Measurement_App.QuantityLength(1, Quantity_Measurement_App.LengthUnit.FEET);
        var b = new Quantity_Measurement_App.QuantityLength(12, Quantity_Measurement_App.LengthUnit.INCHES);

        var result = a.add(b, Quantity_Measurement_App.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_Yards() {
        var a = new Quantity_Measurement_App.QuantityLength(1, Quantity_Measurement_App.LengthUnit.FEET);
        var b = new Quantity_Measurement_App.QuantityLength(12, Quantity_Measurement_App.LengthUnit.INCHES);

        var result = a.add(b, Quantity_Measurement_App.LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), EPS);
    }

    @Test
    void testNegativeValues() {
        var a = new Quantity_Measurement_App.QuantityLength(5, Quantity_Measurement_App.LengthUnit.FEET);
        var b = new Quantity_Measurement_App.QuantityLength(-2, Quantity_Measurement_App.LengthUnit.FEET);

        var result = a.add(b, Quantity_Measurement_App.LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPS);
    }

    @Test
    void testNullUnitException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity_Measurement_App.QuantityLength(1, null)
        );
    }
}