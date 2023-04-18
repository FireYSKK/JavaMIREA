import java.util.*;
import java.util.regex.Pattern;

public class Task1 {
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String toParse = "One, two. Three; four: five! six_";
        System.out.println("Before: " + toParse);
        System.out.print("regex splitter: ");
        String regex = scanner.nextLine();

        System.out.println("After: ");
        Pattern p3 = Pattern.compile(regex);
        String[] words = p3.split(toParse);
        for (String word : words){
            if (!Objects.equals(word, "")) System.out.println(word);
        }
    }
}