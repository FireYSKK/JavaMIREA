import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public void test() {
        String string = "25.98 EU, 44 ERR, 0.004 EU, 12345.00 RUB, 600 USD, 34 KEK, huh? @#$%^!";
        String regex = "[1-9][0-9]*\\.[0-9]{2}\\s(RUB|EU|USD)";
        System.out.println(string);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println("Price: " + matcher.group());
        }
    }
}