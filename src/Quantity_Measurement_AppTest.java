import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_Measurement_AppTest {

    @Test
    void testFeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertEquals(3.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testFeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertEquals(2.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testInchesPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(24.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testYardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(2.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testCentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);

        assertEquals(5.08, q1.add(q2).getValue(), 0.01);
    }

    @Test
    void testCommutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(q1.add(q2).equals(q2.add(q1)));
    }

    @Test
    void testZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        assertEquals(5.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testNegative() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        assertEquals(3.0, q1.add(q2).getValue(), 0.0001);
    }

    @Test
    void testNull() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}