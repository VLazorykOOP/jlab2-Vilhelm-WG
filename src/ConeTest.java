import java.util.Scanner;

public class ConeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Введення даних
        System.out.print("Введіть радіус основи конуса: ");
        double r = sc.nextDouble();

        System.out.print("Введіть висоту конуса: ");
        double h = sc.nextDouble();

        // Створення конуса
        Cone cone = new Cone(r, h);


        // Вивід результатів
        System.out.println("\n" + cone);
        System.out.printf("Твірна = %.2f\n", cone.tvirna());
        System.out.printf("Площа бічної поверхні = %.2f\n", cone.ploshchea());
        System.out.printf("Об’єм = %.2f\n", cone.obiem());

        sc.close();
    }
}