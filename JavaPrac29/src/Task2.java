import java.util.Scanner;

public class Task2 {
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String regex = "abcdefghijklmnopqrstuv18340";
        System.out.print("Enter the string: ");
        String string = scanner.nextLine();
        if (string.matches(regex)) System.out.println("Matches");
        else System.out.println("Does not match");
    }
}
