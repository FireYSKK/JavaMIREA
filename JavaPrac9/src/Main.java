import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidINN {
        String name;
        String surname;
        String lastName;
        String INN;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        surname = scanner.nextLine();
        System.out.print("Введите отчество: ");
        lastName = scanner.nextLine();
        System.out.print("Введите ИНН: ");
        INN = scanner.nextLine();
        if (INN.matches("[0-9]{12}"))
            System.out.println("Всё верно");
        else
            throw new InvalidINN();
    }
}
