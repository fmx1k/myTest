class Calculator {

    public int calculate(int a, int b, String operand) {

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new NumberFormatException("Можно вводить только числа от 1 до 10 включительно");
        }

        int result;

        switch (operand) {
            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            case "*":
                result = a * b;
                break;

            case "/":
                result = a / b;
                break;

            default:
                throw new IllegalStateException("Данная арифметическая операция не поддерживается, можно ввести только +,-,*,/, " + "а вы ввели " + operand);
        }
        return result;
    }
}
