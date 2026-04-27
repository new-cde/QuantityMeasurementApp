public class Quantity_Measurement_App {

    // ---------- LengthUnit (Standalone Enum as per UC8) ----------
    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double conversionFactor; // to feet

        LengthUnit(double factor) {
            this.conversionFactor = factor;
        }

        public double convertToBaseUnit(double value) {
            return value * conversionFactor; // convert to feet
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue / conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ---------- QuantityLength Class ----------
    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit null");

            double base = unit.convertToBaseUnit(value);
            double result = targetUnit.convertFromBaseUnit(base);

            return new QuantityLength(result, targetUnit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null)
                throw new IllegalArgumentException("Invalid input");

            double base1 = this.unit.convertToBaseUnit(this.value);
            double base2 = other.unit.convertToBaseUnit(other.value);

            double sum = base1 + base2;

            double result = targetUnit.convertFromBaseUnit(sum);

            return new QuantityLength(result, targetUnit);
        }

        public boolean equals(QuantityLength other) {
            if (other == null) return false;

            double base1 = this.unit.convertToBaseUnit(this.value);
            double base2 = other.unit.convertToBaseUnit(other.value);

            return Math.abs(base1 - base2) < 0.0001;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }
    }
}