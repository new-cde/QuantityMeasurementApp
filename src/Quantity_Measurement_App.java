public class Quantity_Measurement_App {

    // ===== ENUM WITH CONVERSION FACTORS (BASE = FEET) =====
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    // ===== CONVERSION METHOD =====
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // Convert to base (feet)
        double inFeet = source.toFeet(value);

        // Convert to target
        return target.fromFeet(inFeet);
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        System.out.println("1 ft -> inches = " +
                convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));

        System.out.println("3 yards -> feet = " +
                convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));

        System.out.println("36 inches -> yards = " +
                convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS));

        System.out.println("2.54 cm -> inches = " +
                convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES));
    }
}