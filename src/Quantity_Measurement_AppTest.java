import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_Measurement_AppTest {

    // ✅ LENGTH TESTS

    @Test
    void testLengthEquality() {
        Quantity_Measurement_App q1 =
                new Quantity_Measurement_App(1, Unit.FEET);
        Quantity_Measurement_App q2 =
                new Quantity_Measurement_App(12, Unit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testLengthAddition() {
        Quantity_Measurement_App q1 =
                new Quantity_Measurement_App(1, Unit.FEET);
        Quantity_Measurement_App q2 =
                new Quantity_Measurement_App(2, Unit.INCH);

        assertEquals(14, q1.add(q2), 0.01);
    }

    // ✅ WEIGHT TESTS

    @Test
    void testWeightEquality_KgToPound() {
        Quantity_Measurement_App q1 =
                new Quantity_Measurement_App(1, Unit.KG);
        Quantity_Measurement_App q2 =
                new Quantity_Measurement_App(2.29, Unit.POUND);

        assertTrue(q1.equals(q2));   // THIS was failing earlier
    }

    @Test
    void testWeightAdditionDifferentUnit() {
        Quantity_Measurement_App q1 =
                new Quantity_Measurement_App(2, Unit.KG);
        Quantity_Measurement_App q2 =
                new Quantity_Measurement_App(3, Unit.POUND);

        assertEquals(3.306, q1.add(q2), 0.01);
    }
}