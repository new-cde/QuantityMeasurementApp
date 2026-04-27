import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantity_Measurement_AppTest {

    private static final double EPS = 1e-6;

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0,
                Quantity_Measurement_App.convert(1.0,
                        Quantity_Measurement_App.LengthUnit.FEET,
                        Quantity_Measurement_App.LengthUnit.INCHES),
                EPS);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0,
                Quantity_Measurement_App.convert(24.0,
                        Quantity_Measurement_App.LengthUnit.INCHES,
                        Quantity_Measurement_App.LengthUnit.FEET),
                EPS);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0,
                Quantity_Measurement_App.convert(1.0,
                        Quantity_Measurement_App.LengthUnit.YARDS,
                        Quantity_Measurement_App.LengthUnit.INCHES),
                EPS);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                Quantity_Measurement_App.convert(2.54,
                        Quantity_Measurement_App.LengthUnit.CENTIMETERS,
                        Quantity_Measurement_App.LengthUnit.INCHES),
                EPS);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(0.0,
                Quantity_Measurement_App.convert(0.0,
                        Quantity_Measurement_App.LengthUnit.FEET,
                        Quantity_Measurement_App.LengthUnit.INCHES),
                EPS);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(-12.0,
                Quantity_Measurement_App.convert(-1.0,
                        Quantity_Measurement_App.LengthUnit.FEET,
                        Quantity_Measurement_App.LengthUnit.INCHES),
                EPS);
    }

    @Test
    public void testConversion_SameUnit() {
        assertEquals(5.0,
                Quantity_Measurement_App.convert(5.0,
                        Quantity_Measurement_App.LengthUnit.FEET,
                        Quantity_Measurement_App.LengthUnit.FEET),
                EPS);
    }

    @Test
    public void testConversion_RoundTrip() {
        double value = 5.0;

        double converted = Quantity_Measurement_App.convert(
                value,
                Quantity_Measurement_App.LengthUnit.FEET,
                Quantity_Measurement_App.LengthUnit.INCHES);

        double back = Quantity_Measurement_App.convert(
                converted,
                Quantity_Measurement_App.LengthUnit.INCHES,
                Quantity_Measurement_App.LengthUnit.FEET);

        assertEquals(value, back, EPS);
    }

    @Test
    public void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            Quantity_Measurement_App.convert(1.0, null,
                    Quantity_Measurement_App.LengthUnit.FEET);
        });
    }

    @Test
    public void testConversion_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Quantity_Measurement_App.convert(Double.NaN,
                    Quantity_Measurement_App.LengthUnit.FEET,
                    Quantity_Measurement_App.LengthUnit.INCHES);
        });
    }
}