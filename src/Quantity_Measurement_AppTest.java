import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantity_Measurement_AppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.INCH);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(12.0, Quantity_Measurement_App.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(12.0, Quantity_Measurement_App.LengthUnit.INCH);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(2.0, Quantity_Measurement_App.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.INCH);

        Quantity_Measurement_App.QuantityLength q2 =
                new Quantity_Measurement_App.QuantityLength(2.0, Quantity_Measurement_App.LengthUnit.INCH);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_NullComparison() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        Quantity_Measurement_App.QuantityLength q1 =
                new Quantity_Measurement_App.QuantityLength(1.0, Quantity_Measurement_App.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Quantity_Measurement_App.QuantityLength(1.0, null);
        });
    }
}