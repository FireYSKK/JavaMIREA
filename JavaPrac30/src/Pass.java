import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pass {
    public void test() {
        String cond1 = "[a-zA-Z0-9_]{8,}";
        String cond2 = "[a-z]";
        Pattern pat2 = Pattern.compile(cond2);
        String cond3 = "[A-Z]";
        Pattern pat3 = Pattern.compile(cond3);
        String cond4 = "\\d";
        Pattern pat4 = Pattern.compile(cond4);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Matcher mat2 = pat2.matcher(input);
        Matcher mat3 = pat3.matcher(input);
        Matcher mat4 = pat4.matcher(input);

        if (input.matches(cond1)){
            if (mat2.find()){
                if (mat3.find()){
                    if (mat4.find()){System.out.println("You're safe");}
                    else{System.out.println("Password must contain a digit");}
                }
                else{System.out.println("Password must contain at least 1 UPPERCASE letter");}
            }
            else{System.out.println("Password must contain at least 1 lowercase letter");}
        }
        else{System.out.println("Incorrect length or special symbols included");}
    }
}
