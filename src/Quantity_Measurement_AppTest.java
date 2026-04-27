import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Quantity_Measurement_AppTest {

    // ===== FEET TESTS =====

    @Test
    public void testFeet_SameValue() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);
        Quantity_Measurement_App.Feet f2 = new Quantity_Measurement_App.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeet_DifferentValue() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);
        Quantity_Measurement_App.Feet f2 = new Quantity_Measurement_App.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testFeet_NullComparison() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeet_SameReference() {
        Quantity_Measurement_App.Feet f1 = new Quantity_Measurement_App.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    // ===== INCHES TESTS =====

    @Test
    public void testInches_SameValue() {
        Quantity_Measurement_App.Inches i1 = new Quantity_Measurement_App.Inches(1.0);
        Quantity_Measurement_App.Inches i2 = new Quantity_Measurement_App.Inches(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void testInches_DifferentValue() {
        Quantity_Measurement_App.Inches i1 = new Quantity_Measurement_App.Inches(1.0);
        Quantity_Measurement_App.Inches i2 = new Quantity_Measurement_App.Inches(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    public void testInches_NullComparison() {
        Quantity_Measurement_App.Inches i1 = new Quantity_Measurement_App.Inches(1.0);

        assertFalse(i1.equals(null));
    }

    @Test
    public void testInches_SameReference() {
        Quantity_Measurement_App.Inches i1 = new Quantity_Measurement_App.Inches(1.0);

        assertTrue(i1.equals(i1));
    }
}