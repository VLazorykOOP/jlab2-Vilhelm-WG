import java.util.Scanner;

public class ExpressionEvaluator {

    private String expr;
    private int pos;

    public ExpressionEvaluator(String expr) {
        this.expr = expr.replaceAll("\\s+", ""); // прибираємо пробіли
        this.pos = 0;
    }

    // Головний метод
    public int parse() {
        int value = parseExpression();
        if (pos < expr.length()) {
            throw new RuntimeException("Неправильний вираз біля: " + expr.substring(pos));
        }
        return value;;
    }

    // Рівень 1: вираз = терм { (+|-) терм }
    private int parseExpression() {
        int value = parseTerm();
        while (pos < expr.length()) {
            char op = expr.charAt(pos);
            if (op == '+') {
                pos++;
                value += parseTerm();
            } else if (op == '-') {
                pos++;
                value -= parseTerm();
            } else {
                break;
            }
        }
        return value;
    }

    // Рівень 2: терм = фактор { * фактор }
    private int parseTerm() {
        int value = parseFactor();
        while (pos < expr.length()) {
            char op = expr.charAt(pos);
            if (op == '*') {
                pos++;
                value *= parseFactor();
            } else {
                break;
            }
        }
        return value;
    }

    // Рівень 3: фактор = число
    private int parseFactor() {
        if (pos >= expr.length() || !Character.isDigit(expr.charAt(pos))) {
            throw new RuntimeException("Очікувалося число біля: " + expr.substring(pos));
        }
        int start = pos;
        while (pos < expr.length() && Character.isDigit(expr.charAt(pos))) {
            pos++;
        }
        return Integer.parseInt(expr.substring(start, pos));
    }

    // ================== main для перевірки ==================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть вираз: ");
        String input = sc.nextLine();

        ExpressionEvaluator evaluator = new ExpressionEvaluator(input);
        int result = evaluator.parse();

        System.out.println("Результат = " + result);
        sc.close();
    }
}