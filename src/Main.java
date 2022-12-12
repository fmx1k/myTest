import java.util.Scanner;

public class Main {

    public static Calculator calculator = new Calculator();
    public static ConverterRome cr = new ConverterRome();

    public static String calc(String input) {
        String[] parts = input.split(" ");
        int a;
        int b;
        String result = null;

        if (parts.length != 3) {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (cr.isRoman(parts[0]) && cr.isRoman(parts[2])) {
            a = cr.convertFromRome(parts[0]);
            b = cr.convertFromRome(parts[2]);
            result = cr.convertToRome(calculator.calculate(a, b, parts[1]));
        }

        if (cr.isNumeric(parts[0]) && cr.isNumeric(parts[2])) {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
            result = Integer.toString(calculator.calculate(a, b, parts[1]));
        }

        if (result == null) {
            throw new NumberFormatException("Неверный ввод чисел");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        String result;

        while (true) {
            System.out.println("Введите операцию: или end чтобы завершить работу");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) break;

            result = calc(input);
            System.out.println(result);
        }
    }
}
