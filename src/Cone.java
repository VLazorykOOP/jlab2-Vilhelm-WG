public class Cone {
    private double radius;  // радіус основи
    private double height;  // висота

    // Конструктор
    public Cone(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Радіус і висота повинні бути > 0");
        }
        this.radius = radius;
        this.height = height;
    }

    // Геттери
    public double getRadius() { return radius; }
    public double getHeight() { return height; }

    // Твірна l = sqrt(r^2 + h^2)
    public double getSlantHeight() {
        return Math.sqrt(radius * radius + height * height);
    }

    // Площа бічної поверхні
    public double getLateralSurfaceArea() {
        return Math.PI * radius * getSlantHeight();
    }

    // Об’єм
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format("Cone: radius=%.2f, height=%.2f ", radius, height);
    }
}