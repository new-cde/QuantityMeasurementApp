enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toInches(double value) {
        return value * factor;
    }

    public double fromInches(double inches) {
        return inches / factor;
    }
}

class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toInches() {
        return unit.toInches(value);
    }

    // ✅ UC6 (same as before)
    public QuantityLength add(QuantityLength other) {
        return add(other, this.unit);
    }

    // ✅ UC7 (NEW METHOD)
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double totalInches = this.toInches() + other.toInches();
        double result = targetUnit.fromInches(totalInches);

        return new QuantityLength(result, targetUnit);
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;
        return Math.abs(this.toInches() - other.toInches()) < 0.0001;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}

public class Quantity_Measurement_App {
    public static void main(String[] args) {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.add(q2, LengthUnit.FEET));     // 2 FEET
        System.out.println(q1.add(q2, LengthUnit.INCHES));   // 24 INCHES
        System.out.println(q1.add(q2, LengthUnit.YARDS));    // ~0.667 YARDS
    }
}