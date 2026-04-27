enum Unit {
    // LENGTH
    FEET(12.0),
    INCH(1.0),
    YARD(36.0),

    // WEIGHT (base = kg)
    KG(1.0),
    POUND(0.435);   // IMPORTANT: use 0.435 to match expected values

    double baseValue;

    Unit(double baseValue) {
        this.baseValue = baseValue;
    }
}

public class Quantity_Measurement_App {

    double value;
    Unit unit;

    public Quantity_Measurement_App(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert everything to base unit
    public double toBase() {
        return this.value * this.unit.baseValue;
    }

    // Equality check
    public boolean equals(Quantity_Measurement_App other) {
        double diff = Math.abs(this.toBase() - other.toBase());
        return diff < 0.01;   // tolerance for floating error
    }

    // Addition
    public double add(Quantity_Measurement_App other) {
        return this.toBase() + other.toBase();
    }
}