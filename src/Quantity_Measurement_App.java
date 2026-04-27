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

    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Null value");
        }

        // convert both to inches
        double totalInches = this.toInches() + other.toInches();

        // convert back to THIS unit
        double resultValue = unit.fromInches(totalInches);

        return new QuantityLength(resultValue, this.unit);
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

        QuantityLength result = q1.add(q2);

        System.out.println(result); // Quantity(2.0, FEET)
    }
}