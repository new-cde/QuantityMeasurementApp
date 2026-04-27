import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantity_Measurement_AppTest {

    @Test
    public void testEquality_SameValue() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);
        Quantity_Measurement_App.Feet f2 = new Quantity_Measurement_App.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testEquality_DifferentValue() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);
        Quantity_Measurement_App.Feet f2 = new Quantity_Measurement_App.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testEquality_NullComparison() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    public void testEquality_NonNumericInput() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);

        assertFalse(f1.equals("test"));
    }

    @Test
    public void testEquality_SameReference() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);

        assertTrue(f1.equals(f1));
    }
}