import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\nTask 1");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.test();


        System.out.println("\nTask 2");
        Alphabet alphabet = new Alphabet();
        alphabet.test(); // text.txt
    }
}