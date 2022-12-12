class ConverterRome {

    public static final String[] rome = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] integer = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int convertFromRome(String romanNumber) {

        int result = 0;

        for (int i = 0; i < rome.length; i++) {
            while (romanNumber.startsWith(rome[i])) {
                result += integer[i];
                romanNumber = romanNumber.substring(rome[i].length());
            }
        }
        return result;
    }


    public String convertToRome(int number) {
        if (number > 100 || number < 1) {
            throw new NumberFormatException("Данное число не предусмотрено для перевода в римские числа");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rome.length; i++) {
            while (number >= integer[i]) {
                int temp = number / integer[i];
                number = number % integer[i];

                for (int j = 0; j < temp; j++) {
                    sb.append(rome[i]);
                }
            }
        }
        return sb.toString();
    }

    public boolean isRoman(String input) {
        if (!isNumeric(input)) {
            int testInt = convertFromRome(input);

            if (testInt == 0) {
                throw new NumberFormatException("Неверный ввод данных");
            }

            String test2 = convertToRome(testInt);

            return input.equals(test2);
        }
        return false;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
