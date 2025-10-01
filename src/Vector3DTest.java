import java.util.Scanner;

public class Vector3DTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Введення першого вектора
        System.out.println("Введіть координати першого вектора (x y z): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double z1 = sc.nextDouble();
        Vector3D a = new Vector3D(x1, y1, z1);

        // Введення другого вектора
        System.out.println("Введіть координати другого вектора (x y z): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double z2 = sc.nextDouble();
        Vector3D b = new Vector3D(x2, y2, z2);

        // Демонстрація операцій
        System.out.println("\n=== Результати обчислень ===");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a · b = " + a.dot(b));
        System.out.println("|a| = " + a.length());
        System.out.println("|b| = " + b.length());

        // Порівняння довжин
        int cmp = a.compareTo(b);
        if (cmp < 0) System.out.println("Вектор a коротший за b");
        else if (cmp > 0) System.out.println("Вектор a довший за b");
        else System.out.println("Вектори мають однакову довжину");

        sc.close();
    }
}