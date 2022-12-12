class Calculator {

    public int calculate(int a, int b, String operand) {

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new NumberFormatException("����� ������� ������ ����� �� 1 �� 10 ������������");
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
                throw new IllegalStateException("������ �������������� �������� �� ��������������, ����� ������ ������ +,-,*,/, " + "� �� ����� " + operand);
        }
        return result;
    }
}
