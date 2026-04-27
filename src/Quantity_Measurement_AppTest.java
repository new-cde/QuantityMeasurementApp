import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_Measurement_AppTest {

    @Test
    void testFeetTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(2.0, q1.add(q2, LengthUnit.FEET).getValue(), 0.0001);
    }

    @Test
    void testInchesTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(24.0, q1.add(q2, LengthUnit.INCHES).getValue(), 0.0001);
    }

    @Test
    void testYardsTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(0.6667, q1.add(q2, LengthUnit.YARDS).getValue(), 0.01);
    }

    @Test
    void testCentimeterTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);

        assertEquals(5.08, q1.add(q2, LengthUnit.CENTIMETERS).getValue(), 0.01);
    }

    @Test
    void testCommutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(
                q1.add(q2, LengthUnit.YARDS).getValue(),
                q2.add(q1, LengthUnit.YARDS).getValue(),
                0.0001
        );
    }

    @Test
    void testZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(1.6667, q1.add(q2, LengthUnit.YARDS).getValue(), 0.01);
    }

    @Test
    void testNegative() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        assertEquals(36.0, q1.add(q2, LengthUnit.INCHES).getValue(), 0.0001);
    }

    @Test
    void testNullTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }

    @Test
    void testLargeValues() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);

        assertEquals(18000.0, q1.add(q2, LengthUnit.INCHES).getValue(), 0.0001);
    }
}