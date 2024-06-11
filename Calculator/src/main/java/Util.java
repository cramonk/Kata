class Util {
    static boolean isRoman = false;

    public static String extractOperator(String input) throws Exception {
        StringBuffer operators = new StringBuffer();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
                operators.append(c);
            }
        }
        validateOperators(operators);
        return operators.toString();
    }

    public static int[] extractNumbers(String input) throws Exception {
        String[] temp = input.split("[+\\-*/]");
        String firstNumber = temp[0];
        String secondNumber = temp[1];
        return validateNumbers(firstNumber, secondNumber);
    }

    private static void validateOperators(StringBuffer operators) throws Exception {
        if (operators.isEmpty()) {
            throw new Exception("Не является математической операцией");
        }

        if (operators.length() > 1) {
            throw new Exception("Может использоваться только 1 оператор");
        }
    }

    private static int[] validateNumbers(String number1, String number2) throws Exception {
        int[] numbers = new int[2];
        try {
            numbers[0] = Integer.parseInt(number1);
            numbers[1] = Integer.parseInt(number2);
        } catch (NumberFormatException exception) {
            numbers[0] = checkRomanNumber(number1);
            numbers[1] = checkRomanNumber(number2);
            isRoman = true;
        }
        validateNumber(numbers[0]);
        validateNumber(numbers[1]);

        return numbers;
    }

    private static int checkRomanNumber(String number) throws Exception {
        int n;
        switch (number) {
            case "I" -> n = RomanNumber.I.getValue();
            case "II" -> n = RomanNumber.II.getValue();
            case "III" -> n = RomanNumber.III.getValue();
            case "IV" -> n = RomanNumber.IV.getValue();
            case "V" -> n = RomanNumber.V.getValue();
            case "VI" -> n = RomanNumber.VI.getValue();
            case "VII" -> n = RomanNumber.VII.getValue();
            case "VIII" -> n = RomanNumber.VIII.getValue();
            case "IX" -> n = RomanNumber.IX.getValue();
            case "X" -> n = RomanNumber.X.getValue();
            default -> {
                try {
                    Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throw new Exception(number + " не является римской цифрой");
                }
                throw new Exception("Одновременно может использоваться только одна система исчисления");
            }
        }
        return n;
    }

    private static void validateNumber(int n) throws Exception {
        if (n < 1 || n > 10) {
            throw new Exception("Могут использоваться только числа от 1 до 10");
        }
    }
}
