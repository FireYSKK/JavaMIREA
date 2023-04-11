import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            FileWriter writer = new FileWriter("./25.txt", false);
            String temp;
            Scanner scanner = new Scanner(System.in);
            do {
                temp =  scanner.nextLine();
                writer.write(temp);
                writer.write("\n");
                writer.flush();
            } while (!Objects.equals(temp, ""));
        }
        catch (Exception e){
            return;
        }
    }
}

