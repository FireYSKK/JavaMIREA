import java.util.Scanner;

public class Email {
    public void test(){
        String regex = "[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*" +
                "@" +
                "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|localhost)";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.matches(regex)){
            System.out.println("Nice E-mail, Bro!");
        }
        else{
            System.out.println("E-mail is wrong");
        }
    }
}
