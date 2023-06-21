import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String calc (String args) throws ScannerException {


        String regex = "(\\d+)\s?+([+-/*])\s?+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(args);

        if (!matcher.matches()) {
            throw new ScannerException("Пользователь ввел что-то кроме заданных данных");
        }

        String sing = matcher.group(2);
        int leftOperator = Integer.parseInt(matcher.group(1));
        int rightOperator = Integer.parseInt(matcher.group(3));

        if ((leftOperator >10) || (rightOperator >10)){
            throw new ScannerException("Одно из чисел больше 10");
        }

        return switch (sing) {
            case "+" -> String.valueOf(leftOperator + rightOperator);
            case "-" -> String.valueOf(leftOperator - rightOperator);
            case "*" -> String.valueOf(leftOperator * rightOperator);
            case "/" -> String.valueOf(leftOperator / rightOperator);
            default -> "Введена не существующая операция";
        };
    }
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String x = scanner.nextLine();

            if (Objects.equals(x, "")) {
                throw new ScannerException("Пустой ввод");
            }

            System.out.println(calc(x));
        }
    }

}


