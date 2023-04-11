import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {

        boolean flag = true;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer ");
        String intString = scanner.next();

        // Проверка входных данных
        try {
            i = Integer.parseInt(intString);
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input!");
            flag = false;
        }

        // Проверка деления на 0
        try {
            if (flag) System.out.println(2 / i);
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero!");
        }
        finally {
            System.out.println("As usual");
        }
    }
}