/**
 * Простий та безпечний (immutable) клас для 3D-векторів.
 * Підтримує: додавання, віднімання, скалярний добуток, множення на скаляр,
 * обчислення довжини, порівняння векторів (точне) та порівняння довжин.
 */
public final class Vector3D implements Comparable<Vector3D> {
    private final double x;
    private final double y;
    private final double z;

    // Конструктор
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Геттери
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // Додавання векторів: this + other
    public Vector3D add(Vector3D other) {
        if (other == null) throw new NullPointerException("other is null");
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Віднімання векторів: this - other
    public Vector3D subtract(Vector3D other) {
        if (other == null) throw new NullPointerException("other is null");
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Множення на скаляр
    public Vector3D multiply(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Скалярний добуток (dot product): this · other
    public double dot(Vector3D other) {
        if (other == null) throw new NullPointerException("other is null");
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Квадрат довжини (щоб уникнути зайвого sqrt при порівнянні)
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    // Довжина вектора (модуль): sqrt(x^2 + y^2 + z^2)
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    // Порівняння довжин: реалізація Comparable (за зростанням довжини)
    // Використовує lengthSquared() для кращої продуктивності (без sqrt)
    @Override
    public int compareTo(Vector3D other) {
        if (other == null) throw new NullPointerException("other is null");
        return Double.compare(this.lengthSquared(), other.lengthSquared());
    }

    // Точне порівняння векторів (компонента до компоненти)
    // Перекриваємо equals та hashCode (використовуємо Double.compare для точного порівняння)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector3D)) return false;
        Vector3D other = (Vector3D) obj;
        return Double.compare(this.x, other.x) == 0
                && Double.compare(this.y, other.y) == 0
                && Double.compare(this.z, other.z) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        return result;
    }

    // Наближене порівняння з епсилоном — корисно для double
    public boolean approxEquals(Vector3D other, double eps) {
        if (other == null) return false;
        return Math.abs(this.x - other.x) <= eps
                && Math.abs(this.y - other.y) <= eps
                && Math.abs(this.z - other.z) <= eps;
    }

    @Override
    public String toString() {
        return String.format("Vector3D{x=%.6f, y=%.6f, z=%.6f}", x, y, z);
    }

    // Додаткові корисні методи (опційно)
    // Відстань між векторами (якщо розглядати їх як точки)
    public double distanceTo(Vector3D other) {
        return this.subtract(other).length();
    }

    // Статичні фабрики
    public static Vector3D zero() { return new Vector3D(0.0, 0.0, 0.0); }
    public static Vector3D unitX() { return new Vector3D(1.0, 0.0, 0.0); }
    public static Vector3D unitY() { return new Vector3D(0.0, 1.0, 0.0); }
    public static Vector3D unitZ() { return new Vector3D(0.0, 0.0, 1.0); }
}
