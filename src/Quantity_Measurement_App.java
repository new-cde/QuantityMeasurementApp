public class Quantity_Measurement_App {

    // ===== FEET CLASS =====
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // ===== INCHES CLASS =====
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        System.out.println("Feet equal: " + f1.equals(f2));
        System.out.println("Inches equal: " + i1.equals(i2));
    }
}