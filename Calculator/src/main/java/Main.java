import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числовую операцию: ");

        String input = scanner.nextLine();
        String result = calc(input);

        System.out.println("Результат вычислений " + result);
    }

    public static String calc(String input) throws Exception {
        int result;
        String operator = Util.extractOperator(input);
        int[] numbers = Util.extractNumbers(input);
        int x = numbers[0];
        int y = numbers[1];

        switch (operator) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
            case "*" -> result = x * y;
            case "/" -> result = x / y;
            default -> throw new Exception();
        }
        return (Util.isRoman) ? (Transform.transformToRoman(result)) : (String.valueOf(result));
    }
}
